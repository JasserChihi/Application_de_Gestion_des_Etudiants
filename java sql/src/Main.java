import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestion des Étudiants - Interface Utilisateur");

        Label titleLabel = new Label("Gestion des Étudiants");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        
        Label subtitleLabel = new Label("Veuillez entrer les informations de l'étudiant ci-dessous :");
        subtitleLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));

        Label labelIdEtd = new Label("ID de l'étudiant:");
        TextField textIdEtd = new TextField();
        textIdEtd.setPromptText("Ex: 123456");

        Label labelNom = new Label("Nom:");
        TextField textNom = new TextField();
        textNom.setPromptText("Ex: Chihi où Moalla");

        Label labelPrenom = new Label("Prénom:");
        TextField textPrenom = new TextField();
        textPrenom.setPromptText("Ex: Jasser où Mahmoud");

        Label labelAdresse = new Label("Adresse:");
        TextField textAdresse = new TextField();
        textAdresse.setPromptText("Ex: 123 Rue Exemple");

        Label labelSection = new Label("Section:");
        TextField textSection = new TextField();
        textSection.setPromptText("Ex: Informatique");

        Button buttonSubmit = new Button("Enregistrer");
        Button buttonAfficher = new Button("Afficher Étudiants");

        labelIdEtd.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        labelNom.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        labelPrenom.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        labelAdresse.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        labelSection.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        buttonSubmit.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");
        buttonAfficher.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px;");

        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Succès");
        successAlert.setHeaderText(null);

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Erreur");
        errorAlert.setHeaderText(null);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(labelIdEtd, 0, 0);
        gridPane.add(textIdEtd, 1, 0);
        gridPane.add(labelNom, 0, 1);
        gridPane.add(textNom, 1, 1);
        gridPane.add(labelPrenom, 0, 2);
        gridPane.add(textPrenom, 1, 2);
        gridPane.add(labelAdresse, 0, 3);
        gridPane.add(textAdresse, 1, 3);
        gridPane.add(labelSection, 0, 4);
        gridPane.add(textSection, 1, 4);

        HBox buttonBox = new HBox(10, buttonSubmit, buttonAfficher);
        buttonBox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20, titleLabel, subtitleLabel, gridPane, buttonBox);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        buttonSubmit.setOnAction(e -> {
            String idEtd = textIdEtd.getText();
            String nom = textNom.getText();
            String prenom = textPrenom.getText();
            String adresse = textAdresse.getText();
            String section = textSection.getText();

            if (idEtd.isEmpty() || nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || section.isEmpty()) {
                errorAlert.setContentText("Tous les champs doivent être remplis.");
                errorAlert.showAndWait();
            } else {
                Etudiant etudiant = new Etudiant(idEtd, nom, prenom, adresse, section);
                EtudiantDb etudiantDb = new EtudiantDb();
                etudiantDb.createEtudiant(etudiant);

                textIdEtd.clear();
                textNom.clear();
                textPrenom.clear();
                textAdresse.clear();
                textSection.clear();

                successAlert.setContentText("Étudiant ajouté avec succès!");
                successAlert.showAndWait();
            }
        });

        buttonAfficher.setOnAction(e -> {
            EtudiantDb etudiantDb = new EtudiantDb();
            List<Etudiant> etudiants = etudiantDb.readAllEtudiants();
            
            Stage stage = new Stage();
            stage.setTitle("Liste des Étudiants");

            Label listTitle = new Label("Liste des Étudiants");
            listTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            listTitle.setAlignment(Pos.CENTER);

            TableView<Etudiant> tableView = new TableView<>();
            TableColumn<Etudiant, String> columnIdEtd = new TableColumn<>("ID de l'étudiant");
            columnIdEtd.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdEtd()));
            TableColumn<Etudiant, String> columnNom = new TableColumn<>("Nom");
            columnNom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
            TableColumn<Etudiant, String> columnPrenom = new TableColumn<>("Prénom");
            columnPrenom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));
            TableColumn<Etudiant, String> columnAdresse = new TableColumn<>("Adresse");
            columnAdresse.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdresse()));
            TableColumn<Etudiant, String> columnSection = new TableColumn<>("Section");
            columnSection.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSection()));

            tableView.getColumns().addAll(columnIdEtd, columnNom, columnPrenom, columnAdresse, columnSection);
            tableView.getItems().addAll(etudiants);

            VBox vboxTable = new VBox(10, listTitle, tableView);
            vboxTable.setAlignment(Pos.CENTER);
            vboxTable.setPadding(new Insets(10));
            Scene sceneTable = new Scene(vboxTable, 600, 400);
            stage.setScene(sceneTable);
            stage.show();
        });

        Scene scene = new Scene(vbox, 450, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
