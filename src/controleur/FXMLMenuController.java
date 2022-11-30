/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Logan
 */

public class FXMLMenuController implements Initializable {
    @FXML
    private Stage premierStage;
    private Stage deuxiemeStage;
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        
    }
    @FXML
    private void handleMembreBureau()
    {
        try
        {
            deuxiemeStage = new Stage();
            deuxiemeStage.setTitle("Modification des infos");
            FXMLLoader loader = new FXMLLoader(FXMLMenuController.class.getResource("/vue/fenFXMLBureau.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(rootLayout);
            deuxiemeStage.setScene(scene);
            
            deuxiemeStage.show();
        }
        catch (IOException e)
        {
        System.out.println("Erreur chargement seconde fenetre : " + e.getMessage());
        }
    }
    
    @FXML
    private void handleSaisieMembre()
    {
        try
        {
            premierStage = new Stage();
            premierStage.setTitle("Modification des infos");
            FXMLLoader loader = new FXMLLoader(FXMLMenuController.class.getResource("/vue/fenFXMLSaisie.fxml"));
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
    private void handleListeMembres()
    {
        try
        {
            premierStage = new Stage();
            premierStage.setTitle("Liste des membres");
            FXMLLoader loader = new FXMLLoader(FXMLMenuController.class.getResource("/vue/fenFXMLMembres.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(rootLayout);
            premierStage.setScene(scene);
            
            premierStage.show();
        }
        catch (IOException e)
        {
        System.out.println("Erreur chargement troisieme fenetre : " + e.getMessage());
        }
    }
}