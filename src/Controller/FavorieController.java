package Controller;

/*import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import application.Connexion;
public class FavorieController implements Initializable {

    @FXML
    private HBox imageContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    try {
        // Requête pour récupérer les plantes favorites
        Connection conn = Connexion.getCn();
        String query = "SELECT image, nom FROM plante WHERE favorie = 'oui'";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            // Récupérer les données de chaque plante favorite
            Blob imageBlob = resultSet.getBlob("image");
            String nom = resultSet.getString("nom");

            // Convertir le BLOB en tableau de bytes
            byte[] imageData = imageBlob.getBytes(1, (int) imageBlob.length());

            // Créer l'ImageView et le Label pour afficher la plante et son nom
            ImageView imageView = new ImageView(new Image(new ByteArrayInputStream(imageData)));
            Label label = new Label(nom);

            // Ajouter l'ImageView et le Label à l'imageContainer
            imageContainer.getChildren().addAll(imageView, label);
        }


        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}
*/