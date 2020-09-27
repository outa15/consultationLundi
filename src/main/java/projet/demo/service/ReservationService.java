package projet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.demo.controller.ReservationController;

@Service
public class ReservationService {
    @Autowired
     ReservationController reservationController;
}