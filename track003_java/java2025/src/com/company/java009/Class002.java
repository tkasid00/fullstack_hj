package com.company.java009;

//1. 클래스는 부품 객체
//2. 클래스는 속성(멤버변수)과 행위(멤버함수)를 갖는다

class Animal002{
	//속성 - 멤버변수
	String name;
	int age;
	
	//행위 - 멤버함수
	void show() {System.out.println(this.name + "\t" + this.age);}
}
///////////////////////////////////
public class Class002 {
	public static void main(String[] args) {
		Animal002 a1 = new Animal002(); 
		//1. new(1번지 공간 빌리기, 객체 생성) 2. Animal002() 초기화 3. a1=1번지 주소 부여
		a1.name="dobby"; a1.age=3; a1.show();
		Animal002 a2 = new Animal002(); 
		a2.name="butter"; a2.age=7; a2.show();
		
	}

}
////////////////////////////////////
/*
-----------------------------------[runtime data area]
[method : 정보, static, final - 공용 정보] 
Animal002.class, Class002.class(<-public이 우선순위 가짐)	클래스(설계도) ->(인스턴스화:heap 공간에 객체 생성) 객체(object/a1, a2) 
-------------------------------------------------------													->인스턴스(dobby, butter)
[heap : 동적]					|[stack : 잠깐 빌리기]
21번쨰 : 2번지{name=butter,age=7}	<-a2[2번지] al.show(this.name (2번지의 name))
20번쨰 : 2번지{name=null,age=0}	<-a2[2번지]						
19번째 : 1번지{name=dobby,age=3}	<-a1[1번지] al.show(){this.name (1번지의 name)}
17번째 : 1번지{name=null,age=0}	<-a1[1번지]
								|main
--------------------------------------------------------





 */