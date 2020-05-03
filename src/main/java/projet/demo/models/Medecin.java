package projet.demo.models;
import javax.persistence.*;


@Entity
@Table(name = "Medecin")
@PrimaryKeyJoinColumn(name = "id")
public class Medecin extends Personne{

}