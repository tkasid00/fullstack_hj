package com.company.java011;

import java.util.Arrays;

public class ClassArr001 {
	public static void main(String[] args) {
		//사용방법1
		//Toy [] -> 주소 받을 수 있어
		//new -> 공간(번지, 메모리) 빌려와, Toy 형태의 자료형 3개
		Toy [] toys = new Toy[3];
		System.out.println("1." +toys);
		System.out.println("2." +Arrays.toString(toys));

//		toys[0].setName("핼러윈키티");
//		toys[0].setAge(52);
//		System.out.println("3." + toys[0]);	//<-생성자 부른 적 없기 때문에 값을 넣을 수 없음

		toys[0] = new Toy();  //<-생성자 소환, 이제 사용 가능
		toys[0].setName("핼러윈키티");
		toys[0].setAge(52);
		System.out.println("3." + toys[0]);
		
		//사용방법2
		Toy[] toys2 = new Toy[] {
				new Toy("핼러윈키티", 52), new Toy("하츄핑", 3)
		};
		
		//toys[0].name, toys[0].age
		//toys[1].name, toys[1].age
		
		for(int i=0;i<toys2.length;i++) {
			toys2[i].show();
		}
	
	}

}


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
1번지[null|null|null]			<-toys[1번지]
							| main
---------------------------------------------------

*/