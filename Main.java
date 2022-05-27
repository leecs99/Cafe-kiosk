package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{
	

	@Override
	public void start(Stage primaryStage) {
		try {
			//"Cafe Main.fxml" 불러옴
			Parent root = FXMLLoader.load(getClass().getResource("Cafe Main.fxml"));
			Scene scene = new Scene(root);
			
			//stage  
			primaryStage.setTitle("Cafe Main Window");
			primaryStage.setScene(scene);
			primaryStage.show();
			
	} catch(Exception e) {
		e.printStackTrace();
				
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
