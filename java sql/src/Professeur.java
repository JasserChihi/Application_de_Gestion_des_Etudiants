import java.util.ArrayList;
import java.util.List;

public class Professeur {
    private String idProf;
    private String nom;
    private String prenom;
    private String idDep;
    private List<Cours> coursEnseignes;

    public Professeur(String idProf, String nom, String prenom, String idDep) {
        this.idProf = idProf;
        this.nom = nom;
        this.prenom = prenom;
        this.idDep = idDep;
        this.coursEnseignes = new ArrayList<>();
    }

    public String getIdProf() {
        return idProf;
    }

    public void setIdProf(String idProf) {
        this.idProf = idProf;
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

    public String getIdDep() {
        return idDep;
    }

    public void setIdDep(String idDep) {
        this.idDep = idDep;
    }

    public List<Cours> getCoursEnseignes() {
        return coursEnseignes;
    }

    public void enseignerCours(Cours cours) {
        coursEnseignes.add(cours);
        cours.setProfesseur(this);
    }
}
