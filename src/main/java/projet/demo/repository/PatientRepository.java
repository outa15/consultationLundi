package projet.demo.repository;
import projet.demo.models.Patient;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long>{

}