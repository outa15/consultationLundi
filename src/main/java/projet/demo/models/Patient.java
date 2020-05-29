package projet.demo.models;
import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "patient")
@PrimaryKeyJoinColumn(name = "id")
public class Patient extends Personne  {

        @Column(name = "date_naissance")
        String date_naissance ;

        @Column(name = "lieu_naissance")
        String lieu_naissance ;

        @Column(name = "nationalite")
        String nationalite ;

        @Column(name = "civilite")
        String civilite ;

        @Column(name = "situation_familial")
        String situation_familial;

        @Column(name = "ville")
        String ville ;

        @Column(name = "accompagnateur")
        String  accompagnateur;

        @Column(name = "lien_familial")
        String lien_familial;

        @Column(name = "profession")
        String profession ;

        @Column(name = "adresse")
        String adresse;

        @Column(name = "groupe_sanguin")
        String groupe_sanguin ;

        @OneToMany(mappedBy = "patient")
        private List<Consultation> consultations;

 
        public String getDate_naissance() {
            return date_naissance;
        }

        public void setDate_naissance(String date_naissance) {
            this.date_naissance = date_naissance;
        }

        public String getLieu_naissance() {
            return lieu_naissance;
        }

        public void setLieu_naissance(String lieu_naissance) {
            this.lieu_naissance = lieu_naissance;
        }

        public String getNationalite() {
            return nationalite;
        }

        public void setNationalite(String nationalite) {
            this.nationalite = nationalite;
        }

        public String getCivilite() {
            return civilite;
        }

        public void setCivilite(String civilite) {
            this.civilite = civilite;
        }

        public String getSituation_familial() {
            return situation_familial;
        }

        public void setSituation_familial(String situation_familial) {
            this.situation_familial = situation_familial;
        }

        public String getVille() {
            return ville;
        }

        public void setVille(String ville) {
            this.ville = ville;
        }

        public String getAccompagnateur() {
            return accompagnateur;
        }

        public void setAccompagnateur(String accompagnateur) {
            this.accompagnateur = accompagnateur;
        }

        public String getLien_familial() {
            return lien_familial;
        }

        public void setLien_familial(String lien_familial) {
            this.lien_familial = lien_familial;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public String getAdresse() {
            return adresse;
        }

        public void setAdresse(String adresse) {
            this.adresse = adresse;
        }

        public String getGroupe_sanguin() {
            return groupe_sanguin;
        }

        public void setGroupe_sanguin(String groupe_sanguin) {
            this.groupe_sanguin = groupe_sanguin;
        }

        public List<Consultation> getConsultations() {
            return consultations;
        }

        public void setConsultations(List<Consultation> consultations) {
            this.consultations = consultations;
        }
    } 
    