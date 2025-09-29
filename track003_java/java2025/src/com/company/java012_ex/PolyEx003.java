package com.company.java012_ex;
//Q1. 상속도를 그리시오. 
/*		Object
		  ↑
		TestA4{a=10, toString()}
		  ↑
		TestB4{b=20, @toString()} - {a=10, ----}
*/

class TestA4  extends Object{  
 int a=10;
 @Override public String toString() { return "TestA4 [a=" + a + "]"; }
}
class TestB4  extends TestA4{  
 int b=20;
 @Override public String toString() { return "TestB4 [b=" + b + "]"; }
}
/////////////////////////////////////////////////
public class PolyEx003 {
 public static void main(String[] args) {
    TestA4  ta = new TestA4();
    //보장 범위  = 실제 생성 범위
    //Q2. TestA4  ta 사용할수 있는범위는?
    //		>TestA4{a=10, toString()}	
    //Q3. new TestA4() 는  heap area 에서 호출되는 생성자의 순서와 객체가 만들어지는 순서는?
    //		>생성자 순서 : TestA4()->Object()
    //		>객체 순서 : Object->TestA4
    
    TestB4  tb = new TestB4();  
    //Q4. TestB4  tb 사용할수 있는범위는?
    //		>TestB4{b=20, @toString()} - {a=10, ----}
    //Q5. new TestB4() 는  heap area 에서 호출되는 생성자의 순서와 객체가 만들어지는 순서는?
    //		>생성자 순서 : TestB4()->TestA4()->Object()
    //		>객체 순서 : Object->TestA4->TestB4
    
    //부모 = 자식/업캐스팅/타입캐스팅x
    ta = new TestB4();
    //Q6. ta가 사용할수 있는 보장하는 변수와 메서드는?
    //		>TestA4{a=10, toString()}
    //Q7.ta = new TestB4(); 에서 new TestB4() 에서 사용할수 있는 범위는? 
    //		>TestB4{b=20, [@toString()} - {a=10], ----}	->{초기화 범위[사용 범위]   	}
    
    //자식 = 부모 / 다운캐스팅 / 타입캐스팅o
    tb         = (TestB4) ta;   
    //Q8. tb         = (TestB4) ta;   에서 tb가 사용할수 있는 범위는?
    //		>TestB4{b=20, @toString()} - {a=10, ----}
    //Q9. 컴피일러시  tb         = (TestB4) ta;  오류가 안나는 이유는?
    //		>ta = new TestB4();로 ta가 가진 주소에서 TestB4의 범위까지 초기화를 했음(업캐스팅)
    
    System.out.println(tb);  //Q10. 출력내용과 그이유는? TestA4  vs  TestB4
    						 // >TestB4, 자식 클래스로 오버라이드됨 @toString()
    System.out.println(tb.b);//Q11. 출력내용?
    						 // >20
    System.out.println(tb.a);//Q12. 출력내용?
    						 // >10
    
 }
}