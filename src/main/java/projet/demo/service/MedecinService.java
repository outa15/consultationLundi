package projet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import projet.demo.repository.MedecinRepository;




@Service
public class MedecinService {
    @Autowired
    MedecinRepository medecinRepository;
   

   

}