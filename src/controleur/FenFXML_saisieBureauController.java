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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import modele.Bureau;

/**
 * FXML Controller class
 *
 * @author Logan
 */
public class FenFXML_saisieBureauController implements Initializable {

    @FXML
    private TextField txtFonction;
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
    private TextField txtEmail;
    @FXML
    private TextField txtPortable;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void handleInsererMembreBureau(ActionEvent event) {
        ObservableList<Bureau> lesBureaux = FXCollections.observableArrayList();
        String membre[] = {
            txtFonction.getText(),
            txtNom.getText(),
            txtPrenom.getText(),
            txtAdresse.getText(),
            txtCP.getText(),
            txtVille.getText(),
            txtEmail.getText(),
            txtPortable.getText()
        };
    }
    
}
