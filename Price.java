package application;

import javafx.beans.property.SimpleStringProperty;

public class Price {
	//결과값 테이블에 들어갈 튜플을 정의한 클래스
	private SimpleStringProperty StocksName; //종목이름
	private SimpleStringProperty resonablePrice;//적정주가
	private SimpleStringProperty _90Price;//90%지속
	private SimpleStringProperty _80Price;//80%지속
	
	public Price(String stocks, String capital, String ROE, String numberOfStock, String treasury, String r){
		
		this.StocksName = new SimpleStringProperty(stocks);
		double A;//자본 임시변수
		try {
			A = Double.parseDouble(capital)*100000000;
		}catch(NumberFormatException e) {//공백문자를 받아서 parse할수 없는 경우 예외처리
			A = 0;
		}
		
		double B;//ROE 임시변수
		try {
			B = Double.parseDouble(ROE)*0.01;
		}catch(NumberFormatException e) {
			B = 0;
		}
		
		double R;//요구수익률 임시변수
		try {
			R = Double.parseDouble(r)*0.01;
		}catch(NumberFormatException e) {
			R = 0;
		}
		
		double C;//주식수 임시변수
		try {
			C = Double.parseDouble(numberOfStock);
		}catch(NumberFormatException e) {
			C = 0;
		}
		
		double D;//자기주식수 임시변수
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
			//자본이나 요구수익률이 제대로 입력되지 않은 튜플은 결과값을 보여줄 필요가 없음
			StocksName =  "" ; 
			resonablePrice = "";
			_90Price = "";
			_80Price = "";
		}else {
			double rP = (A + A*(B-R)/R)/(C-D);//적정주가 계산
			double _90P = (A + A*(B-R)*0.9/(1+R-0.9))/(C-D);//초과이익이 90%만큼 지속될 경우의 적정주가 계산
			double _80P = (A + A*(B-R)*0.8/(1+R-0.8))/(C-D);//초과이익이 80%만큼 지속될 경우의 적정주가 계산
			
			resonablePrice = "" + (int)(rP);//소수점 밑을 버리기 위한 캐스팅
			_90Price = "" + (int)(_90P);
			_80Price = "" + (int)(_80P);
		}
		
		this.resonablePrice = new SimpleStringProperty(""+ resonablePrice );//필드에 계산한 값 세팅
		this._90Price = new SimpleStringProperty(""+ _90Price );//필드에 계산한 값 세팅
		this._80Price = new SimpleStringProperty(""+ _80Price );//필드에 계산한 값 세팅
		
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
