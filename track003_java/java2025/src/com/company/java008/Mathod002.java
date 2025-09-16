package com.company.java008;

public class Mathod002 {
	//1) 마법상자 정의
//	public static 리턴값 메서드명(파라미터=재료=인수=인자){}
	
	public static void myint(int a ) {System.out.println(a);}
	public static void ten(int b) {System.out.println(b*10);}
	
	public static void add(int money, int bitcoin) {System.out.println(money+bitcoin);}
	
///////////////////////////////////////////////////////////	

	public static void main(String[] args) {
		//2) 사용
		
//public static void myint(int a ) {System.out.println(a);}
						myint(42);
						myint(3);
//	public static void ten(int b) {System.out.println(b*10);}						
						ten(10);

//	public static void add(int money, int bitcoin) {System.out.println(money+bitcoin);}						
							add(10, 	7);
							add(230, 	50);
	}
///////////////////////////////////////////////////////////
}
