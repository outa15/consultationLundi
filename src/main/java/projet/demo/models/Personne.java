package projet.demo.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import javax.persistence.GenerationType;
import javax.persistence.Id;



import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Table(name = "personne")
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;

        @Column(name = "nom")
        String nom;

        @Column(name = "prenom")
        String prenom;

        @Column(name = "telephone")
        int telephone;

       

        @Enumerated(EnumType.STRING)
        @Column(name = "role" )
        Role role;

        public Long getId() {
            return id;
        }

        public void setId(final Long id) {
            this.id = id;
        }
        
        public String getNom() {
            return nom;
        }

        public void setNom(final String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }


        public Role getRole() {
            return role;
        }

        public void setPrenom(final String prenom) {
            this.prenom = prenom;
        }
        
        public int getTelephone() {
            return telephone;
        }

        public void setTelephone(final int telephone) {
            this.telephone = telephone;
        }

        public void setRole(final Role role) {
            this.role = role;
        }
}
