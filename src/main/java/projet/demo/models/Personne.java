package projet.demo.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
@Entity
@Table(name = "personne")
@Inheritance(strategy = InheritanceType.JOINED)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Personne {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;

        @Column(name = "nom")
        String nom;

       
      
  /*  // relation One to one avec compte
    @OneToOne(fetch = FetchType.EAGER,
    cascade =  CascadeType.ALL,
    mappedBy = "personne") // on trouvera dans compte personne_id */


        @OneToOne(fetch = FetchType.EAGER,mappedBy = "personne")
        private Compte compte; 

        @Column(name = "prenom")
        String prenom;

        @Column(name = "telephone")
        String telephone;

       

        @Enumerated(EnumType.STRING)
        @Column(name = "role" )
        Role role;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public Compte getCompte() {
            return compte;
        }

        public void setCompte(Compte compte) {
            if(compte instanceof Compte){
            this.compte = compte;}
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public Role getRole() {
            return role;
        }

        public void setRole(Role role) {
            this.role = role;
        }

       
      

      
}