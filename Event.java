package application;

public class Event {
	String SaleName = "[적용된 할인이 없습니다]";
	int totalPrice = 0;
	int SalePrice = 0;
	int finalPrice = 0;
	
	public Event(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setPrice(int totalPrice) {
		this.totalPrice = totalPrice;
		if(totalPrice >= 30000) {
			this.SaleName = "[3만원 이상 15%할인적용]";
			this.SalePrice = (int)(totalPrice*0.15);
			this.finalPrice = totalPrice - SalePrice;
		}
		else if(totalPrice >= 20000) {
			this.SaleName = "[2만원 이상 10%할인적용]";
			this.SalePrice = (int)(totalPrice*0.1);
			this.finalPrice = totalPrice - SalePrice;
		}else {
			this.SaleName = "[적용된 할인이 없습니다]";
			this.SalePrice = 0;
			this.finalPrice = totalPrice;
		}
	}
	public String getTotalPrice() {return String.valueOf(totalPrice);}
	public String getSaleName() {return String.valueOf(SaleName);	}
	public String getSalePrice() {return String.valueOf(SalePrice);	}
	public String getFinalPrice() {return String.valueOf(finalPrice);	}

	
	
	public void printEvent() {
		System.out.println("적용된 할인: \t"+SaleName);
		System.out.println("할인전 금액: \t"+this.totalPrice+"원");
		System.out.println("할인 금액: \t"+this.SalePrice+"원");
		System.out.println("최종 금액: \t"+this.finalPrice+"원");
	}
	
	
	
}
