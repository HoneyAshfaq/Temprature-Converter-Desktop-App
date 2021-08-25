package javafx.javaprojects;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;


public class Main extends Application {

	@Override
	public void init() throws Exception {
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		System.out.println("start method run");
		FXMLLoader fl = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox r = fl.load();
		MenuBar a = create_menu();
		r.getChildren().add(0, a);
		Scene s = new Scene(r);
		primaryStage.setScene(s);
		primaryStage.setTitle("Temperature Converter App");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void stop() {
		System.out.println("stop");
	}

	private MenuBar create_menu() {
		SeparatorMenuItem spm = new SeparatorMenuItem();

		Menu mf = new Menu("File");
		MenuItem mi1 = new MenuItem("New");
		mi1.setOnAction(event -> System.out.println("new file created"));

		MenuItem mi2 = new MenuItem("Quit");
		mi2.setOnAction(e -> {
			Platform.exit();
			System.exit(0);
		});

		mf.getItems().addAll(mi1, mi2);

		Menu mh = new Menu("Help");

		MenuItem mi = new MenuItem("About developer");
		mh.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				about_developer();

			}
		});

		Menu ap=new Menu("About App");
          ap.setOnAction(event ->{
          	about_app();

		  });


		mh.getItems().addAll(mi,ap);

		MenuBar mb = new MenuBar();
		mb.getMenus().addAll(mf, mh);
		return mb;
	}

	private void about_app() {
		Alert a = new Alert(Alert.AlertType.INFORMATION);
		a.setTitle("About app");
		a.setHeaderText("How to Convert");
		a.setContentText("Its Converts the temperature from Fahrenheit to Celsius or vice versa");
        a.show();
	}

	private void about_developer() {
		Alert a = new Alert(Alert.AlertType.INFORMATION);
		a.setTitle("My First Java App");
		a.setHeaderText("About developer");
		a.setContentText("Hi i am Honey, a aspiring software developer. I am an B.tech" +
				" Engineer from Electronic & Communication & i loved to create that type of desktop " +
				"application. My hobbies are cricket, video games ,watching movies." +
				"Always eager to gain new skills.");
		a.show();
	}
}