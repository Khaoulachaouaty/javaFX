package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Connexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConnexionController implements Initializable {

    @FXML
    private TextField user;
    @FXML
    private PasswordField password;
    @FXML
    private Hyperlink inscr;
    @FXML
    private Button bntinsc;
    @FXML
    private TextField mail;
    @FXML
    private TextField phone;
    @FXML
    private CheckBox confirmCheckbox;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
    }

    @FXML
    private void handleConnect(ActionEvent event) {
        String username = user.getText();
        String userpassword = password.getText();

        try {
            Connection conn = Connexion.getCn();
            if (conn == null) {
                System.out.println("Erreur de connexion à la base de données. Veuillez vérifier les paramètres de connexion.");
                return;
            }

            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, userpassword);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("Connexion réussie !");
                loadAccueilScene();
            } else {
                System.out.println("Échec de la connexion. Veuillez vérifier vos informations.");
            }

            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSignUp(ActionEvent event) {
        String username = user.getText();
        String userpassword = password.getText();
        String usermail = mail.getText();
        String userphone = phone.getText();

        // Vérifier si tous les champs sont remplis
        if (username.isEmpty() || userpassword.isEmpty() || usermail.isEmpty() || userphone.isEmpty()) {
            System.out.println("Veuillez remplir tous les champs.");
            return;
        }
        
        // Vérifier si le bouton de case à cocher est coché
        if (!confirmCheckbox.isSelected()) {
            System.out.println("Veuillez confirmer les informations.");
            return;
        }

        try (Connection conn = Connexion.getCn()) {
            if (conn == null) {
                System.out.println("Erreur de connexion à la base de données. Veuillez vérifier les paramètres de connexion.");
                return;
            }

            // Vérifier si le nom d'utilisateur existe déjà dans la base de données
            String checkQuery = "SELECT * FROM user WHERE username = ?";
            try (PreparedStatement checkStatement = conn.prepareStatement(checkQuery)) {
                checkStatement.setString(1, username);
                try (ResultSet checkResult = checkStatement.executeQuery()) {
                    if (checkResult.next()) {
                        System.out.println("Le nom d'utilisateur existe déjà. Veuillez en choisir un autre.");
                        return;
                    }
                }
            }

            // Insérer les informations de l'utilisateur dans la base de données
            String query = "INSERT INTO user (username, password, mail, phone) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, userpassword);
                statement.setString(3, usermail);
                statement.setString(4, userphone);
                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Inscription réussie !");
                    loadAccueilScene();
                } else {
                    System.out.println("Échec de l'inscription. Veuillez réessayer.");
                    loadInscriptionScene();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
    }

    @FXML
    void openInscription() {
        loadInscriptionScene();
    }

    private void loadInscriptionScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/interfaces/Inscription.fxml"));
            Parent inscriptionFXML = fxmlLoader.load();
            Stage inscriptionStage = new Stage();
            Scene inscriptionScene = new Scene(inscriptionFXML);
            
            // Charger le fichier CSS
            String cssPath = getClass().getResource("/lesCSS/Inscription.css").toExternalForm();
            inscriptionScene.getStylesheets().add(cssPath);
            
            inscriptionStage.setScene(inscriptionScene);
            inscriptionStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void loadAccueilScene() {
        try {
            Parent accueilFXML = FXMLLoader.load(getClass().getResource("/interfaces/acceuil.fxml"));
            Scene accueilScene = new Scene(accueilFXML);
            Stage primaryStage = (Stage) bntinsc.getScene().getWindow();
            primaryStage.setScene(accueilScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
