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
class TestA4 extends Object{
	int a =10;
	@Override
	public String toString() { return "TestA4 [a=" + a + "]"; }
}

class TestB4 extends TestA4{
	int b = 20;
	@Override
	public String toString() { return "TestB4 [b=" + b + "]"; } 
}
////////////////////////////////////////////////////
public class Poly004 {

	public static void main(String[] args) {
		TestA4 ta = new TestA4();
		//1. ta 보장-{int a, toString} = 1000번지 {int a, toString} - {}
		
		TestB4 tb = new TestB4();// 호출 순서 TestB4 - TestA4- Object
		//2. tb 보장-{int b, @toString} - {int a, ----(toString우선권 밀림)}
		//						=2000번지 {int b, @toString} - {int a, ----(toString우선권 밀림)}
		
		ta = new TestB4(); //5. 부모에 자식을 담은 적이 있어야 한다(업캐스팅)->타입캐스팅 x
		//ta{int a, toString} =  3000번지{int b, @toString} - {int a, ----}
		
		tb		  =		(TestB4) ta; //4. 자식=부모(다운캐스팅)->타입캐스팅 필요
		//tb : int b, @toString} - {int a, ----(toString우선권 밀림)}
//					int b는 생성자 호출x 못씀//	=1000번지 {int a, toString} - {} 
//				 ta = new TestB4() 업캐스팅	=3000번지 {int a, toString} - {} 
		
		System.out.println(tb);
		System.out.println(tb.b);
		System.out.println(tb.a);
		//							
	}

}
////////////////////////////////////////////////////
// ta, tb가 new TestA4(); new TestB4(); 초기화를 했음에도 tb=ta;사용 못하는 이유는 번지수가 다르기 때문.
//1000번지 청소 범위와 2000번지 청소 범위가 다름
//따라서 새로 업캐스팅 주소 3000번지를 만들어야 사용 가능해짐
//보장 범위를 넘는 건 타입캐스팅으로 확장해야됨