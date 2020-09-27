package projet.demo.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
@Table
@Entity(name="reservation")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Reservation { 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    
    @Column(name = "date")
    String date ;
    @Column(name = "heure")
    int heure ;

    @Column(name = "disponibilite")
    String disponibilite ;

    //////////////////////////mappé b patientt
    @ManyToOne(fetch = FetchType.EAGER)
        private Patient patientt;
    ////////////////////////
    @ManyToOne(fetch = FetchType.EAGER)
    private Medecin medecinn;

        public Reservation() {
        }

        public Reservation(Long id_reservation, String date, int heure , Patient patient) {
            this.id= id_reservation;
            
            this.date = date;
            this.heure = heure;
            this.patientt = patient;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id_reservation) {
            this.id = id_reservation;
        }

        public int getHeure() {
            return heure;
        }
        public void setHeure(int heure) {
            this.heure = heure;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDate() {
            return date;
        }

        public String getDisponibilite(){
            return disponibilite;
        }

        
        public void setDisponibilite(String disponibilite){
             this.disponibilite=disponibilite;
        }

       public Patient getPatientt() {
            return patientt;
        }

        public void setPatientt(Patient patient) {
            this.patientt = patient;
        } 
        
       public Medecin getMedecinn() {
        return medecinn;
    }

    public void setMedecinn(Medecin medecin) {
        this.medecinn = medecin;
    } 

        

}