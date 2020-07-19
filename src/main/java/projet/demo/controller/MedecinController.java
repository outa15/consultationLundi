package projet.demo.controller;



import org.springframework.web.bind.annotation.CrossOrigin;


import org.springframework.web.bind.annotation.RequestMapping;

import projet.demo.models.Medecin;
import projet.demo.repository.MedecinRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController @CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/api/v1")
public class MedecinController {

    @Autowired
     MedecinRepository medecinRepository ;

     @GetMapping(value="/medecin/{id}")
     public  Optional <Medecin> findMedecin (@PathVariable (value="id") Long id_medecin) throws IllegalArgumentException {
            return medecinRepository.findById(id_medecin);
     }
     @GetMapping(value="/medecin")
     public List<Medecin> findMedecinList() {
            return (List <Medecin>) medecinRepository.findAll();
     }

}