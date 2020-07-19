package projet.demo.dto;

import projet.demo.models.Statut;

public class ConsultationDto {


        Long id;        
        //private LocalDateTime dateDebut; // 
        private String dateDebut;
        //private LocalDateTime dateFin;
        private String dateFin;
       
        private String details;

        private Long montant;

        private Statut statut;

        private String symptomes;

        private String traitement;

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
}