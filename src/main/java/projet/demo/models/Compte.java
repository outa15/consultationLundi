package projet.demo.models;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;


import com.fasterxml.jackson.annotation.*;

@Table
@Entity(name="compte")
 // @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") 
public class Compte {

        @Id 
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;
    
   // @NonNull
    @Column(name = "email")
    String email ;

   // @NonNull
    @Column(name = "password")
    String password ;

    @Column(name = "role")
    String role ;

    @Column(name = "message")
    String message ;

    @Column(name = "reponse")
    String reponse ;
   

    //pour relation one to one avec compte mapped by "personne"
   // @OneToOne(fetch = FetchType.LAZY, optional = false)
   @OneToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "personne_id", nullable = false)
    private Personne personne;

    

    public Compte(int id,String email, String password, String role, String message, String reponse) {
        this.email=email;
        this.password = password;
        this.role = role;
        this.message = message;
        this.reponse=reponse;
    }

    public Compte() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse= reponse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        if(personne instanceof Personne){
        this.personne = personne;}
    }

    

    



}