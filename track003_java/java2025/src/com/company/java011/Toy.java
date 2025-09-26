package com.company.java011;

public class Toy{
	//상태 : 멤버변수
	private String name;		//인스턴스 변수 - heap area - new - 생성자 - this(각각)
	private int age;			// 인스턴스 변수
	static final String company="(주)703toyland"; 	//toy.company -> 클래스 변수 - method - new, 생성자 x - 당장 사용 가능
	static int num ;				//클래스 변수(static = 공용 사용) 
	
	//행위 : 멤버함수
	public void show() {
		System.out.println("NAME : " +this.name);
		System.out.println("Age : " +this.age);
	}

	 public String getName() { return name; }  
	 public void setName(String name) { this.name = name; }  
	 public int getAge() { return age; }  
	 public void setAge(int age) { this.age = age; }

	 public Toy() { super();  }

	 public Toy(String name, int age) { super(); this.name = name; this.age = age; }

	 
	 
	 @Override
	 public String toString() {
		return "Toy [name=" + name + ", age=" + age + "]";
	 }
	 
	 

}