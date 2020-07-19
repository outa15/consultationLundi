package projet.demo.models;
//hadi katjib koulchi les import 
import javax.persistence.*;
//
import com.fasterxml.jackson.annotation.*;
//import java.time.LocalDateTime;

@Table
@Entity(name="consultation")
// property = "id" pour eviter les boucles , on ne prend que l'id de la table medecin ou patient  pour ne pas repeter une liste de consultations
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Consultation {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;
        
        

        @Column(name = "date_debut")
        //private LocalDateTime dateDebut; // 
        private String dateDebut;
        @Column(name = "date_fin")
        //private LocalDateTime dateFin;
        private String dateFin;
       
        @Column(name = "details")
        private String details;

        @Column(name = "montant")
        private Long montant;

        @Enumerated(EnumType.STRING)
        @Column(name = "statut")
        private Statut statut;

        @Column(name = "symptomes")
        private String symptomes;

        @Column(name = "traitement")
        private String traitement;

        

        @ManyToOne(fetch = FetchType.EAGER)
        @JsonManagedReference
        private Patient patient;
        
        // traduction de la relation un medecin peut faire plsrs 
        @ManyToOne(fetch = FetchType.EAGER)
        @JsonManagedReference
        private Medecin medecin;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getDateDebut() {
                return dateDebut;
        }

        public void setDateDebut(String dateDebut) {
                this.dateDebut = dateDebut;
        }

        public String getDateFin() {
                return dateFin;
        }

        public void setDateFin(String dateFin) {
                this.dateFin = dateFin;
        }

        public String getTraitement() {
                return traitement;
        }

        public void setTraitement(String traitement) {
                this.traitement = traitement;
        }

        public String getSymptomes() {
                return symptomes;
        }

        public void setSymptomes(String symptomes) {
                this.symptomes = symptomes;
        }

        public String getDetails() {
                return details;
        }

        public void setDetails(String details) {
                this.details = details;
        }

        public Statut getStatut() {
                return statut;
        }

        public void setStatut(Statut statut) {
                this.statut = statut;
        }

        public Long getMontant() {
                return montant;
        }

        public void setMontant(Long montant) {
                this.montant = montant;
        }

        @JsonManagedReference
        public Medecin getMedecin() {
                return medecin;
        }

        public void setMedecin(Medecin medecin) {
                if(medecin instanceof Medecin){
                        this.medecin = medecin;
                }
                
        }
        @JsonManagedReference
        public Patient getPatient() {
                return patient;
        }

        public void setPatient(Patient patient) {
                if(patient instanceof Patient){
                        this.patient = patient;
                }
                
        }
      
       

}