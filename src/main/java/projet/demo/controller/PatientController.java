package projet.demo.controller;
import projet.demo.models.Patient;
import projet.demo.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class PatientController {
        
    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/patient")
    public Patient addPatient(@Valid @RequestBody Patient patient){
        return patientRepository.save(patient);
    } 

}