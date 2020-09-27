package projet.demo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;

import projet.demo.dto.ConsultationDto;
import projet.demo.exceptions.ResourceNotFoundException;
import projet.demo.models.Consultation;
import projet.demo.repository.ConsultationRepository;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
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
        if(id_consultation != null){
            return  consultationRepository.findById(id_consultation);
        }
        return null;
    }
    @PutMapping(value = "/consultations", produces = { "application/json", "application/xml" }, consumes = {MediaType.ALL_VALUE})
    public Consultation updateConsultation (@RequestBody ConsultationDto consultationdto){
        Consultation maConsultation = new Consultation();
        maConsultation.setId(consultationdto.getId());
        maConsultation.setDateDebut(consultationdto.getDateDebut());
        maConsultation.setDateFin(consultationdto.getDateFin());
        maConsultation.setDetails(consultationdto.getDetails());
        maConsultation.setMontant(consultationdto.getMontant());
        maConsultation.setTraitement(consultationdto.getSymptomes());
        maConsultation.setSymptomes(consultationdto.getSymptomes());
        return consultationRepository.save(maConsultation);
    }
    



    @PostMapping(value="consultaions")
    public Consultation ajouterConsultation (@Valid @RequestBody Consultation consultation){
        return consultationRepository.save(consultation);
    }
    
    @DeleteMapping("/consultations/{id}")
    public void deleteConsultation(@PathVariable(value = "id") final Long id){    
        consultationRepository.deleteById(id);
    }

   /*
    @PutMapping("/consultations/{id}")
    public ResponseEntity<Consultation> UpdateConsultation (@PathVariable (value="id") Long id_Consultation, @Valid @RequestBody Consultation consultation) throws ResourceNotFoundException{
        
    Consultation consult = consultationRepository.findById(id_Consultation).orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found for this id :: " + id_Consultation));
    
    consult.setDateDebut(consultation.getDateDebut());
    consult.setDateFin(consultation.getDateFin());
    consult.setTraitement(consultation.getTraitement());

    consult.setSymptomes(consultation.getSymptomes());
    consult.setDetails(consultation.getDetails());

    consult.setStatut(consultation.getStatut());
    consult.setMontant(consultation.getMontant());

   // consult.setMedecin(consultation.getMedecin());
   // consult.setPatient(consultation.getPatient());
   final  Consultation Updatedconsultt =  consultationRepository.save(consult);                       


          return ResponseEntity.ok(Updatedconsultt);
    } */

    

}