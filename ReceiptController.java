// 영수증
package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ReceiptController {
	@FXML private Label num;
	@FXML private Label cartList;
	@FXML private Button main;
	


public void go_main (ActionEvent event)  {
	
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("메인 화면 이동."); 
	alert.setContentText("메인 화면으로 이동 합니다.");
	alert.setHeaderText("메인 화면 이동 알림!");				
	alert.show();
	

	 Parent Mainlayout;
	try {
		Mainlayout = FXMLLoader.load(getClass().getResource("Cafe Main.fxml"));
		Stage nowStage = (Stage)main.getScene().getWindow();
		Scene sc = new Scene(Mainlayout);
		
		nowStage.setScene(sc);
        nowStage.show();
      
		
		} catch (IOException e) {
		 e.printStackTrace();
			}
		}
	}
