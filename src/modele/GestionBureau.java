/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import modele.Bureau;

/**
 *
 * @author Logan
 */
public class GestionBureau {
    
    public static ObservableList<Bureau> listeBureaux()
    {
        ObservableList<Bureau> lesBureaux = FXCollections.observableArrayList();
        Bureau unBureau;
        Connection conn;
        Statement stmt;
        ResultSet rs;
        String pilote = "org.gjt.mm.mysql.Driver";
        String url = new String("jdbc:mysql://localhost/atg");
        String req;

        try
        {
            Class.forName(pilote);
            conn = DriverManager.getConnection(url,"root","");
            stmt = conn.createStatement();
            
            req = "Select * from bureau";

            rs = stmt.executeQuery(req);
            while (rs.next())
            {
                unBureau = new Bureau(rs.getInt("id"), rs.getString("fonction"), rs.getString("titre"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("cp"), rs.getString("ville"), rs.getString("telPortable"), rs.getString("email"));
                lesBureaux.add(unBureau);
            }
            stmt.close();
            conn.close();
            
            return lesBureaux;
        }
        catch (Exception e)
        {
            System.out.println("Erreur Requete SQL listeEtudiants - " + e.getMessage());
            return null;
        }
    }
    
    
}
