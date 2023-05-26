package Controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ConseilController {
    @FXML
    private Parent fxml;

    @FXML
    void recherche() {
    	Stage acceuil= new Stage();
        try{
        	fxml = FXMLLoader.load(getClass().getResource("/interfaces/Recherche.fxml"));
        	Scene scene= new Scene(fxml);
        	acceuil.setScene(scene);
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
    void acceuil() {
    	Stage cons= new Stage();
        try{
        	fxml = FXMLLoader.load(getClass().getResource("/interfaces/acceuil.fxml"));
        	Scene scene= new Scene(fxml);
        	cons.setScene(scene);
        	cons.show();
        }catch (IOException e)
        {
        	e.printStackTrace();
        }

    }
}
