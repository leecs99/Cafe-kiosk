package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainButtonController
{
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML Button closeButton;
	
	public void switchToDialogueScene(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("TableSceneNew.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setTitle("관심종목");
		stage.setScene(scene);
		stage.show();
	}
	public void switchToUserGuide(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("Guide.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setTitle("사용 가이드");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void closeButtonAction(){
	    Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();
	}
}