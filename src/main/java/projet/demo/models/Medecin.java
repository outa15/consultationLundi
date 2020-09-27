package projet.demo.models;
import javax.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.*;

// ca concerne l'héritage Personne --> Medecin 
@Entity
@Table(name = "medecin")
@PrimaryKeyJoinColumn(name = "id")

public class Medecin extends Personne {
    @Column(name = "specialite")
    String specialite ;


  @OneToMany(mappedBy = "medecin")
    private List<Consultation> consultations; 

    @OneToMany(mappedBy = "medecinn")
    @JsonBackReference
    private List<Reservation> reservations;


    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

  public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
        
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
        
    }
 
    public Medecin() {
    }

    public Medecin(String specialite, List<Consultation> consultations) {
        this.specialite = specialite;
        this.consultations = consultations;
    }
    public Medecin(String specialite) {
        this.specialite = specialite;
       
    }




    
    
}