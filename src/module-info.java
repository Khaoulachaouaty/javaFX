module phytoLogicaa {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.base;
	requires java.sql;
	exports Controller;
	opens Controller to javafx.fxml;

	    
	

	opens classes to javafx.base;
	opens application to javafx.graphics, javafx.fxml;
}
