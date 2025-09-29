package com.company.java012_ex;
 
//Q1. 상속도를 그리시오. 
/*			Object
 			  ↑
 			TestA2 {int a=10, toString}
 			  ↑
 			TestB2 {int b=10, @toString} - {int a=10, toString}	
 */

class TestA2 extends Object{  
   int a=10;
   @Override public String toString() { return "TestA2 [a=" + a + "]"; }    
}
class TestB2 extends TestA2{
   int b=10;
   @Override public String toString() { return "TestB2 [b=" + b + "]"; }   
}
/////////////////////////////////////////////////
public class PolyEx001 {
   public static void main(String[] args) {
      TestA2  ta = new TestB2();
      //Q2. 15번째줄에서   TestA2  ta 는 클래스의 무엇을 사용할수 있을까요? 코드의 의미
      //	>TestA2 {int a=10, toString} 사용 가능.
      
      //Q3. 15번째줄에서   TestB2() 는 클래스의 무엇을 사용할 수 있을까요?
      //	>TestB2 {int b=10, @toString} - {int a=10, ----} 사용 가능
      
      System.out.println(ta); // Q4. 출력내용과 이유?   TestA2  vs  TestB2
      						  //     >TestB2 / 자식 생성자 호출로 오버라이드됨
      System.out.println(ta.a); //Q5.사용가능?
      							//   >int a=10,	@toString
      							//	 >자식 클래스 TestB2 내부의 int a사용 가능+TestA2 보장 범위 안이라 가능해짐.
      //System.out.println(ta.b); //Q6.사용가능?
      							  // >불가능.
      							  // >초기화는 됐지만 TestA2 보장 범위 밖이라 타입캐스팅 필요
   }
}
/////////////////////////////////////////////////