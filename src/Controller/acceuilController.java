package Controller;

import java.awt.Button;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class acceuilController {
	
    @FXML
    private Button search_btn;

    @FXML
    private Button liste_btn;
    
    
    @FXML
    private Parent fxml;

    @FXML
    void recherche() {
    	Stage acceuil= new Stage();
        try{
        	fxml = FXMLLoader.load(getClass().getResource("/interfaces/Recherche.fxml"));
        	Scene scene= new Scene(fxml);
        	acceuil.setScene(scene);
        	acceuil.setTitle("Recherche");
        	acceuil.show();
        }catch (IOException e)
        {
        	e.printStackTrace();
        }

    }

    @FXML
    void lister() {
	    try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/interfaces/Plante.fxml"));
	        Parent planteFXML = fxmlLoader.load();
	        Stage planteStage = new Stage();
	        Scene planteScene = new Scene(planteFXML);
	        planteStage.setTitle("Plante");
	        
	        // Charger le fichier CSS
	        String cssPath = getClass().getResource("/lesCSS/liste.css").toExternalForm();
	        planteScene.getStylesheets().add(cssPath);
	        
	        planteStage.setScene(planteScene);
	        planteStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
    }
            
    
    
    @FXML
    void conseil() {
    	Stage cons= new Stage();
        try{
        	FXMLLoader loader= new FXMLLoader(getClass().getResource("/interfaces/Conseil.fxml"));
            Parent fxml = loader.load();
        	Scene scene= new Scene(fxml);
        	cons.setScene(scene);
        	cons.setTitle("Conseil");
        	cons.show();
        }catch (IOException e)
        {
        	e.printStackTrace();
        } 

    }
    



}