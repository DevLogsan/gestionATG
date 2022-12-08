/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import modele.GestionBureau;
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
    
    @FXML
    private Stage premierStage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Bureau> lesBureaux = FXCollections.observableArrayList();
        
        lesBureaux = GestionBureau.listeBureaux();
        tvMembres.setItems(lesBureaux);
        
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
    
    @FXML
    private void handleInsererBureau()
    {
        try
        {
            premierStage = new Stage();
            premierStage.setTitle("Modification des infos");
            FXMLLoader loader = new FXMLLoader(FXMLMenuController.class.getResource("/vue/fenFXMLInsererBureau.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(rootLayout);
            premierStage.setScene(scene);
            
            premierStage.show();
        }
        catch (IOException e)
        {
        System.out.println("Erreur chargement seconde fenetre : " + e.getMessage());
        }
    }
}