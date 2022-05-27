package application;

public class User {
	String phone; //뒷자리4개
	int time1; //시 9~17 
	int time2; //분 0~59
	public MenuNode link;
	
	 public User(String phone, int time1, int time2){
		  this.phone = phone;
		  this.time1 = time1;
		  this.time2 = time2;
		  this.link = null;
	 }
	 
	 public User(String[] pickH) {
		// TODO Auto-generated constructor stub
	}

	public String getPhone(){
		 return phone;
	 }
	 public int getTime1(){
		 return time1;
	 }
	 public int getTime2(){
		 return time2;
	 }
	 
	 public void printUser() {
		System.out.println("휴대전화: "+phone);
		System.out.println("시간(시): "+time1+"시");
		System.out.println("시간(분): "+time2+"분");
	 }
}
