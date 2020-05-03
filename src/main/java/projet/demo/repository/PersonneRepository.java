package projet.demo.repository;
import org.springframework.data.repository.CrudRepository;

import projet.demo.models.Personne;

public interface PersonneRepository extends CrudRepository<Personne, Long> {
    
    
}