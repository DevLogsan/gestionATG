package controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modele.GestionMembre;
import modele.Membre;

public class FenFXML_saisieController implements Initializable {
    @FXML
    private DatePicker txtDate;
    @FXML
    private TextField txtCivilite;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtAdresse;
    @FXML
    private TextField txtCP;
    @FXML
    private TextField txtVille;
    @FXML
    private TextField txtPays;
    @FXML
    private TextField txtFixe;
    @FXML
    private TextField txtPortable;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtSommeVersee;
    
    @FXML
    private TableView<Membre> tvMembres; // Même nom que le TableView de l'interface graphique
    @FXML
    private TableColumn<Membre, Integer> colonneId; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Membre, Integer> colonneTitre; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Membre, Integer> colonneNom; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Membre, Integer> colonnePrenom; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Membre, Integer> colonneAdresse; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Membre, Integer> colonneCP; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Membre, Integer> colonneVille; // Même nom que la colonne du TableView
    @FXML
    private TableColumn<Membre, Integer> colonneEmail; // Même nom que la colonne du TableView


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    public void handleEnregistrerSaisie(){

        // txtDate.getValue()
        // txtSommeVersee.getText()
        
        ObservableList<Membre> lesMembres = FXCollections.observableArrayList();
        String membre[] ={
            txtCivilite.getText(),
            txtNom.getText(),
            txtPrenom.getText(),
            txtAdresse.getText(),
            txtCP.getText(),
            txtVille.getText(),
            txtPays.getText(),
            txtFixe.getText(),
            txtPortable.getText(),
            txtEmail.getText()
                    };
        Membre leMembre = new Membre(txtCivilite.getText(), txtNom.getText(),
            txtPrenom.getText(),
            txtAdresse.getText(),
            txtCP.getText(),
            txtVille.getText(),
            txtPays.getText(),
            txtFixe.getText(),
            txtPortable.getText(),
            txtEmail.getText());
        lesMembres.add(leMembre);
        GestionMembre.insererMembre(lesMembres, Float.parseFloat(txtSommeVersee.getText()), txtDate.getValue());
    }

    /*@FXML
    private void handleFermer() // Methode événement sur le menu "Fermer"
    {
    System.exit(0);
    } */
}
