package com.company.java009_ex;

class Coffee {
	
	String name;
	int price, num;

	public Coffee() {
		this.name = "아메리카노";
		this.num = 1;
		this.price = 2000;

	}

	public Coffee(String name, int price, int num) {
		super();
		this.name = name;
		this.price = price;
		this.num = num;
	}

	void show() {
		System.out.println("=====커피");
		System.out.printf("커피명 : %s \n커피잔수 : %d \n커피가격 : %d\n", this.name, this.num, this.price);
	}
}

//////////////////////////////////////////////////////
public class ClassEx003 {

		   public static void main(String[] args) {
		   Coffee a1 = new Coffee("까페라떼" ,2 , 4000);  a1.show();
		   Coffee a2 = new Coffee();                    a2.show();
		  }
		   
		   
		
}
//////////////////////////////////////////////
