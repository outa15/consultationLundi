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
import projet.demo.service.CompteService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class CompteController {
    
    @Autowired
    CompteRepository compteRepository;
    @Autowired
    CompteService compteService ;
    
    @Autowired
    CompteService compteServicee ;


    @GetMapping(value="/compte")
    public List <Compte> findComptesPatient (){
        return (List <Compte>)compteService.findComptesPatient();

    }
    
}