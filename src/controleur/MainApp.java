package controleur;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Logan
 */
public class MainApp extends Application {  
    private Stage primaryStage;
    
    
    @Override
    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Resultats des cours");
        
        try
        {
            // Chargement du layout racine à partir du fichier fxml file
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vue/FXMLMenu.fxml"));
            AnchorPane overviewPage = (AnchorPane) loader.load();
            Scene scene = new Scene(overviewPage);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e)
        {
        // Exception qui intervient si le fichier fxml file n'a pas pu être chargé
        e.printStackTrace();
        }
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public static void main(String[] args) {
    launch(args);
    }
}