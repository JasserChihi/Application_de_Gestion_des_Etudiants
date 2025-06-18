import java.util.Date;

public interface Operation {
    void Affecte_Salle(String codeCours, String numSalle, Date date);
    void Affecte_Prof(String codeCours, String idProf);
}