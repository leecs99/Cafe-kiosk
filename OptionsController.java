package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class OptionsController implements Initializable{

	
	@FXML private ComboBox boxchange; 	//유저가 선택한  ICE or HOT ComboBox
	@FXML private ComboBox boxice;		//유저가 선택한 얼음 양값 ComboBox
	@FXML private ComboBox boxsize;		//유저가 선택한 사이즈값 ComboBox
	@FXML private ComboBox boxshot;		//유저가 선택한 샷 추가값 ComboBox
	@FXML private ComboBox boxwhipping; //유저가 선택한 휘핑 추가값 ComboBox
	@FXML private Label change; 		//선택한 ICE or HOT 표시하는 Label
	@FXML private Label ice;			//선택한 얼음 양값 표시하는 Label
	@FXML private Label size;			//선택한 사이즈값 표시하는 Label
	@FXML private Label shot;			//선택한 샷 추가값 표시하는 Label
	@FXML private Label whipping;		//선택한 휘핑 추가값 표시하는 Label
	@FXML private Button next_btn;			//옵션을 선택 후 메인으로 넘어가는 Button
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 이름선택 콤보박스 부분
		// 콤보박스에 표시될 이름을 배열로 만들어 준다.
		String[] strArrList = {"HOT(기본)","ICE(+300원)"};
		String[] strArrList1 = {"얼음X","얼음 조금","얼음 많이"};
		String[] strArrList2 = {"Medium(기본)","Large(+1000)"};
		String[] strArrList3 = {"샷 추가X(기본)","샷추가(+500)", "샷x2 추가(+1000)", "샷x3 추가(+1500)"};
		String[] strArrList4 = {"휘핑 추가X(기본)","휘핑 추가(+500)", "휘핑x2 추가(+1000)", "휘핑x3 추가(+1500)"};
		
		
		//콤보 박스에 배열의 요소를 위치 시킨다.
		ObservableList<String> fxComboNameList = FXCollections.observableArrayList(strArrList);
		boxchange.setItems(fxComboNameList);
		ObservableList<String> fxComboNameList1 = FXCollections.observableArrayList(strArrList1);
		boxice.setItems(fxComboNameList1);
		ObservableList<String> fxComboNameList2 = FXCollections.observableArrayList(strArrList2);
		boxsize.setItems(fxComboNameList2);
		ObservableList<String> fxComboNameList3 = FXCollections.observableArrayList(strArrList3);
		boxshot.setItems(fxComboNameList3);
		ObservableList<String> fxComboNameList4 = FXCollections.observableArrayList(strArrList4);
		boxwhipping.setItems(fxComboNameList4);
	}
    
	//변경
    @FXML
    void select_boxchange(ActionEvent event) {
    	
    	//콤보박스를 선택하지 않고 버튼을 누르면 null point error 가 나는것을 
    	// 방지 하기 위해서 예외를 설정 합니다.
    	try {
    		
    		//버튼을 누를때 선택 되어진 콤보 박스의 아이템을 문자열로 받는 부분
        	//혹시 숫자를 사용해야 할 경우에는 숫자로 변환 해야 합니다.
    		String strName = boxchange.getSelectionModel().getSelectedItem().toString();
    		
    		//위에서 선택된 아이템의 값을 아래의 알림창에 출력한다.
    		change.setText("선택된 항목 : "+strName);
        	
    	}catch(Exception e) {
    		System.out.println("예외 발생 : "+e.getLocalizedMessage());
    	}
     }

    // 얼음 양
    @FXML
    void select_boxice(ActionEvent event) {
    	
    	//콤보박스를 선택하지 않고 버튼을 누르면 null point error 가 나는것을 
    	// 방지 하기 위해서 예외를 설정 합니다.
    	try {
    		
    		//버튼을 누를때 선택 되어진 콤보 박스의 아이템을 문자열로 받는 부분
        	//혹시 숫자를 사용해야 할 경우에는 숫자로 변환 해야 합니다.
    		String strName = boxice.getSelectionModel().getSelectedItem().toString();
    		
    		//위에서 선택된 아이템의 값을 아래의 알림창에 출력한다.
    		ice.setText("선택된 항목 : "+strName);
        	
    	}catch(Exception e) {
    		System.out.println("예외 발생 : "+e.getLocalizedMessage());
    	}
     }
    
    
 // 사이즈
    @FXML
    void select_boxsize(ActionEvent event) {
    	
    	//콤보박스를 선택하지 않고 버튼을 누르면 null point error 가 나는것을 
    	// 방지 하기 위해서 예외를 설정 합니다.
    	try {
    		
    		//버튼을 누를때 선택 되어진 콤보 박스의 아이템을 문자열로 받는 부분
        	//혹시 숫자를 사용해야 할 경우에는 숫자로 변환 해야 합니다.
    		String strName = boxsize.getSelectionModel().getSelectedItem().toString();
    		
    		//위에서 선택된 아이템의 값을 아래의 알림창에 출력한다.
    		size.setText("선택된 항목 : "+strName);
        	
    	}catch(Exception e) {
    		System.out.println("예외 발생 : "+e.getLocalizedMessage());
    	}
     }
    
    
 // 샷 추가
    @FXML
    void select_boxshot(ActionEvent event) {
    	
    	//콤보박스를 선택하지 않고 버튼을 누르면 null point error 가 나는것을 
    	// 방지 하기 위해서 예외를 설정 합니다.
    	try {
    		
    		//버튼을 누를때 선택 되어진 콤보 박스의 아이템을 문자열로 받는 부분
        	//혹시 숫자를 사용해야 할 경우에는 숫자로 변환 해야 합니다.
    		String strName = boxshot.getSelectionModel().getSelectedItem().toString();
    		
    		//위에서 선택된 아이템의 값을 아래의 알림창에 출력한다.
    		shot.setText("선택된 항목 : "+strName);
        	
    	}catch(Exception e) {
    		System.out.println("예외 발생 : "+e.getLocalizedMessage());
    	}
     }
    
    
 // 휘핑 추가
    @FXML
    void select_boxwhipping(ActionEvent event) {
    	
    	//콤보박스를 선택하지 않고 버튼을 누르면 null point error 가 나는것을 
    	// 방지 하기 위해서 예외를 설정 합니다.
    	try {
    		
    		//버튼을 누를때 선택 되어진 콤보 박스의 아이템을 문자열로 받는 부분
        	//혹시 숫자를 사용해야 할 경우에는 숫자로 변환 해야 합니다.
    		String strName = boxwhipping.getSelectionModel().getSelectedItem().toString();
    		
    		//위에서 선택된 아이템의 값을 아래의 알림창에 출력한다.
    		whipping.setText("선택된 항목 : "+strName);
        	
    	}catch(Exception e) {
    		System.out.println("예외 발생 : "+e.getLocalizedMessage());
    	}
     }
    
    
// 확인 버튼 -> main
public void next(ActionEvent event)  {
	
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("옵션이 추가 완료"); 
	alert.setContentText("옵션 추가가 완료되었습니다.");
	alert.setHeaderText("추가 완료 알림!");				
	alert.show();
	

	 Parent Mainlayout;
	try {
		Mainlayout = FXMLLoader.load(getClass().getResource("Cafe Main.fxml"));
		Stage nowStage = (Stage)next_btn.getScene().getWindow();
		Scene sc = new Scene(Mainlayout);
		
		nowStage.setScene(sc);
        nowStage.show();
      
		
		} catch (IOException e) {
		 e.printStackTrace();
			}
	}
}
