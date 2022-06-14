package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DialogueController implements Initializable
{

	@FXML private BorderPane bg; // 보더팬 
	@FXML private TableView<Stock> input; // 입력테이블 
	@FXML private TableView<Price> result; // 결과 테이블
	@FXML private Button btnDialogue ; // 입력 버튼(다이얼로그로 이동)
	@FXML private Button btnDel, btnCG; //삭제, CompanyGuide(+한국신용평가) 이동 버튼
	@FXML private TextField r; // 요구수익률 값 입력하는 텍스트 필드

	private ObservableList<Stock> listInput = FXCollections.observableArrayList();//입력 테이블 튜플 리스트
	private ObservableList<Price> listResult = FXCollections.observableArrayList();//결과값 테이블 튜플 리스트
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToMain(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
		//입력값 테이블 칼럼 세팅
		TableColumn tc = input.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory("Stocks"));
		tc.setStyle("-fx-alignment: CENTER;");
		// 종목 칼럼
		tc = input.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory("Capital"));
		tc.setStyle("-fx-alignment: CENTER;");
		// 자본 칼럼 
		tc = input.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory("ROE"));
		tc.setStyle("-fx-alignment: CENTER;");
		// ROE 칼럼
		tc = input.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory("NumberOfStock"));
		tc.setStyle("-fx-alignment: CENTER;");
		// 발행주식 수 칼럼
		tc = input.getColumns().get(4);//테이블의 열이 5개이므로 칼럼은 0번부터 4번까지 있음
		tc.setCellValueFactory(new PropertyValueFactory("Treasury"));
		tc.setStyle("-fx-alignment: CENTER;");
		// 자기주식 수 칼럼
		listInput = FXCollections.observableArrayList(new Stock("+", "", "", "", ""));
		// 입력테이블의 초기화
		input.setItems(listInput); 
		// 컬렉션 클래스의 객체를 테이블로 지정
		
		//결과값 테이블 칼럼 세팅
		tc = result.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory("StocksName"));
		tc.setStyle("-fx-alignment: CENTER;");
		// 종목 칼럼
		tc = result.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory("resonablePrice"));
		tc.setStyle("-fx-alignment: CENTER;");
		// 적정 주가 칼럼
		tc = result.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory("_90Price"));
		tc.setStyle("-fx-alignment: CENTER;");
		// 적정주가 90% 지속 칼럼
		tc = result.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory("_80Price"));
		tc.setStyle("-fx-alignment: CENTER;");
		// 적정주가 80% 지속 칼럼
		listResult = FXCollections.observableArrayList(new Price("","","","","",""));
		result.setItems(listResult);
		// 컬렉션 클래스의 객체를 테이블로 지정
	}
	
	// 다이얼로그 시작
	public void handlebtnDialogueAction(ActionEvent event)
	{
		try
		{		
			Stage dialog = new Stage(StageStyle.DECORATED); // stage 생성, DECORATED 일반적인 윈도우 스타일
			dialog.initModality(Modality.WINDOW_MODAL); //윈도우 모달 설정
			dialog.initOwner(btnDialogue.getScene().getWindow()); 
			dialog.setTitle("입력"); // 다이얼로그의 타이틀 설정
			
			// DialogueAdd.fxml 실행을 위한 준비
			Parent parent = FXMLLoader.load(getClass().getResource("DialogueAdd.fxml"));			
			
			// 다이얼로그에선 fx:id 사용이 불가하여(DialogueAdd.fxml에 대한 controller 지정이 안되어 있기 때문), node id를 사용한다.
			//lookup : 찾는다("#node id"); node id를 가지고 있는 애를 찾아서 사용하기 위함
			Button btnInput = (Button) parent.lookup("#btnInput");
			TextField txtStocks = (TextField) parent.lookup("#txtStocks");
			TextField txtCapital = (TextField) parent.lookup("#txtCapital");
			TextField txtRoe = (TextField) parent.lookup("#txtRoe");
			TextField txtNumberOfStocks = (TextField) parent.lookup("#txtNumberOfStock");
			TextField txtTreasury = (TextField) parent.lookup("#txtTreasury");
			
			
			int i = input.getSelectionModel().getSelectedIndex(); // 초기값은 -1, 0부터 값 받아옴
			
			//입력 버튼 클릭 시(입력 및 값의 변경 가능)
			btnInput.setOnAction(e->{
				// 변경
				if(i!=-1&&i!=listInput.size()-1)
				{ 
					// 다이얼로그에서 입력한 값들을 입력 테이블의 튜플 리스트로 보냄
					listInput.set(i,new Stock(
						txtStocks.getText(),
						txtCapital.getText(),
						txtRoe.getText(), 
						txtNumberOfStocks.getText(),
						txtTreasury.getText()));  
					// 리스트값을 튜플에 넘겨줌
					input.setItems(listInput);
					
					// 요구수익률을 포함한 값들을 전부 결과테이블의 튜플 리스트에 보냄
					listResult.set(i, 
							      new Price(listInput.get(i).getStocks(),listInput.get(i).getCapital(), listInput.get(i).getROE(), 
									        listInput.get(i).getNumberOfStock(), listInput.get(i).getTreasury(), r.getText() ));
					// 리스트값을 튜플에 넘겨줌
					result.setItems(listResult);
					
					
				}
				// 입력(위와 내용은 같으나 실행 조건이 다름)
				if(i==listInput.size()-1)
				{ 

					listInput.add(listInput.size()-1, new Stock( 
								txtStocks.getText(),
								txtCapital.getText(),
								txtRoe.getText(), 
								txtNumberOfStocks.getText(),
								txtTreasury.getText()));   
					input.setItems(listInput);
					
					listResult.add(i, 
							      new Price(listInput.get(i).getStocks(),listInput.get(i).getCapital(), listInput.get(i).getROE(), 
									        listInput.get(i).getNumberOfStock(), listInput.get(i).getTreasury(), r.getText() ));
					result.setItems(listResult);
				}
				//다이얼로그 창 닫기
				dialog.close();
				

			});
			// 취소 버튼 클릭 시
			Button btnCancel = (Button) parent.lookup("#btnCancel");
			// 취소 버튼 입력시 다이얼로그 창 닫힘
			btnCancel.setOnAction(e->dialog.close());
			
			
			// DialogueAdd.fxml 실행
			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.setResizable(false); //창 크기 고정
			
			// 지정한 투플의 값들을 다이얼로그 입력시에 그대로 받아옴
			if(i!=-1&&i!=listInput.size()-1)
			{
				Stock stk = listInput.get(i) ;
				txtStocks.setText(stk.getStocks());
				txtCapital.setText(stk.getCapital());
				txtRoe.setText(stk.getROE());
				txtNumberOfStocks.setText(stk.getNumberOfStock());
				txtTreasury.setText(stk.getTreasury());
			}
			dialog.show();	
			
		}
		catch (Exception e)
		{
			
		}
		
	}
	// 다이얼로그 끝
	
	
	public void delAction(ActionEvent e)
	{
		//삭제 버튼
		int i = input.getSelectionModel().getSelectedIndex();//인덱스번호 얻어옴
		if(i!=listInput.size()-1&&listInput.size()>1&&i!=-1)
		{
			//선택된 행이 마지막 행이 아니고 리스트에 공백 튜플을 제외한 튜플이 하나 이상 있고 선택된 행이 있는 경우
			//리스트에서 튜플 삭제
			listInput.remove(i);
		}
		if(i!=listResult.size()-1&&listResult.size()>1&&i!=-1)
		{
			//결과값테이블 튜플 삭제
			listResult.remove(i);
		}
		//result.setItems(listResult); 
	}
	
	
	public void deselectTF(ActionEvent e)
	{
		//요구수익률 입력하고 엔터 치면 결과값 리스트 다시 셋팅
		for(int i = 0; i<listInput.size()-1;i++)
		{
			listResult.set(i, new Price(listInput.get(i).getStocks(),listInput.get(i).getCapital(), listInput.get(i).getROE(), 
						        listInput.get(i).getNumberOfStock(), listInput.get(i).getTreasury(), r.getText()));
			
		result.setItems(listResult); //다시 세팅된 값을 입력
		}
		//bg.requestFocus();
	}
	
	public void linkClick(ActionEvent e) throws URISyntaxException, IOException{
		Desktop d = Desktop.getDesktop();
		String link = "https://comp.fnguide.com/SVO2/ASP/SVD_main.asp?pGB=1&gicode=A005930&cID=&MenuYn=Y&ReportGB=&NewMenuID=11&stkGb=&strResearchYN=";
		String link_2 = "https://www.kisrating.com/ratingsStatistics/statics_spread.do" ;
		String link_3 = "https://finance.naver.com/" ;
		d.browse(new URI(link));
		d.browse(new URI(link_2));
		d.browse(new URI(link_3));
		
		
	}

}
