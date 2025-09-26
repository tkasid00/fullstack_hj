package com.company.java011;

/* 상속 : 클래스의 재사용
 		Object					3)Object{							}   4)괄호 닫히면서 객체가 가진 기본 속성 사용 가능
   		  ↑		(실선-속이 빈 화살표)
 		Animal					2) {name, age  / eat(), sleep(), poo()} 5)괄호 닫히면서 생성자가 null, 0으로 초기화
 	  	↑   ↑
 	  Cat	Person				1)cat(){super}}							6)괄호 닫으면서 객체 생성 마무리	
 {animal_card / qukquk()}		0) 1번지{animal_card /qukquk() 
 -------------------------------------
 Cat dobby = new Cat();
 --------------------------------------
 1)Cat은 Animal이다 ↑
 2)생성자 호출 순서 : Cat() -> Animal() -> Object()
 3)객체 생성 순서 : Object -> Animal -> Cat
 */

class Animal{
	String name;
	int age;
	void eat() {System.out.println("먹고");}
	void sleep() {System.out.println("자고");}
	void poo() {System.out.println("배변");}
	
}
class Cat extends Animal{
	String animal_card;
	void qukqul() {System.out.println(this.name + "-꾹꾹이");}
}
class Person{}

//////////////////////////////////
public class Extends002 {

	public static void main(String[] args) {
		Cat dobby = new Cat();
		dobby.name="dobby"; 
		dobby.age=10;
		dobby.animal_card="ani-140426";
		dobby.eat(); dobby.sleep(); dobby.poo(); dobby.qukqul();
		

	}

}
