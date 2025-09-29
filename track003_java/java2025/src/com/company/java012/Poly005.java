package com.company.java012;


/*
 		Object
 		  ↑
 	    Animal (String name; int age;)
 	    ↑    ↑
 	   Cat  Person(String jumin; void show();)
 (String number; void show();)
 */

class Animal {String name; int age;

public Animal() { super();  }//Object()<-객체 만드는 역할, 필드 소환 전 만들어야됨
							// 컴파일러가 자동 생성 x -> 오버로딩, 상속 시

//디폴트 생성자 깨짐
public Animal(String name, int age) { super(); this.name = name; this.age = age; }
public void show(){System.out.println("Animal");}
			 
}

class Cat extends Animal{
	String number;
	public void show() {System.out.println("CAT : " + super.name + "/" +super.age);}
}

class Person extends Animal{
	String jumin;
	public void show() {System.out.println("Person : " + super.name + "/" +super.age);}
}
/////////////////////////////////////////////////////////
public class Poly005 {
	public static void main(String[] args) {
		//하나의 타입(부모)으로 여러 타입(자식들)의 객체 관리
		//부모		  =	 자식 / 업캐스팅 / 타입캐스팅x
		Animal[] anis = {new Cat(), new Cat(), new Person(),  new Person()};
//  1.보장 Animal 사용 시 {String name; int age;} 이용 가능	
// 					 = new 	Cat(){String number; @show();} - Animal{String name; int age; show();} 재사용
//  1.보장 Animal 사용 시 {String name; int age;} 이용 가능	
//		 			 = new 	Person(){String jumin; @show();} - Animal{String name; int age; show();} 재사용
		Animal controller = null;
		controller = anis[0]; controller.show();
		controller = anis[1]; controller.show();
		controller = anis[2]; controller.show();
		controller = anis[3]; controller.show();
	
	}

}
