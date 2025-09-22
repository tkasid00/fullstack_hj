package com.company.java009;
//1. 클래스는 부품객체
//2. 클래스는 상태(멤버변수)+행위(멤버함수)
	
class Car31 extends Object{} //생성자 Car31() - 컴파일러가 기본 생성자 자동으로 생성
class Car32{  //extends Object 생략돼 있음
	String color;
	//alt + shift + s ★밑에서 3번째(2,3,4)

	public Car32() { super(); } //기본 생성자, 무조건 있어야됨 상속 시 오류남 Car32@279f2327
	public Car32(String color) {this.color = color; } //기능 추가, super(); 생략 가능
													  //Car32@2ff4acd0	null ->Car32 [color=null]	null
													  //Car32@3e3abc88	red ->Car32 [color=red]	red

	@Override public String toString() { return "Car32 [color=" + color + "]"; }  
	
	class Car33 extends Car32{}
}
////////////////////////////////////////////////
public class Class003_constructor {
	public static void main(String[] args) {
		Car31 car1 = new Car31(); //1. new(메모리 빌려서 객체 생성) 2.Car31() 초기화 3. car1번지
		System.out.println(car1); //Car31@5305068a
		
		Car32 car2 = new Car32(); 
		System.out.println(car2); //Car32@279f2327
		
		Car32 car3 = new Car32(); 
		System.out.println(car3 + "\t" + car3.color);

		Car32 car4 = new Car32("red"); 
		System.out.println(car4 + "\t" + car4.color);
		
		
	}

}
////////////////////////////////////////////////

/*	Q1. 클래스란? [설계도,레시피] 			  	예) [Car31.class, Car32.class, Class003.class]
 * 	Q2. 객체? [실제(new)로 만든 장난감(결과물)] 	예) [car1, car2, car3]
 * 	Q3. 인스턴스? [각각의 장난감들] 				예) [car1(x), car2(null), car3(red)]
 */
 