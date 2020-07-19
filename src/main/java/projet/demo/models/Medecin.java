package projet.demo.models;
import javax.persistence.*;
import java.util.*;


// ca concerne l'héritage Personne --> Medecin 
@Entity
@Table(name = "medecin")
@PrimaryKeyJoinColumn(name = "id")

public class Medecin extends Personne {
    @Column(name = "specialite")
    String specialite ;


    @OneToMany(mappedBy = "medecin", fetch = FetchType.EAGER)
    private List<Consultation> consultations;

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public List<Consultation> getConsultations() {
        return consultations;
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

    
    
}