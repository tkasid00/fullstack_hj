package com.company.java009_ex;

import java.util.Scanner;

class MyPrice001 {
//	Scanner scanner = new Scanner(System.in); 여기 아님!
	String name;
	int price;

	void input() {
		Scanner scanner = new Scanner(System.in); //기능, 동작이기 때문에 여기가 더 적합
		System.out.print("상품 이름 입력> ");
		this.name = scanner.next(); //여기도 this 붙여주는게 좋음

		System.out.print("상품 가격 입력> ");
		this.price = scanner.nextInt();
	}

	void show() {
		System.out.println("상품 정보입니다");
		System.out.println("상품 이름 : " + this.name);
		System.out.println("상품 가격 : " + this.price);
	}

}

////////////////////////////////////////////
public class ClassEx002 {
	public static void main(String[] args) {
		MyPrice001 p1 = new MyPrice001();
		//1. new(번지, 객체 생성) 2.생성자 MyPrice001 초기화 3. p1=1번지
		p1.input();
		p1.show();

	}

}
///////////////////////////////////////////
/*
-----------------------------------[runtime data area]
[method : 정보, static, final - 공용 정보] 
MyPrice001.class, ClassEx002.class		클래스(설계도)
---------------------------------------------------객체(p1), 인스턴스(p1.name="apple")										
[heap : 동적]							|[stack : 잠깐 빌리기]
										  p1.show(){} 
1번지									  p1.input(){} 
{name=null, price=0, input(), show()}	<-p1[1번지]

										|main
--------------------------------------------------------

 */