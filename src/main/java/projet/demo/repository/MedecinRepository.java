package projet.demo.repository;

import org.springframework.data.repository.CrudRepository;

import projet.demo.models.Medecin;

public interface MedecinRepository extends CrudRepository< Medecin , Long> {
  
}