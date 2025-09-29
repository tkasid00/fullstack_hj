package com.company.java012;
/*
1.클래스=부품객체(상태+행위)
2.상속=재활용

 	Object		
 	  ↑			  
 	TestA2
 	(int a, toString) 
	  ↑
	TestB2
	(int b, toString)
 */

class TestA2 extends Object{ 
				int a=10;
				@Override
					public String toString() { return "TestA2 [a=" + a + "]"; } 
				}

class TestB2 extends TestA2{ 
				int b=20;
				@Override
					public String toString() { return "TestB2 [b=" + b + "]"; } 
				}

///////////////////////////////////////////
public class Poly002 {

	public static void main(String[] args) {
		//부모    = 	 	자식   ->업캐스팅
		
		TestA2 ta = new TestB2(); 	
		//1.TestA2 ta {int a, toString 사용 가능}
		//2.new TestB2(); new로 hepa area에 객체 생성하고 {int b, toString} 사용 가능하게 TestB2 호출
		//					=1번지 TestB2(){int b=20;, toString} -> TestA2(){int a=10;, toString} ->Object(){}
		//3. ta{int a, toString}[1번지] = 1번지{int b=20;, @toString/본인} - {int a=10;, toString/부모}
		
		System.out.println(ta);   //TestB2 [b=20] 자식 생성자 호출로  @toString 오버라이드 됨(=최신)
		
		System.out.println(ta.a); //10(자식 int a=10;)
		
		System.out.println(((TestB2)ta).b); //20, 형변환
	}

}
///////////////////////////////////////////

//생성자는 인스턴스 변수를 초기화해서 사용할 수 있게 해줌
//TestA2 ta = new TestB2();의 의미는  TestB2까지 초기화는 해주지만 사용은 TestA2{int a, toString}만 가능.
//따라서 형변환을 통해 TestB2의 요소도 사용할 수 있음