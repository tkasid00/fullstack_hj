package com.company.java008_ex;

public class MethodEx007 {

		public static int add(int x, int y) {return x+y;}  //1
	   public static int  add(byte x, byte y)   {return x+y;}   //2
	   public static int  add(short x, short y) {return x+y;}   //3
	   public static long add(int  x, int y)    {return x+y;}   //4
	   public static long add(long  x, long y)  {return x+y;}   //5
	   
	   public static void main(String[] args) { 
		   //Q1. 메서드 오버로딩?
		   	// 비슷한 목적의 메서드 이름을 같게 하는 것.
		   
		   //Q2. 오류 이유 달기 - 파라미터의 개수와 자료형으로 구분
		   // 1번과 4번 파라미터의 자료형이 같음. 
		   //x, y -> a, b 변수명 변경해도 동일 오류 발생 

	   }
	}

	

}
