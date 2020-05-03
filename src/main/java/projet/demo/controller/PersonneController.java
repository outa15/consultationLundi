package projet.demo.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import projet.demo.models.Personne;

import projet.demo.repository.PersonneRepository;
import projet.demo.service.PersonneService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


@RestController @CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/api/v1")
public class PersonneController {

        @Autowired
        PersonneRepository personneRepository;
        
        

        @Autowired
        PersonneService personneService;
        
        @GetMapping("/personne")
        public Iterable<Personne> getAllPersonnes () {       
                return personneService.findPatient();
        }

        @GetMapping("/personne/{id}")
        public Optional<Personne> getPersonneId(@PathVariable final  Long id) throws IllegalArgumentException {
                return personneRepository.findById(id);
        }
             
        @DeleteMapping("/personne/{id}")
        public void deletePersonne(@PathVariable(value = "id") final Long id){    
                personneRepository.deleteById(id);
        }

        @PostMapping("/personne")
        public Personne addPersonne(@Valid @RequestBody Personne personne) {
                return  personneRepository.save(personne);
        }

}
