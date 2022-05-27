package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DeleteMenuController {
	@FXML private Button back_btn;
	@FXML private Button delete_btn;
	@FXML private TextField menu;
	
// 뒤로 가기 -> 설정 화면 이동
public void back (ActionEvent event)  {
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("설정 화면 이동."); 
		alert.setContentText("설정 화면으로 이동 합니다.");
		alert.setHeaderText("설정 화면 이동 알림!");				
		alert.show();
		

		 Parent Mainlayout;
		try {
			Mainlayout = FXMLLoader.load(getClass().getResource("Setup.fxml"));
			Stage nowStage = (Stage)back_btn.getScene().getWindow();
			Scene sc = new Scene(Mainlayout);
			
			nowStage.setScene(sc);
	        nowStage.show();
	      
			
			} catch (IOException e) {
			 e.printStackTrace();
				}
			}

// 메뉴 삭제 -> 메인 화면 이동
public void delete (ActionEvent event)  {
	
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("메뉴 삭제"); 
	alert.setContentText("메뉴가 삭제되었습니다.\n 메인 화면으로 이동합니다.");
	alert.setHeaderText("메뉴 삭제!");				
	alert.show();
	

	 Parent Mainlayout;
	try {
		Mainlayout = FXMLLoader.load(getClass().getResource("Cafe Main.fxml"));
		Stage nowStage = (Stage)delete_btn.getScene().getWindow();
		Scene sc = new Scene(Mainlayout);
		
		nowStage.setScene(sc);
        nowStage.show();
      
		
		} catch (IOException e) {
		 e.printStackTrace();
			}
		}
	
}
