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

	@FXML private BorderPane bg; // ������ 
	@FXML private TableView<Stock> input; // �Է����̺� 
	@FXML private TableView<Price> result; // ��� ���̺�
	@FXML private Button btnDialogue ; // �Է� ��ư(���̾�α׷� �̵�)
	@FXML private Button btnDel, btnCG; //����, CompanyGuide(+�ѱ��ſ���) �̵� ��ư
	@FXML private TextField r; // �䱸���ͷ� �� �Է��ϴ� �ؽ�Ʈ �ʵ�

	private ObservableList<Stock> listInput = FXCollections.observableArrayList();//�Է� ���̺� Ʃ�� ����Ʈ
	private ObservableList<Price> listResult = FXCollections.observableArrayList();//����� ���̺� Ʃ�� ����Ʈ
	
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
		
		//�Է°� ���̺� Į�� ����
		TableColumn tc = input.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory("Stocks"));
		tc.setStyle("-fx-alignment: CENTER;");
		// ���� Į��
		tc = input.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory("Capital"));
		tc.setStyle("-fx-alignment: CENTER;");
		// �ں� Į�� 
		tc = input.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory("ROE"));
		tc.setStyle("-fx-alignment: CENTER;");
		// ROE Į��
		tc = input.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory("NumberOfStock"));
		tc.setStyle("-fx-alignment: CENTER;");
		// �����ֽ� �� Į��
		tc = input.getColumns().get(4);//���̺��� ���� 5���̹Ƿ� Į���� 0������ 4������ ����
		tc.setCellValueFactory(new PropertyValueFactory("Treasury"));
		tc.setStyle("-fx-alignment: CENTER;");
		// �ڱ��ֽ� �� Į��
		listInput = FXCollections.observableArrayList(new Stock("+", "", "", "", ""));
		// �Է����̺��� �ʱ�ȭ
		input.setItems(listInput); 
		// �÷��� Ŭ������ ��ü�� ���̺�� ����
		
		//����� ���̺� Į�� ����
		tc = result.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory("StocksName"));
		tc.setStyle("-fx-alignment: CENTER;");
		// ���� Į��
		tc = result.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory("resonablePrice"));
		tc.setStyle("-fx-alignment: CENTER;");
		// ���� �ְ� Į��
		tc = result.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory("_90Price"));
		tc.setStyle("-fx-alignment: CENTER;");
		// �����ְ� 90% ���� Į��
		tc = result.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory("_80Price"));
		tc.setStyle("-fx-alignment: CENTER;");
		// �����ְ� 80% ���� Į��
		listResult = FXCollections.observableArrayList(new Price("","","","","",""));
		result.setItems(listResult);
		// �÷��� Ŭ������ ��ü�� ���̺�� ����
	}
	
	// ���̾�α� ����
	public void handlebtnDialogueAction(ActionEvent event)
	{
		try
		{		
			Stage dialog = new Stage(StageStyle.DECORATED); // stage ����, DECORATED �Ϲ����� ������ ��Ÿ��
			dialog.initModality(Modality.WINDOW_MODAL); //������ ��� ����
			dialog.initOwner(btnDialogue.getScene().getWindow()); 
			dialog.setTitle("�Է�"); // ���̾�α��� Ÿ��Ʋ ����
			
			// DialogueAdd.fxml ������ ���� �غ�
			Parent parent = FXMLLoader.load(getClass().getResource("DialogueAdd.fxml"));			
			
			// ���̾�α׿��� fx:id ����� �Ұ��Ͽ�(DialogueAdd.fxml�� ���� controller ������ �ȵǾ� �ֱ� ����), node id�� ����Ѵ�.
			//lookup : ã�´�("#node id"); node id�� ������ �ִ� �ָ� ã�Ƽ� ����ϱ� ����
			Button btnInput = (Button) parent.lookup("#btnInput");
			TextField txtStocks = (TextField) parent.lookup("#txtStocks");
			TextField txtCapital = (TextField) parent.lookup("#txtCapital");
			TextField txtRoe = (TextField) parent.lookup("#txtRoe");
			TextField txtNumberOfStocks = (TextField) parent.lookup("#txtNumberOfStock");
			TextField txtTreasury = (TextField) parent.lookup("#txtTreasury");
			
			
			int i = input.getSelectionModel().getSelectedIndex(); // �ʱⰪ�� -1, 0���� �� �޾ƿ�
			
			//�Է� ��ư Ŭ�� ��(�Է� �� ���� ���� ����)
			btnInput.setOnAction(e->{
				// ����
				if(i!=-1&&i!=listInput.size()-1)
				{ 
					// ���̾�α׿��� �Է��� ������ �Է� ���̺��� Ʃ�� ����Ʈ�� ����
					listInput.set(i,new Stock(
						txtStocks.getText(),
						txtCapital.getText(),
						txtRoe.getText(), 
						txtNumberOfStocks.getText(),
						txtTreasury.getText()));  
					// ����Ʈ���� Ʃ�ÿ� �Ѱ���
					input.setItems(listInput);
					
					// �䱸���ͷ��� ������ ������ ���� ������̺��� Ʃ�� ����Ʈ�� ����
					listResult.set(i, 
							      new Price(listInput.get(i).getStocks(),listInput.get(i).getCapital(), listInput.get(i).getROE(), 
									        listInput.get(i).getNumberOfStock(), listInput.get(i).getTreasury(), r.getText() ));
					// ����Ʈ���� Ʃ�ÿ� �Ѱ���
					result.setItems(listResult);
					
					
				}
				// �Է�(���� ������ ������ ���� ������ �ٸ�)
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
				//���̾�α� â �ݱ�
				dialog.close();
				

			});
			// ��� ��ư Ŭ�� ��
			Button btnCancel = (Button) parent.lookup("#btnCancel");
			// ��� ��ư �Է½� ���̾�α� â ����
			btnCancel.setOnAction(e->dialog.close());
			
			
			// DialogueAdd.fxml ����
			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.setResizable(false); //â ũ�� ����
			
			// ������ ������ ������ ���̾�α� �Է½ÿ� �״�� �޾ƿ�
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
	// ���̾�α� ��
	
	
	public void delAction(ActionEvent e)
	{
		//���� ��ư
		int i = input.getSelectionModel().getSelectedIndex();//�ε�����ȣ ����
		if(i!=listInput.size()-1&&listInput.size()>1&&i!=-1)
		{
			//���õ� ���� ������ ���� �ƴϰ� ����Ʈ�� ���� Ʃ���� ������ Ʃ���� �ϳ� �̻� �ְ� ���õ� ���� �ִ� ���
			//����Ʈ���� Ʃ�� ����
			listInput.remove(i);
		}
		if(i!=listResult.size()-1&&listResult.size()>1&&i!=-1)
		{
			//��������̺� Ʃ�� ����
			listResult.remove(i);
		}
		//result.setItems(listResult); 
	}
	
	
	public void deselectTF(ActionEvent e)
	{
		//�䱸���ͷ� �Է��ϰ� ���� ġ�� ����� ����Ʈ �ٽ� ����
		for(int i = 0; i<listInput.size()-1;i++)
		{
			listResult.set(i, new Price(listInput.get(i).getStocks(),listInput.get(i).getCapital(), listInput.get(i).getROE(), 
						        listInput.get(i).getNumberOfStock(), listInput.get(i).getTreasury(), r.getText()));
			
		result.setItems(listResult); //�ٽ� ���õ� ���� �Է�
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
