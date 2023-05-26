package Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import application.Connexion;
import classes.Plante;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlantexController {

	  @FXML
	    private Button acceuil;

	    @FXML
	    private Text arrosage;

	    @FXML
	    private Text cat;

	    @FXML
	    private Text descrp;

	    @FXML
	    private Text florison;

	    @FXML
	    private ImageView image;

	    @FXML
	    private Text nom;

	    @FXML
	    private Text qte_eau;

	    @FXML
	    private Button recherche;

	    @FXML
	    private Text saison;

	    @FXML
	    private Text sels;

	    @FXML
	    private Text virus;

    @FXML
    private Parent fxml;

    public void initialize(String nomPl) {
    	afficherPlante(nomPl);		
	}

    private void afficherPlante(String nomP) {
    	 try {
             Connection conn = Connexion.getCn();
             String query = "SELECT * FROM plante WHERE nom = ?";
             PreparedStatement stmt = conn.prepareStatement(query);
             stmt.setString(1, nomP);
             ResultSet rs = stmt.executeQuery();
             if (rs.next()) {
                 int id = rs.getInt("id");
                 String nomPlante = rs.getString("nom");
                 String categorie = rs.getString("categorie");
                 String selMin = rs.getString("sel_min");
                 String virusPlante = rs.getString("virus");
                 Blob imageBlob = rs.getBlob("image");
                 String saisonPlante = rs.getString("saison");
                 String arrosagePlante = rs.getString("arrosage");
                 String qteEauPlante = rs.getString("qte_eau");
                 String description = rs.getString("description");
                 String florison = rs.getString("florison");
                 byte[] imageData = imageBlob.getBytes(1, (int) imageBlob.length());
                 Plante plante = new Plante(id, nomPlante, categorie, selMin, virusPlante, imageBlob, saisonPlante,
                         arrosagePlante, qteEauPlante, description, florison);
                 //afficherPlante(plante);
                 afficherImage(imageData);
                 nom.setText(plante.getNom());
                 cat.setText(plante.getCategorie());
                 sels.setText(String.valueOf(plante.getSelMin()));
                 virus.setText(plante.getVirus());
                 saison.setText(plante.getSaison());
                 arrosage.setText(plante.getArrosage());
                 qte_eau.setText(String.valueOf(plante.getQteEau()));
                 descrp.setText(plante.getDescription());
                 //florison.setText(plante.getFlorison());
             } else {
                 System.out.println("Aucun enregistrement trouvé."); // Message de débogage
             }
             rs.close();
             stmt.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }

    }

    private void afficherImage(byte[] imageData) {
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
            Image planteImage = new Image(inputStream);
            image.setImage(planteImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* private void mettreAJourFavori(boolean estFavori) {
        try {
            Connection conn = Connexion.getCn();
            String updateQuery = "UPDATE plante SET favori = ? WHERE id = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setString(1, estFavori ? "oui" : "non");
            updateStmt.setInt(2, currentIndex);
            int rowsAffected = updateStmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Mise à jour effectuée avec succès."); // Message de débogage
            } else {
                System.out.println("Aucun enregistrement trouvé pour l'indice : " + currentIndex); // Message de débogage
            }
            updateStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/
    @FXML
    void acceuil() {
        Stage acceuil = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("/interfaces/acceuil.fxml"));
            Scene scene = new Scene(fxml);
            acceuil.setScene(scene);
        	acceuil.setTitle("Acceuil");

            acceuil.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @FXML
    void recherche() {
        Stage rech = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("/interfaces/Recherche.fxml"));
            Scene scene = new Scene(fxml);
            rech.setScene(scene);
        	rech.setTitle("Recherche");

            rech.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void conseil() {
        Stage cons = new Stage();
        try {
            fxml = FXMLLoader.load(getClass().getResource("/interfaces/Conseil.fxml"));
            Scene scene = new Scene(fxml);
            cons.setScene(scene);
        	cons.setTitle("Conseil");

            cons.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
}
