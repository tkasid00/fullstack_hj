package com.company.java010_ex;


	class Area1{
		
//		double a,b;   지워도 문제 x

		public Area1() { super(); }
		
		static double pi =  3.14159;
		
		static double rect(double a, double b) {return a*b;}
		static double triangle(double a, double b) {return a*b/2;}
		
		
//		public Area1(double a, double b) {
//			super();
//			this.a = a;
//			this.b = b;
//		}

	}
///////////////////////////////////////////////////////
public class StaticEx001 {

	public static void main(String[] args) {
		
		  System.out.println("원의 면적    : " + 10 * 10 * Area1.pi);
		   System.out.println("사각형의 면적 : " + Area1.rect(10, 5));
		   System.out.println("삼각형의 면적 : " + Area1.triangle(10, 5));


	}

}
