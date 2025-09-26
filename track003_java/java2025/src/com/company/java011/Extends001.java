package com.company.java011;
//1.클래스=부품객체
//2.클래스=상태+행위

//1. 상속? 클래스의 재사용
/* 실선(확장 연결)-속이 빈 화살표(일반화)
  Object		3)			 {	  Object	}  4)
  	↑			
  	A int a		2) 			 {a   A()	 a=10} 5)
  	↑
  	B int b		1) new : 1번지{b	->B()  	 b=20] 6)
  	
  	1번지에 생성자 부르니까 super 때문에 A도 부르고 Object도 부름
  	그래서 a 명시적 초기화 -> b 명시적 초기화로 내려옴
  	-------------------------------------------------
  	B b1 = new B(); b1.show();
  	-------------------------------------------------
  	1) extends 상속
  	2) is a :  A는 Object, B는 Object
  	3) 생성자 호출 : B()->A()-Object 1 2 3
  	4) 객체 생성 : Object->A()->B()  4 5 6
 */
class A extends Object{
	int a=10;
	public A() { super(); }
	
}

class B extends A{
	int b=20;
	public B() { super(); } //super=A
	
	public void show() {System.out.println(super.a + "\t" + this.b);}
	
}

//////////////////////////////////////////////
public class Extends001 {
	
	public static void main(String[] args) {
		
		B b1 = new B(); b1.show();
	}

}
/////////////////////////////////////////////