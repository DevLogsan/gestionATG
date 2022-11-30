package controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
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
    private Button btnEnregistrer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    public void handleEnregistrerSaisie(){

        // txtDate.getValue()
        // txtSommeVersee.getText()
        
        Membre unMembre = new Membre(
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
        );
        GestionMembre.insererMembre(unMembre, Float.parseFloat(txtSommeVersee.getText()), txtDate.getValue());
    }

    /*@FXML
    private void handleFermer() // Methode événement sur le menu "Fermer"
    {
    System.exit(0);
    } */
}
