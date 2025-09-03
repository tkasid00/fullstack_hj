package com.company.java003_ex;

public class CastingIntegerEx {
	public static void main(String[] args) {
			  
			  short sh1 = 1; 
			  short sh2 = 2; 
			  short result = sh1 +sh2; // 1(int)+2(int) 오류 발생!

			  short result = (short) (sh1 +sh2);
			  int result = sh1 +sh2;
	}
}
