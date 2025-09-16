package com.company.java008;

public class Mathod001 {
	//1) 마법 상자 - 코드의 재사용
	//public static 리턴값(결과물) 메서드명(파라미터>재료){	 기능 }
	public static void hello() {System.out.println("hello");}
	public static void smile() {System.out.print(":)");}
	public static void line() {System.out.println();}
///////////////////////////////////////////////////////////////////////////////	
	public static void main(String[] args) {	
		//2) 마법 상자 사용
		smile(); hello();
		hello();
		line();
		hello();smile();smile();
		hello();
		smile();hello();
		
		
	}//end main
///////////////////////////////////////////////////////////////////////////////
}//end class
