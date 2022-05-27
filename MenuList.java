package application;

public class MenuList{
	private MenuNode head;
	private MenuNode tail;

	public MenuList() { 
		this.head = null;
		this.tail = null;
	}

	//메뉴탐색(메뉴의 번호를 전달) 
	  public MenuNode searchNode(int number) {
	      if(head == null) return null;  //head가 null이면 노드0개
		  MenuNode tempNode = head;
		  while(tempNode != null) {
			  if(number== tempNode.getNum()) return tempNode;  //일치한노드
			  tempNode = tempNode.next;         
		  }
	      return null;  //저장된 노드가 없는 경우, 탐색에 실패한 경우
	   }
	
	//메뉴추가
	public void insertMenuNode(int number, String name, int price) { 
		MenuNode search = searchNode(number); //노드 탐색결과
		//일치하는 노드없음	
		if(search == null){
			MenuNode newNode = new MenuNode(number, name, price);
			//노드 0개인 경우(첫 노드 삽입)
			if(head == null){  
				head = newNode;
				tail = newNode;
				head.next = null;
			}
			else {      //새로운 노드 추가
				tail.next = newNode;
				tail = tail.next;
			}
		}
		else{
			search.setmCount(1);
			search.setmPrice(price);		
		}
	}
	
	public int TotalPrice() {
		MenuNode tempNode = head;
		int totalPrice = 0;
		while(tempNode != null) {
			totalPrice += tempNode.mPrice;
			tempNode = tempNode.next;
		}
		return totalPrice;
	}
	
	public String printMenu() {
		MenuNode tempNode = this.head; 
		String menuP = "";
		while(tempNode != null) {
			//System.out.println(tempNode.mName+"\t"+tempNode.mCount+"\t"+ tempNode.mPrice);
			menuP = menuP + (String)("\n"+ tempNode.mName+"\t"+tempNode.mCount+"\t"+ tempNode.mPrice);
			tempNode = tempNode.next;
		}
		System.out.println(menuP);
		return menuP;
	}
	
}
