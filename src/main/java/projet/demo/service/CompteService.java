
package projet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import projet.demo.models.Compte;
import projet.demo.repository.CompteRepository;
import projet.demo.repository.MedecinRepository;
import java.util.*;
@Service
public class CompteService {
    @Autowired
    CompteRepository compteRepository;
    
    public List <Compte> findComptesPatient (){

        List <Compte> comptePatients = new ArrayList<Compte> ();
        List <Compte> compteNew = new ArrayList<Compte> ();
        comptePatients=(List <Compte>) compteRepository.findAll();
        for (Compte c : comptePatients){
            if(c.getRole().equals("PATIENT")){
                compteNew.add(c);
                System.out.println("bouchra : "+c.getEmail());

            }
            
        }
        return compteNew;
}
}