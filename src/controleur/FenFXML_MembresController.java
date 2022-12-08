/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.GestionMembre;
import modele.Membre;

/**
 * FXML Controller class
 *
 * @author Logan
 */
public class FenFXML_MembresController implements Initializable {
    @FXML
    private Label lblMessage;
    @FXML
    private TableView<Membre> tvMembresDon; // Même nom que le TableView de l'interface graphique
    @FXML
    private TableColumn<Membre, Integer> colonneId; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Membre, String> colonneTitre; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Membre, String> colonneNom; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Membre, String> colonnePrenom; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Membre, String> colonneAdresse; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Membre, String> colonneCP; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Membre, String> colonneVille; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Membre, String> colonneEmail; // Même nom que la colonne du TableView
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Membre> lesMembres = FXCollections.observableArrayList();
        
        lesMembres = GestionMembre.listeMembresDons();
        tvMembresDon.setItems(lesMembres);
        
        // Initialise le TableView tvEtudiants
        colonneId.setCellValueFactory(new PropertyValueFactory<Membre, Integer>("id"));
        colonneTitre.setCellValueFactory(new PropertyValueFactory<Membre, String>("titre"));
        colonneNom.setCellValueFactory(new PropertyValueFactory<Membre, String>("nom"));
        colonnePrenom.setCellValueFactory(new PropertyValueFactory<Membre, String>("prenom"));
        colonneAdresse.setCellValueFactory(new PropertyValueFactory<Membre, String>("adresse"));
        colonneCP.setCellValueFactory(new PropertyValueFactory<Membre, String>("cp"));
        colonneVille.setCellValueFactory(new PropertyValueFactory<Membre, String>("ville"));
        colonneEmail.setCellValueFactory(new PropertyValueFactory<Membre, String>("email"));
        // Pour redimensionner les colonnes automatiquement
        tvMembresDon.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}
