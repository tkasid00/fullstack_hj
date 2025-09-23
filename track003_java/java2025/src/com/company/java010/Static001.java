package com.company.java010;

//1.클래스=부품객체
//2. 클래스=상태(멤버변수)+행위(멤버함수)
class Farm{
	//상태-멤버변수
	String name;   //인스턴스 변수-heap area - new 0 - 생성자와 연관/cat(1번지).name, cat(2번지).age
	int age;	   //인스턴스변수 heap area - new01 -생성자 -dog(1번지).name, dog(2번지).age
	
	static String FarmName = "(주)동물농장";  //클래스 변수-Farm.FarmName <명시적 초기화, 변수 미선언 시 null 출력
											//		   클래스명.변수명   <new 없이 공용 사용 가능(static)
	static int FarmNum;	//클래스 변수 - method area -new 관련x -생성자x
	static String FarmBoss;
	static {FarmNum=2; FarmBoss="신동엽"; }  //초기화 블록, static 빼먹으면 null, 0 출력
	
	//행위-멤버함수
	static void num_plus() {FarmNum++; /*this.age++;*/} //클래스 메서드 static - this 사용x
										//this.age++;는 개별 지정이라 공통 콘텐츠에 올릴수 없음
										//new에서 heap 공간 빌려와야됨
	
	
	void show() { //인스턴스 메서드(this로 지정)
		System.out.println("\n\n:::::::::::::::::::::::::::::");
		System.out.println("::이름 : " + this.name);
		System.out.println("::나이 : " + this.age);
		System.out.println("::인원 : " + Farm.FarmNum);
		
	}
}

//////////////////////////////////////////////
public class Static001 {
	public static void main(String[] args) {
		System.out.println("\n\n0. 동물농장");
		System.out.println("::회사이름 : " + Farm.FarmName);
		System.out.println("::회사사장 : " + Farm.FarmBoss);
		System.out.println("::회사인원 : " + Farm.FarmNum);
		
		System.out.println("\n\n1. 동물농장 식구-this-각각");
		//		1)new : 메모리 빌리기, 객체 생성 	2)Farm() 생성자 초기화		3)cat번지 생성
		Farm cat = new Farm();  //ㄴ조립 
		cat.name="꽁냥이"; cat.age=10; cat.show();  //사용하기
		Farm dog = new Farm(); 
		dog.name="홍차"; dog.age=7; 
		/*dog.num_plus();*/ Farm.num_plus();
		dog.show();
		
	}

}
///////////////// 클래스 변수 ///////////////////////////////
/*초기화 순서 : 기본값		명시적 초기화		초기화 블록		생성자(instance변수에서만 의미 존재)
  FarmNum	 0				null		o 2					x
  FarmBoss	 null			null		o 신동엽				x
  FarmBoss	 null		(주)동물농장		x (주)동물농장			x
 ///////////////// 인스턴스 변수 ////////////////////////////
 	cat	 :name=null,	x(null,0->기본값 유지)	 x				null, 0
 			age=0		(static final 사용 시)
 
------------------------[ runtime data area]-------------
[method: 정보, static(new 없이 사용 가능), final : 공용정보] 
Farm.class, static001.class			*설계도
FarmNum=2; FarmBoss="신동엽"; String FarmName = "(주)동물농장";
---------------------------------------------------------
[heap: 동적]            | [stack : 잠깐빌리기]
2번지(name=null, age=0) <- dog[2번지]
1번지(name=null, age=0) <- cat[1번지]
		   			   |main
---------------------------------------------------------
*/
