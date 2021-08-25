package javafx.javaprojects;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable {

    public Label l;
	public ChoiceBox<String> cb;
	public TextField tf;
	public Button b;

           String c_to_f="Calcious to Farinhiet";
           String f_to_c="fariheit to Calcious";
           boolean a=true;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		cb.getItems().addAll(c_to_f,f_to_c);
		cb.setValue(c_to_f);
		cb.getSelectionModel().selectedItemProperty().addListener((obsrvable,o,n)-> {
               if(n==c_to_f){
               	a=true;
			   }else a=false;
		});

		b.setOnAction(event-> {
			convert();
		});
	}

	private void convert() {
		Alert b = new Alert(Alert.AlertType.INFORMATION);
		String s = tf.getText();
		float temp;
		float t_value=0f;
		try {
			t_value=Float.valueOf(s);

		}catch(Exception e){
			error();
			System.out.println(e);
			return;
		}

		if(a){
		temp=	(t_value*9/5)+32;


			b.setTitle("Result");
			b.setContentText("the new  temprature is "+ temp+"F");
		}else {
			temp = (t_value - 32) * 5 / 9;

			b.setTitle("Result");
			b.setContentText("the new  temprature is " + temp+"C");
		}
		b.show();
	}

	private void error() {
		Alert b = new Alert(Alert.AlertType.ERROR);
		b.setTitle("Error Occur");
		b.setContentText("Please enter a valid temperature");
		b.show();
	}
}
