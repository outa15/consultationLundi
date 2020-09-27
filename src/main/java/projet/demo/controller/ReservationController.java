package projet.demo.controller;
import java.util.*;

import javax.validation.Valid;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import projet.demo.models.*;
import projet.demo.repository.*;
import projet.demo.service.*;


@RestController @CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/api/v1")

public class ReservationController {
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    MedecinRepository medecinRepository;

    @Autowired
    ReservationService reservationService;


    @GetMapping(value="/reservation")
    public List <Reservation> fidnReservation (){
        return(List <Reservation>) reservationRepository.findAll();
    }

    
  
    @PostMapping(value = "/reservation/{id_patient}/{id_medecin}", consumes = "application/json;charset=UTF-8")
    public Reservation addReservation( @RequestBody Reservation reservation, @PathVariable(value = "id_patient") final Long id_patient,@PathVariable(value = "id_medecin") final Long id_medecin){
        reservation.setPatientt(patientRepository.findById(id_patient).get());
        reservation.setMedecinn(medecinRepository.findById(id_medecin).get());
        return reservationRepository.save(reservation);
    } 

    
}