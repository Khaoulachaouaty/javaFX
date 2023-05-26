package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Connexion;
import classes.Plante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ListeController {
    @FXML
    private TableView<Plante> planteTableView;

    @FXML
    private TableColumn<Plante, String> nomCol;

    @FXML
    private TableColumn<Plante, String> categorieCol;

    @FXML
    private TableColumn<Plante, String> saisonCol;

    public void initialize(String categorie) {
        afficherPlantes(categorie);
        categorieCol.setText(categorie); 

    }

    private void afficherPlantes(String categorie) {
        ObservableList<Plante> planteList = FXCollections.observableArrayList();
        try {
            Connection conn = Connexion.getCn();
            String query = "SELECT nom, categorie, saison FROM plante WHERE categorie = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, categorie);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String nom = rs.getString("nom");
                String categorieResult = rs.getString("categorie");
                String saison = rs.getString("saison");
                Plante plante = new Plante(nom, categorieResult, saison);
                planteList.add(plante);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        planteTableView.setItems(planteList);
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        categorieCol.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        saisonCol.setCellValueFactory(new PropertyValueFactory<>("saison"));
        planteTableView.setItems(planteList);
    }
}
