package projet.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import projet.demo.models.Compte;

public interface CompteRepository extends CrudRepository<Compte,Long>{
    Compte findByEmailAndPassword(String email, String password);
}