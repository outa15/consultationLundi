package projet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import projet.demo.exceptions.ResourceNotFoundException;
import projet.demo.models.Consultation;
import projet.demo.repository.ConsultationRepository;
import java.util.*;

import javax.annotation.Resource;


@Service
public class ConsultationService {
    @Autowired
    ConsultationRepository consultationRepository;

   

}