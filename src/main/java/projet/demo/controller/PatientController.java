package projet.demo.controller;
import projet.demo.models.Patient;
import projet.demo.repository.PatientRepository;
import projet.demo.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1") 
public class PatientController {
        
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PatientService PatientService;

    @PostMapping("/patient")
    public Patient addPatient(@Valid @RequestBody Patient patient){
        return patientRepository.save(patient);
    } 
    @GetMapping("/patient/{id}")
    public Patient findPatient (@PathVariable (value="id") Long id_patient){
        return PatientService.getPatientById(id_patient);
    }
    @GetMapping("/patient")
    public List <Patient > findAllPatients (){
        return(List <Patient>)patientRepository.findAll();
    }
    
    @DeleteMapping("/patient/{id}")
    public void deletePersonne(@PathVariable(value = "id") final Long id){    
        patientRepository.deleteById(id);
    }

}