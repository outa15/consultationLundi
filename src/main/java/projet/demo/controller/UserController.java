package projet.demo.controller;
import java.security.Principal;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.demo.repository.ConsultationRepository;
import projet.demo.repository.PersonneRepository;
import projet.demo.repository.CompteRepository;

import projet.demo.models.Compte;
import org.springframework.web.bind.annotation.RestController;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    CompteRepository compteRepository;

    @RequestMapping("/login")
    public Compte login(@RequestBody Compte compte ) {
        return compteRepository.findByEmailAndPassword(compte.getEmail(),compte.getPassword());
//      System.out.println(compte.getEmail());
//      return compte.getEmail().equals("email") && compte.getPassword().equals("password");
    }
     
    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder().decode(authToken)).split(":")[0];
    }

   
}