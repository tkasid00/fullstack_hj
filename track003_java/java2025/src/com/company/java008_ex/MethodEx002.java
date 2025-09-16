package com.company.java008_ex;

public class MethodEx002 {
	
//    // public static  리턴값 메서드명(파라미터)
//    test1(10);    //10 출력
//     test2(1.2);   // 1.2 출력
//     hap(3,5);     // 3+4+5한값  12 출력
//     disp(7, '*');  // *******출력

	
	public static void test1(int a) {System.out.println(a);};
	public static void test2(double b) {System.out.printf("%.1f \n", b);}
	public static void hap(int c, int d) {
		int sum = 0;
		for (int i = c; i <= d; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	

	public static void disp(int e, char f) {
			for(int i=0;i<e;i++) {System.out.print(f);}
	}
	
	
	
//////////////////////////////////////////////////////	
	public static void main(String[] args) {
		
	test1(10);
	test2(1.2);
	hap(3,5);
	disp(7,'*');

	}	
	
/////////////////////////////////////////////////////
}
