package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) /* throws Exception */ {
		try {
	
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml")) ; 
			Parent root ; 
			root = loader.load() ; 
			
			//DialbuttonController controller = loader.getController() ; 
			//controller.setPrimaryStage(primaryStage) ; 
			
			Scene scene = new Scene(root) ;
			
			primaryStage.setTitle("RIM_계산기");
			primaryStage.setScene(scene) ; 
			//primaryStage.setResizable(false); //창 크기 고정
			primaryStage.show() ; 
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}