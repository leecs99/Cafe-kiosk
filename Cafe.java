package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Cafe {
	
	@FXML private Label phnNumadd;	//입력받은 유저의 전화번호 표시하는 Label
	@FXML private Label hourNumadd;	//입력받은 유저의 픽업 시(시간) 표시하는 Label
	@FXML private Label minNumadd;	//입력받은 유저의 픽업 분(시간) 표시하는 Label
	@FXML private TextField phnumTextField;	//유저가 입력하는 전화번호 TextField
	@FXML private TextField hournumTextField;	//유저가 입력하는 픽업 시(시간) TextField
	@FXML private TextField minnumTextField;	//유저가 입력하는 픽업 분(시간) TextField
	@FXML private Button phnNumbtn;	//유저가 입력한 전화번호를 출력하는 Button	
	@FXML private Label cartList;	
	@FXML private Label totalprice;	//총 금액 Label (장바구니에서의 총 금액) 
	@FXML private Label discount;		//할인금액 Label (적용된 할인금액) 
	@FXML private Label discountinfo;	//할인금액정보 Label (적용된 할인 정보) 
	@FXML private Label payment;		//총 결제될 금액
	@FXML private Button set_btn;
	@FXML private Button delete_btn;
	@FXML private Button pay_btn;
	@FXML private Button americano_btn;
	@FXML private Button cafelatte_btn;
	@FXML private Button vanillalatte_btn;
	@FXML private Button whitemocha_btn;
	@FXML private Button lemonade_btn;
	@FXML private Button grapefruitade_btn;
	@FXML private Button strawberryyogurt_btn;
	@FXML private Button cheesecake_btn;
	@FXML private Button chocolatecake_btn;
	@FXML private Button strawberrycake_btn;
	
	
	String phn;	//String 값으로 전화번호 phc를 선언함.
	String hour;//int 값으로 hour를 선언함.
	String min;	//int 값으로 min를 선언함.
	
  
	//Phone number 버튼 이벤트
	public void onClickshowphn(ActionEvent event) {
		try {
			phn = phnumTextField.getText();
			hour = hournumTextField.getText();
			min = minnumTextField.getText();
			phnNumadd.setText(String.valueOf(phn));
			if(Integer.valueOf(hour) <= 8 || Integer.valueOf(hour) >21 || Integer.valueOf(min) > 59) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("오류 메세지"); 
				alert.setContentText("시간을 제대로 입력하여 주십시오.");
				alert.setHeaderText("잘못된 입력");				
				alert.show();
			}
			else{ 
				hourNumadd.setText(String.valueOf(hour));
				minNumadd.setText(String.valueOf(min));
			}
		} catch (NumberFormatException e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("오류 메세지"); 
			alert.setContentText("문자를 입력하셨습니다, 번호를 제대로 입력하여 주십시오.");
			alert.setHeaderText("잘못된 입력");
			alert.show();		
		}	
	}	
	
  
	String[][] menu = {
			{"아메리카노", "2000"}, {"카페라떼 " , "2500"},
			{"바닐라라떼", "3000"}, {"화이트모카", "3200"},
			{"레몬에이드", "3000"}, {"자몽에이드", "3000"},
			{"딸기요거트", "3500"}, {"치즈케이크", "6000"},
			{"초코케이크", "6000"}, {"딸기케이크", "7000"}
	};
	
	
	
	MenuList order = new MenuList();
	Event event1 = new Event(order.TotalPrice());
	//아메리카노 
	

	
	public void americano_add(ActionEvent event) {
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("옵션 추가."); 
		alert.setContentText("옵션을 추가해 주세요.");
		alert.setHeaderText("옵션 추가!");				
		alert.show();
		

		 Parent Mainlayout;
		try {
			Mainlayout = FXMLLoader.load(getClass().getResource("Options.fxml"));
			Stage nowStage = (Stage)americano_btn.getScene().getWindow();
			Scene sc = new Scene(Mainlayout);
			
			nowStage.setScene(sc);
	        nowStage.show();
	      
			
			} catch (IOException e) {
			 e.printStackTrace();
				}
		
		order.insertMenuNode(0,menu[0][0], Integer.parseInt(menu[0][1]));
		cartList.setText(String.valueOf(order.printMenu()));
		event1.setPrice(order.TotalPrice());
		cartList.setText(String.valueOf(order.printMenu()));
		totalprice.setText(String.valueOf(event1.getTotalPrice()));
		discount.setText(String.valueOf(event1.getSalePrice()));
		discountinfo.setText(String.valueOf(event1.getSaleName()));
		payment.setText(String.valueOf(event1.getFinalPrice()));
	}
	
	//카페라떼 
	public void cafelatte_add(ActionEvent event) {
		order.insertMenuNode(1,menu[1][0], Integer.parseInt(menu[1][1]));
		cartList.setText(String.valueOf(order.printMenu()));
		event1.setPrice(order.TotalPrice());
		cartList.setText(String.valueOf(order.printMenu()));
		totalprice.setText(String.valueOf(event1.getTotalPrice()));
		discount.setText(String.valueOf(event1.getSalePrice()));
		discountinfo.setText(String.valueOf(event1.getSaleName()));
		payment.setText(String.valueOf(event1.getFinalPrice()));
	}
	
	//바닐라라떼 
	public void vanillalatte_add(ActionEvent event) {
		order.insertMenuNode(2,menu[2][0], Integer.parseInt(menu[2][1]));
		cartList.setText(String.valueOf(order.printMenu()));
		event1.setPrice(order.TotalPrice());
		cartList.setText(String.valueOf(order.printMenu()));
		totalprice.setText(String.valueOf(event1.getTotalPrice()));
		discount.setText(String.valueOf(event1.getSalePrice()));
		discountinfo.setText(String.valueOf(event1.getSaleName()));
		payment.setText(String.valueOf(event1.getFinalPrice()));
	}
	
	//화이트모카
	public void whitemocha_add(ActionEvent event) {
		order.insertMenuNode(3,menu[3][0], Integer.parseInt(menu[3][1]));
		cartList.setText(String.valueOf(order.printMenu()));
		event1.setPrice(order.TotalPrice());
		cartList.setText(String.valueOf(order.printMenu()));
		totalprice.setText(String.valueOf(event1.getTotalPrice()));
		discount.setText(String.valueOf(event1.getSalePrice()));
		discountinfo.setText(String.valueOf(event1.getSaleName()));
		payment.setText(String.valueOf(event1.getFinalPrice()));
	}
	
	//레몬에이드
	public void lemonade_add(ActionEvent event) {
		order.insertMenuNode(4,menu[4][0], Integer.parseInt(menu[4][1]));
		cartList.setText(String.valueOf(order.printMenu()));
		event1.setPrice(order.TotalPrice());
		cartList.setText(String.valueOf(order.printMenu()));
		totalprice.setText(String.valueOf(event1.getTotalPrice()));
		discount.setText(String.valueOf(event1.getSalePrice()));
		discountinfo.setText(String.valueOf(event1.getSaleName()));
		payment.setText(String.valueOf(event1.getFinalPrice()));
	}
	
	//자몽에이드 
	public void grapefruitade_add(ActionEvent event) {
		order.insertMenuNode(5,menu[5][0], Integer.parseInt(menu[5][1]));
		cartList.setText(String.valueOf(order.printMenu()));
		event1.setPrice(order.TotalPrice());
		cartList.setText(String.valueOf(order.printMenu()));
		totalprice.setText(String.valueOf(event1.getTotalPrice()));
		discount.setText(String.valueOf(event1.getSalePrice()));
		discountinfo.setText(String.valueOf(event1.getSaleName()));
		payment.setText(String.valueOf(event1.getFinalPrice()));
	}
	
	//딸기요거트 
	public void strawberryyogurt_add(ActionEvent event) {
		order.insertMenuNode(6,menu[6][0], Integer.parseInt(menu[6][1]));
		cartList.setText(String.valueOf(order.printMenu()));
		event1.setPrice(order.TotalPrice());
		cartList.setText(String.valueOf(order.printMenu()));
		totalprice.setText(String.valueOf(event1.getTotalPrice()));
		discount.setText(String.valueOf(event1.getSalePrice()));
		discountinfo.setText(String.valueOf(event1.getSaleName()));
		payment.setText(String.valueOf(event1.getFinalPrice()));
	}
	
	//치즈케이크
	public void cheesecake_add(ActionEvent event) {
		order.insertMenuNode(7,menu[7][0], Integer.parseInt(menu[7][1]));
		cartList.setText(String.valueOf(order.printMenu()));
		event1.setPrice(order.TotalPrice());
		cartList.setText(String.valueOf(order.printMenu()));
		totalprice.setText(String.valueOf(event1.getTotalPrice()));
		discount.setText(String.valueOf(event1.getSalePrice()));
		discountinfo.setText(String.valueOf(event1.getSaleName()));
		payment.setText(String.valueOf(event1.getFinalPrice()));
	}
	
	//초코케이크
	public void chocolatecake_add(ActionEvent event) {
		order.insertMenuNode(8,menu[8][0], Integer.parseInt(menu[8][1]));
		cartList.setText(String.valueOf(order.printMenu()));
		event1.setPrice(order.TotalPrice());
		cartList.setText(String.valueOf(order.printMenu()));
		totalprice.setText(String.valueOf(event1.getTotalPrice()));
		discount.setText(String.valueOf(event1.getSalePrice()));
		discountinfo.setText(String.valueOf(event1.getSaleName()));
		payment.setText(String.valueOf(event1.getFinalPrice()));
	}
	
	//딸기케이크
	public void strawberrycake_add(ActionEvent event) {
		order.insertMenuNode(9,menu[9][0], Integer.parseInt(menu[9][1]));
		cartList.setText(String.valueOf(order.printMenu()));
		event1.setPrice(order.TotalPrice());
		cartList.setText(String.valueOf(order.printMenu()));
		totalprice.setText(String.valueOf(event1.getTotalPrice()));
		discount.setText(String.valueOf(event1.getSalePrice()));
		discountinfo.setText(String.valueOf(event1.getSaleName()));
		payment.setText(String.valueOf(event1.getFinalPrice()));
	}
	
	//설정 버튼을 누르면 설정 알림창을 띄움
		public void setting(ActionEvent event)  {
			

			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("설정창으로 넘어갑니다.!");	
			alert.setTitle("설정 알림!"); 		
			alert.show();
			
		
			 Parent Mainlayout;
			try {
				Mainlayout = FXMLLoader.load(getClass().getResource("Setup.fxml"));
				Stage nowStage = (Stage)set_btn.getScene().getWindow();
				Scene sc = new Scene(Mainlayout);
				
				nowStage.setScene(sc);
		        nowStage.show();
		      
				
			} catch (IOException e) {
				 e.printStackTrace();
			}
		  
		
		}

	//전체 취소 버튼을 누르면 모두 리셋을 하고 알림창을 띄움
	public void delete(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("전체 취소 되었습니다..!");	
		alert.setTitle("취소 알림!"); 		
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
	
	
	
	
	//결제하기 버튼을 누르면 알림창을 띄움
public void pay(ActionEvent event)  {
	
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("결제가 완료되었습니다."); 
	alert.setContentText("시간에 맞추어 테이크아웃 해주세요.\n이용해주셔서 감사합니다.\n 영수증 확인 부탁드립니다.");
	alert.setHeaderText("결제 알림!");				
	alert.show();
	

	 Parent Mainlayout;
	try {
		Mainlayout = FXMLLoader.load(getClass().getResource("Receipt.fxml"));
		Stage nowStage = (Stage)set_btn.getScene().getWindow();
		Scene sc = new Scene(Mainlayout);
		
		nowStage.setScene(sc);
        nowStage.show();
      
		
		} catch (IOException e) {
		 e.printStackTrace();
			}
	}
}
