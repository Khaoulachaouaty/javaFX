package Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Connexion;
import classes.Plante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RechercheController implements Initializable {

    @FXML
    private ComboBox<String> cat;

    @FXML
    private TextField searchField;

    @FXML
    private Button listeButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button id1;
    @FXML
    private Button acceuil;

    @FXML
    private Label arrosage;

    @FXML
    private Label categorie;

    @FXML
    private Button conseil;

    @FXML
    private Label descrp;

    @FXML
    private Button favorie;

    @FXML
    private Label florison;

    @FXML
    private ImageView image;

    @FXML
    private Label nom;

    @FXML
    private Label qte_eau;

    @FXML
    private Button recherche;

    @FXML
    private Label saison;

    @FXML
    private Label sels;

    @FXML
    private Label virus;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            Connection conn = Connexion.getCn();
            String query = "SELECT DISTINCT categorie FROM plante";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String categorie = rs.getString("categorie");
                list.add(categorie);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        ObservableList<String> ct = FXCollections.observableArrayList(list);
        cat.setItems(ct);
    }

    @FXML
    private void rechercherPlantes() {
        String selectedCategorie = cat.getSelectionModel().getSelectedItem();
        if (selectedCategorie != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/liste.fxml"));
                Parent fxml = loader.load();
                ListeController listeController = loader.getController();
                listeController.initialize(selectedCategorie); // Pass selected category to initialize method

                Scene scene = cat.getScene();
                scene.setRoot(fxml);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @FXML
    private void afficherPlante() {
        String nomPl = searchField.getText();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/Plantex.fxml"));
            Parent fxml = loader.load();
            PlantexController plantexController = loader.getController();
            plantexController.initialize(nomPl);

            Scene scene = searchField.getScene();
            scene.setRoot(fxml);
        } catch (IOException e) {
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
}
