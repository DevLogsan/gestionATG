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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import modele.GestionMembre;
import modele.Bureau;

/**
 * FXML Controller class
 *
 * @author Logan
 */
public class FenFXML_bureauController implements Initializable {
    @FXML
    private Label lblMessage;
    @FXML
    private TableView<Bureau> tvMembres; // Même nom que le TableView de l'interface graphique
    @FXML
    private TableColumn<Bureau, Integer> colonneId; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Bureau, String> colonneFonction; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Bureau, String> colonneNom; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Bureau, String> colonnePrenom; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Bureau, String> colonneAdresse; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Bureau, String> colonneCP; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Bureau, String> colonneVille; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Bureau, String> colonneEmail; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Bureau, String> colonnePortable; // Même nom que la colonne du TableView
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Bureau> lesMembres = FXCollections.observableArrayList();
        
        lesMembres = GestionMembre.listeMembres();
        
        System.out.println("NOMBRE:" + lesMembres.size());
        tvMembres.setItems(lesMembres);
        
        // Initialise le TableView tvEtudiants
        colonneId.setCellValueFactory(new PropertyValueFactory<Bureau, Integer>("id"));
        colonneFonction.setCellValueFactory(new PropertyValueFactory<Bureau, String>("fonction"));
        colonneNom.setCellValueFactory(new PropertyValueFactory<Bureau, String>("nom"));
        colonnePrenom.setCellValueFactory(new PropertyValueFactory<Bureau, String>("prenom"));
        colonneAdresse.setCellValueFactory(new PropertyValueFactory<Bureau, String>("adresse"));
        colonneCP.setCellValueFactory(new PropertyValueFactory<Bureau, String>("cp"));
        colonneVille.setCellValueFactory(new PropertyValueFactory<Bureau, String>("ville"));
        colonneEmail.setCellValueFactory(new PropertyValueFactory<Bureau, String>("email"));
        colonnePortable.setCellValueFactory(new PropertyValueFactory<Bureau, String>("telPortable"));
        
        // Pour redimensionner les colonnes automatiquement
        tvMembres.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }
}