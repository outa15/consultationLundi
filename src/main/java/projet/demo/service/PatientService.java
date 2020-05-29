package projet.demo.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import projet.demo.models.Patient;
import projet.demo.repository.PatientRepository;

@Service
public class PatientService {
    @Autowired 
     PatientRepository patientRepository;

     List <Patient> patients= new ArrayList<Patient>();
    

   public Patient getPatientById(Long id_patient){
       
       patients  =( List <Patient>) patientRepository.findAll();
       for (Patient patient :patients){
                if(patient.getId()==id_patient)
                return patient;

       }
        return null;
   }

}