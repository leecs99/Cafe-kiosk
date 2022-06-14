package application;

import javafx.beans.property.SimpleStringProperty;

public class Stock {//테이블에 들어가는 튜플을 정의한 클래스
	private SimpleStringProperty Stocks;
	private SimpleStringProperty capital;
	private SimpleStringProperty ROE;
	private SimpleStringProperty numberOfStock;
	private SimpleStringProperty treasury;
	
	public Stock(String Stocks, String capital, String ROE, String numberOfStock, String treasury) {
		
		this.Stocks = new SimpleStringProperty(Stocks);
		this.capital = new SimpleStringProperty(capital);
		this.ROE = new SimpleStringProperty(ROE);
		this.numberOfStock = new SimpleStringProperty(numberOfStock);
		this.treasury = new SimpleStringProperty(treasury);
	}

	public String getStocks() {
		return Stocks.get();
	}

	public void setStocks(String stocks) {
		this.Stocks.set(stocks);
	}

	public String getCapital() {
		return capital.get();
	}

	public void setCapital(String capital) {
		this.capital.set(capital);
	}

	public String getROE() {
		return ROE.get();
	}

	public void setROE(String ROE) {
		this.ROE.set(ROE);;
	}

	public String getNumberOfStock() {
		return numberOfStock.get();
	}

	public void setNumberOfStock(String numberOfStock) {
		this.numberOfStock.set(numberOfStock);
	}

	public String getTreasury() {
		return treasury.get();
	}

	public void setTreasury(String treasury) {
		this.treasury.set(treasury);
	}
}