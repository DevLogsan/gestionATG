package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import modele.Membre;
import modele.Bureau;

public class GestionMembre {
    public static ObservableList<Bureau> listeMembres()
    {
        ObservableList<Bureau> lesMembres = FXCollections.observableArrayList();
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
                lesMembres.add(unBureau);
            }
            stmt.close();
            conn.close();
            
            return lesMembres;
        }
        catch (Exception e)
        {
            System.out.println("Erreur Requete SQL listeEtudiants - " + e.getMessage());
            return null;
        }
    }
    
    public static ObservableList<Membre> listeMembresDons()
    {
        ObservableList<Membre> lesMembres = FXCollections.observableArrayList();
        Membre unMembre;
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
            
            req = "Select * from membres";

            rs = stmt.executeQuery(req);
            while (rs.next())
            {
                unMembre = new Membre(rs.getInt("id"), rs.getString("titre"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("cp"), rs.getString("ville"), rs.getString("pays"), rs.getString("telFixe"), rs.getString("telPortable"), rs.getString("email"));
                lesMembres.add(unMembre);
            }
            stmt.close();
            conn.close();
            
            return lesMembres;
        }
        catch (Exception e)
        {
            System.out.println("Erreur Requete SQL listeEtudiants - " + e.getMessage());
            return null;
        }
    }
    
    public static void insererMembre(Membre unMembre, float don, LocalDate datedujour)
    {    
        
        Connection conn;
        Statement stmt, stmt2;
        ResultSet rs, rs2;
        String pilote = "org.gjt.mm.mysql.Driver";
        String url = new String("jdbc:mysql://localhost/atg");
        String reqInser, reqMembre, reqInser2, reqCotisation;
            
        try
        {
            Class.forName(pilote);
            conn = DriverManager.getConnection(url,"root","");
            stmt = conn.createStatement();
            stmt2 = conn.createStatement();

            reqInser = "Insert into membres(titre, nom, prenom, adresse, cp, ville, pays, telFixe, telPortable, email) values('" + unMembre.getTitre() + "', '" + unMembre.getNom() + "', '" + unMembre.getPrenom() + "', '" + unMembre.getAdresse() + "', '" + unMembre.getCp() + "', '" + unMembre.getVille() + "', '" + unMembre.getPays() + "', '" + unMembre.getTelFixe() + "', '" + unMembre.getTelPortable() + "', '" + unMembre.getEmail() + "')";
            reqMembre = "Select max(id) idm FROM membres";
            reqCotisation = "Select montant FROM cotisation";
            stmt.executeUpdate(reqInser);
            rs = stmt.executeQuery(reqMembre);
            rs2 = stmt2.executeQuery(reqCotisation);
            rs2.next();
            don = don - rs2.getFloat("montant");
            rs.next();
            reqInser2 = "Insert into cotiser(idMembre, dateVersement, cotisation, don, recuEmail) values('" + rs.getString("idm") + "', '" + datedujour + "', '" + rs2.getInt("montant") + "', '" + don + "', '" + 1 + "')";
            stmt2.executeUpdate(reqInser2);
            stmt.close();
            stmt2.close();
            conn.close();
            
        }
        catch(Exception e)
        {
            System.out.println("Erreur requete d'insertion : " + e.getMessage());
        }
    }
}