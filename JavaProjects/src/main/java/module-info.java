module javafx.javaprojects {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;


	opens javafx.javaprojects to javafx.fxml;
	exports javafx.javaprojects;
}