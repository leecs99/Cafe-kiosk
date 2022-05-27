package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class setting {
	
	@FXML private Button madd_btn;		
	@FXML private Button mdelete_btn;
	@FXML private Button back_btn;

// 메뉴 추가 버튼
public void add (ActionEvent event)  {
		
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("메뉴 추가"); 
	alert.setContentText("추가할 메뉴를 입력해주세요.");				
	alert.show();
		

	Parent Mainlayout;
		try {
			Mainlayout = FXMLLoader.load(getClass().getResource("Add Menu.fxml"));
			Stage nowStage = (Stage)madd_btn.getScene().getWindow();
			Scene sc = new Scene(Mainlayout);
			
			nowStage.setScene(sc);
	        nowStage.show();
	      
			
			} catch (IOException e) {
			 e.printStackTrace();
		}
	}
	

// 메뉴 삭제 버튼
public void delete (ActionEvent event)  {
	
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("메뉴 삭제"); 
	alert.setContentText("삭제할 메뉴를 입력해주세요.");				
	alert.show();
	

	 Parent Mainlayout;
	try {
		Mainlayout = FXMLLoader.load(getClass().getResource("Delete Menu.fxml"));
		Stage nowStage = (Stage)mdelete_btn.getScene().getWindow();
		Scene sc = new Scene(Mainlayout);
		
		nowStage.setScene(sc);
        nowStage.show();
      
		
		} catch (IOException e) {
		 e.printStackTrace();
			}
	}
	
// 메인 화면
public void back (ActionEvent event)  {
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("메인 화면 이동."); 
		alert.setContentText("메인 화면으로 이동 합니다.");
		alert.setHeaderText("메인 화면 이동 알림!");				
		alert.show();
		

		 Parent Mainlayout;
		try {
			Mainlayout = FXMLLoader.load(getClass().getResource("Cafe Main.fxml"));
			Stage nowStage = (Stage)back_btn.getScene().getWindow();
			Scene sc = new Scene(Mainlayout);
			
			nowStage.setScene(sc);
	        nowStage.show();
	      
			
			} catch (IOException e) {
			 e.printStackTrace();
				}
			}
	
	}


