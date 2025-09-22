package com.company.java009;

//1. 클래스는 부품 객체
//2. 클래스는 속성(멤버변수)과 행위(멤버함수)를 갖는다

/* Object								2)Object	{Object	}				3)
 	 ↑
  Product(name=null, price=0 초기화)		1)Product();{super()<-Object 호출}	4) Product p1 = new Product();
 */

class Product extends Object {//Object 상속, 생략 가능
	String name;
	int price;
	public Product() { super(); }
	public Product(String name, int price) { super(); this.name = name; this.price = price; }
	@Override
	public String toString() { return "Product [name=" + name + ", price=" + price + "]"; }  
}




//////////////////////////////////////////////////
public class Class004 {

	public static void main(String[] args) {
		
		Product p1 = new Product(); //1. 공간 빌리고 객체 생성 2. 생성자 호출 3.p1 주소 부여
		System.out.println(p1);

	}

}
//////////////////////////////////////////////////
/*
-----------------------------------[runtime data area]
[method : 정보, static, final - 공용 정보] Product.class, Class004.class 설계도 올라감
-------------------------------------------------------	
[heap : 동적]					|[stack : 잠깐 빌리기] Product p1 = new Product();

1번) 1번지[name, price]
						Object();
2번) 1번지[name=null, price=0]    <- 3번)p1[1번지] 주소 주기
								|main
--------------------------------------------------------





 */