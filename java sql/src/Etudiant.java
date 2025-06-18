import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Etudiant implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idEtd;
    private String nom;
    private String prenom;
    private String adresse;
    private String section;
    private List<Cours> coursInscrits;

    public Etudiant(String idEtd, String nom, String prenom, String adresse, String section) {
        this.idEtd = idEtd;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.section = section;
        this.coursInscrits = new ArrayList<>();
    }

    public String getIdEtd() {
        return idEtd;
    }

    public void setIdEtd(String idEtd) {
        this.idEtd = idEtd;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<Cours> getCoursInscrits() {
        return coursInscrits;
    }

    public void inscrireCours(Cours cours) {
        coursInscrits.add(cours);
        cours.ajouterEtudiant(this);
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "idEtd='" + idEtd + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", section='" + section + '\'' +
                '}';
    }
}
