import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cours implements Operation, Serializable {
    private static final long serialVersionUID = 1L;
    
    private String codeCours;
    private String nomCours;
    private String numSalle;
    private double coef;
    private List<Etudiant> etudiants;
    private Professeur professeur;

    public Cours(String codeCours, String nomCours, String numSalle, double coef) {
        this.codeCours = codeCours;
        this.nomCours = nomCours;
        this.numSalle = numSalle;
        this.coef = coef;
        this.etudiants = new ArrayList<>();
    }


    @Override
    public void Affecte_Salle(String codeCours, String numSalle, Date date) {
        if (this.codeCours.equals(codeCours)) {
            this.numSalle = numSalle;
            System.out.println("Salle " + numSalle + " affectée au cours " + codeCours + " pour la date " + date);
        }
    }

    @Override
    public void Affecte_Prof(String codeCours, String idProf) {
        if (this.codeCours.equals(codeCours)) {
            Professeur prof = rechercherProfesseurParId(idProf);
            if (prof != null) {
                this.professeur = prof;
                System.out.println("Professeur " + idProf + " affecté au cours " + codeCours);
            }
        }
    }

    private Professeur rechercherProfesseurParId(String idProf) {
        return null;
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        this.etudiants.add(etudiant);
    }

    public static void Affiche_Cours_Etudiant(List<Cours> coursList, String idEtd) {
        System.out.println("Cours assistés par l'étudiant ID " + idEtd + ":");
        for (Cours cours : coursList) {
            for (Etudiant etudiant : cours.getEtudiants()) {
                if (etudiant.getIdEtd().equals(idEtd)) {
                    System.out.println(cours.getNomCours());
                }
            }
        }
    }

    public static void Affiche_Cours_Prof(List<Cours> coursList, String idProf) {
        System.out.println("Cours donnés par le professeur ID " + idProf + ":");
        for (Cours cours : coursList) {
            if (cours.getProfesseur() != null && cours.getProfesseur().getIdProf().equals(idProf)) {
                System.out.println(cours.getNomCours());
            }
        }
    }

    public static void Affiche_Nb_Etudiant(List<Cours> coursList, String codeCours) {
        for (Cours cours : coursList) {
            if (cours.getCodeCours().equals(codeCours)) {
                System.out.println("Nombre d'étudiants pour le cours " + codeCours + ": " + cours.getEtudiants().size());
                return;
            }
        }
        System.out.println("Cours avec le code " + codeCours + " non trouvé.");
    }

    public String getCodeCours() {
        return codeCours;
    }

    public void setCodeCours(String codeCours) {
        this.codeCours = codeCours;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public String getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(String numSalle) {
        this.numSalle = numSalle;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
}
