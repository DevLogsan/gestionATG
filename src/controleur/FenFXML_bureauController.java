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

public class FenFXML_bureauController implements Initializable {
    @FXML
    private TableView<Bureau> tvBureaux; // Même nom que le TableView de l'interface graphique
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
        tvBureaux.setItems(lesBureaux);
        
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
        tvBureaux.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    
    @FXML
    public void handleEnregistrerUnBureau() // handle du bouton 'ajouter' dans la liste des membres du bureau
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
    
    @FXML
    public void handleSupprimerBureau()
    {
        Bureau leBureau = tvBureaux.getSelectionModel().getSelectedItem();
        GestionBureau.supprimerBureau(leBureau);
        
        ObservableList<Bureau> lesBureaux = FXCollections.observableArrayList();
        
        lesBureaux = GestionBureau.listeBureaux();
        tvBureaux.setItems(lesBureaux);
        
        // Initialise le TableView
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
        tvBureaux.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    
    @FXML
    public void handleModifierBureau()
    {
        Bureau leBureau = tvBureaux.getSelectionModel().getSelectedItem();
        GestionBureau.modifierBureau(leBureau);
        MainApp.setUnBureauSelectionner(leBureau);
        
        try
        {
            premierStage = new Stage();
            premierStage.setTitle("Modification des infos");
            FXMLLoader loader = new FXMLLoader(FXMLMenuController.class.getResource("/vue/fenFXML_ModifBureau.fxml"));
            
            AnchorPane rootLayout = (AnchorPane) loader.load(); // probleme ici
            
            Scene scene = new Scene(rootLayout);
            premierStage.setScene(scene);
            premierStage.show();
            
            
            
        }
        catch (Exception e)
        {
        System.out.println("Erreur chargement seconde fenetre : " + e.getMessage());
        }
    }
    
    @FXML
    public void handleConfirmerModifierBureau()
    {
        System.out.print("Oui");
    }
}