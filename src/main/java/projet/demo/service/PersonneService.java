package projet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.demo.repository.PersonneRepository;

import projet.demo.models.Personne;
import java.util.*;
import projet.demo.models.Role;

@Service
public class PersonneService {
    
    @Autowired
    PersonneRepository personneRepository;

   // fonction d'affichage des patient role=patient
    public List<Personne> findPatient(){
        List<Personne> personnes = new ArrayList<Personne>();
        List<Personne> patients = new ArrayList<Personne>();
        personnes=( List<Personne>)personneRepository.findAll();
        for ( Personne personne :personnes){
            if(personne.getRole().equals(Role.PATIENT)){
                patients.add(personne);
            }
        } 
        return patients; 
       
      


    }

}