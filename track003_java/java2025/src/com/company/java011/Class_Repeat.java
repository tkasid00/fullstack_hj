package com.company.java011;
// 1.클래스는 부품 객체
// 2.클래스는 상태와 행위

// [설계도] 1단계
//class 	Toy{
//	//상태 : 멤버변수
//	private String name;		//인스턴스 변수 - heap area - new - 생성자 - this(각각)
//	private int age;			// 인스턴스 변수
//	static final String company="(주)703toyland"; 	//toy.company -> 클래스 변수 - method - new, 생성자 x - 당장 사용 가능
//	static int num ;				//클래스 변수(static = 공용 사용) 
//	
//	//행위 : 멤버함수
//	public void show() {
//		System.out.println("NAME : " +this.name);
//		System.out.println("Age : " +this.age);
//	}
//
//	 public String getName() { return name; }  
//	 public void setName(String name) { this.name = name; }  
//	 public int getAge() { return age; }  
//	 public void setAge(int age) { this.age = age; }
//
//	 public Toy() { super();  }
//
//	 public Toy(String name, int age) { super(); this.name = name; this.age = age; }
//
//}

////////////////////////////////////////////
public class Class_Repeat { 
	public static void main(String[] args) {
	
	Toy kitty = new Toy();	//[장난감 제작]2단계 1)new 메모리, 객체   -   2)생성자	 -   3)kitty번지
	//kitty.name="핼러윈키티"; 
	kitty.setName("핼러윈키티");
	kitty.setAge(3);
	kitty.show();
			
	Toy hachuping = new Toy("오로라핑", 3);
	hachuping.show();
	
	//[장난감 사용]3단계

	}
}
////////////////////////////////////////////
/*
 					기본값 		명시적 초기화			초기화 블록		생성자
(static)company		null	  (주)703toyland	   x->(주)703toyland	  	x 	Toy.name
(static)num 		0				x->0			x->0			x	Toy.age
-----------------------------------------------------------------------------
	kitty	{name=null, age=0}     x->유지			x->유지			x->유지			   this.name
  hachuping	{name=null, age=0}	   x->유지			x->유지		{name="오로라핑", age=3} this.name

 --------------------------------------------------
 method[클래스 정보] Toy.class , Class_Repeat.class, 
 company="(주)703toyland", Toy.num=0
 --------------------------------------------------
 heap[동적] 					| stack[임시 저장 공간]
2번지{name="오로라핑", age=3}  <-hachuping
1번지{name=핼러윈키티, age=3}  <-kitty[1번지]
 							| main
---------------------------------------------------
 
 */


