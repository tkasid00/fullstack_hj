package com.company.java012;

/*
1.클래스=부품객체
2.상속=재활용

 	Object		Object
 	  ↑			  ↑
 	TestA1 =/=	TestB1
 	(int a)		(int b)
예) 	 110v		 220v
	일자형 나사	십자형 나사   ->다른 부품임

 */

class TestA1 extends Object{int a;}
class TestB1 extends Object{int b;}

//////////////////////////////////////////////////////
public class Poly001 {
	public static void main(String[] args) {
		TestA1 ta1 = new TestA1();
		
		//TestB1 tb1 = ta1;   
		//오류 이유 :
		//Type mismatch: cannot convert from TestA1 to TestB1
		//클래스도 자료형(틀-object)

	}

}
//////////////////////////////////////////////////////