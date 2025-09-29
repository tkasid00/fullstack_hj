package com.company.java012;
/*
1.클래스=부품객체(상태+행위)
2.상속=재활용

 	Object		
 	  ↑			  
 	TestA3
 	(int a, toString) 
	  ↑
	TestB3
	(int b, toString)
 */
class TestA3 extends Object{
	int a =10;
	@Override
	public String toString() { return "TestA3 [a=" + a + "]"; }
}

class TestB3 extends TestA3{
	int b = 10;
	@Override
	public String toString() { return "TestB3 [b=" + b + "]"; } 
}

//////////////////////////////////////
public class Poly003 {
	public static void main(String[] args) {
		//자식  =  부모   -> 다운캐스팅
		TestB3 tb = (TestB3) new TestA3();
		//1. TestB3 tb 범위 : {int b = 10, toString} - TestA3{int a =10, toString}
		//2. TestA3()은 {int a =10, toString}만 가능
		//3. TestB3{int b = 10, toString} 보장 안 됨
		//	보장 : {int b = 10, toString} - TestA3{int a =10, toString}(1번지)
		//																=1번지{int a =10, toString}
		//이론상 타입캐스팅은 가능하지만 TestB3은 생성자 부른 적이 없어서 초기화가 되지 않았음
		// {int b = 10, toString} 사용 불가!
		
	}

}
//////////////////////////////////////