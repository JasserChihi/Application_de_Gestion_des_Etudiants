import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDb {

    public void createEtudiant(Etudiant etudiant) {
        String SQL = "INSERT INTO Etudiant (IdEtd, Nom, Prenom, Adresse, Section) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, etudiant.getIdEtd());
            pstmt.setString(2, etudiant.getNom());
            pstmt.setString(3, etudiant.getPrenom());
            pstmt.setString(4, etudiant.getAdresse());
            pstmt.setString(5, etudiant.getSection());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Étudiant ajouté avec succès !");
            } else {
                System.out.println("Erreur lors de l'ajout de l'étudiant.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Etudiant> readAllEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        String SQL = "SELECT * FROM Etudiant";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Etudiant etudiant = new Etudiant(
                        rs.getString("IdEtd"),
                        rs.getString("Nom"),
                        rs.getString("Prenom"),
                        rs.getString("Adresse"),
                        rs.getString("Section")
                );
                etudiants.add(etudiant);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return etudiants;
    }

    public Etudiant readEtudiant(String idEtd) {
        String SQL = "SELECT * FROM Etudiant WHERE IdEtd = ?";
        Etudiant etudiant = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, idEtd);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                etudiant = new Etudiant(
                        rs.getString("IdEtd"),
                        rs.getString("Nom"),
                        rs.getString("Prenom"),
                        rs.getString("Adresse"),
                        rs.getString("Section")
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return etudiant;
    }

    public void updateEtudiant(Etudiant etudiant) {
        String SQL = "UPDATE Etudiant SET Nom = ?, Prenom = ?, Adresse = ?, Section = ? WHERE IdEtd = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, etudiant.getNom());
            pstmt.setString(2, etudiant.getPrenom());
            pstmt.setString(3, etudiant.getAdresse());
            pstmt.setString(4, etudiant.getSection());
            pstmt.setString(5, etudiant.getIdEtd());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Étudiant mis à jour avec succès !");
            } else {
                System.out.println("Erreur lors de la mise à jour de l'étudiant.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteEtudiant(String idEtd) {
        String SQL = "DELETE FROM Etudiant WHERE IdEtd = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, idEtd);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Étudiant supprimé avec succès !");
            } else {
                System.out.println("Erreur lors de la suppression de l'étudiant.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
