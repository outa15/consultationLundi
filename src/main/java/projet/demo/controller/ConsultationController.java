package projet.demo.controller;

import projet.demo.exceptions.ResourceNotFoundException;
import projet.demo.models.Consultation;
import projet.demo.repository.ConsultationRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ConsultationController {
    @Autowired
    ConsultationRepository consultationRepository;
    
   
    @GetMapping(value="/consultations")
    public List<Consultation> getAllConsultations() {
        return (List<Consultation>)consultationRepository.findAll();
    }
    
    @GetMapping ("/consultations/{id}")
    public Optional <Consultation> getConsultationById(@PathVariable (value="id") Long id_consultation){
           return  consultationRepository.findById(id_consultation);
    } 

   /* @GetMapping("/consultations/{tabIdConsultations}")
    public  List <Consultation> getConsultationsByIds(@PathVariable  Long [] tabIdConsultations ) throws Exception{
        List<Consultation> consultations = new ArrayList <Consultation> ();
        for (Long id :tabIdConsultations ){
           consultations.add(consultationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Consultation not found with id"+id)));
        }

        return consultations;
        

    } */


    // a refaire
   /* @GetMapping("/consultations/{id}")
    public ResponseEntity<Consultation> getConsultationsById(@PathVariable(value = "id") Long consultationId)
     *       throws ResourceNotFoundException {
        Consultation consultation = consultationRepository.findById(
                consultationId);
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found for this id :: " + consultationId));
        return ResponseEntity.ok().body(consultation);
    } */ 
    

    @PostMapping(value="consultaion")
    public Consultation ajouterConsultation (@Valid @RequestBody Consultation consultation){
        return consultationRepository.save(consultation);
    }
    
    @DeleteMapping("/consultations/{id}")
    public void deleteConsultation(@PathVariable(value = "id") final Long id){    
        consultationRepository.deleteById(id);
    }

}