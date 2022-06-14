package application;

import javafx.beans.property.SimpleStringProperty;

public class Price {
	//����� ���̺� �� Ʃ���� ������ Ŭ����
	private SimpleStringProperty StocksName; //�����̸�
	private SimpleStringProperty resonablePrice;//�����ְ�
	private SimpleStringProperty _90Price;//90%����
	private SimpleStringProperty _80Price;//80%����
	
	public Price(String stocks, String capital, String ROE, String numberOfStock, String treasury, String r){
		
		this.StocksName = new SimpleStringProperty(stocks);
		double A;//�ں� �ӽú���
		try {
			A = Double.parseDouble(capital)*100000000;
		}catch(NumberFormatException e) {//���鹮�ڸ� �޾Ƽ� parse�Ҽ� ���� ��� ����ó��
			A = 0;
		}
		
		double B;//ROE �ӽú���
		try {
			B = Double.parseDouble(ROE)*0.01;
		}catch(NumberFormatException e) {
			B = 0;
		}
		
		double R;//�䱸���ͷ� �ӽú���
		try {
			R = Double.parseDouble(r)*0.01;
		}catch(NumberFormatException e) {
			R = 0;
		}
		
		double C;//�ֽļ� �ӽú���
		try {
			C = Double.parseDouble(numberOfStock);
		}catch(NumberFormatException e) {
			C = 0;
		}
		
		double D;//�ڱ��ֽļ� �ӽú���
		try {
			D = Double.parseDouble(treasury);
		}catch(NumberFormatException e) {
			D = 0;
		}
		
		String StocksName;
		String resonablePrice;
		String _90Price;
		String _80Price;
		
		if(A==0||R==0) {
			//�ں��̳� �䱸���ͷ��� ����� �Էµ��� ���� Ʃ���� ������� ������ �ʿ䰡 ����
			StocksName =  "" ; 
			resonablePrice = "";
			_90Price = "";
			_80Price = "";
		}else {
			double rP = (A + A*(B-R)/R)/(C-D);//�����ְ� ���
			double _90P = (A + A*(B-R)*0.9/(1+R-0.9))/(C-D);//�ʰ������� 90%��ŭ ���ӵ� ����� �����ְ� ���
			double _80P = (A + A*(B-R)*0.8/(1+R-0.8))/(C-D);//�ʰ������� 80%��ŭ ���ӵ� ����� �����ְ� ���
			
			resonablePrice = "" + (int)(rP);//�Ҽ��� ���� ������ ���� ĳ����
			_90Price = "" + (int)(_90P);
			_80Price = "" + (int)(_80P);
		}
		
		this.resonablePrice = new SimpleStringProperty(""+ resonablePrice );//�ʵ忡 ����� �� ����
		this._90Price = new SimpleStringProperty(""+ _90Price );//�ʵ忡 ����� �� ����
		this._80Price = new SimpleStringProperty(""+ _80Price );//�ʵ忡 ����� �� ����
		
	}
	
	

	public String getStocksName() {
		return StocksName.get();
	}

	public void setStocksName(String StocksName) {
		this.StocksName.set(StocksName);
	}
	
	public String getResonablePrice() {
		return resonablePrice.get();
	}

	public void setResonablePrice(SimpleStringProperty resonablePrice) {
		this.resonablePrice = resonablePrice;
	}

	public String get_90Price() {
		return _90Price.get();
	}

	public void set_90Price(SimpleStringProperty _90Price) {
		this._90Price = _90Price;
	}

	public String get_80Price() {
		return _80Price.get();
	}

	public void set_80Price(SimpleStringProperty _80Price) {
		this._80Price = _80Price;
	}
	
	

}
