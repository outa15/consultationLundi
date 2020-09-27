package projet.demo.repository;
import org.springframework.data.repository.CrudRepository;

import projet.demo.models.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    
    
}