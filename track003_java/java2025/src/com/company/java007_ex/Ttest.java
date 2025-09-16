package com.company.java007_ex;

public class Ttest {

	public static void main(String[] args) {


//		연습문제2)  array 
//		클래스명 :  Repeat017_2
//		배열을 이용하여 다음의 프로그램을 작성하시오.   
//		1. new 연산자 이용하여 다차원배열만들기
//		2. for + length 이용해서 대입   
//		3. for + length 이용해서 출력 
//			A	B	C
//			B	C	D
		
		char[] []arr =new char[2][3];
		char data='A';
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] +=data++;
				System.out.print(arr[i][j] + " ");
			}System.out.println();data='B';
			
		
		

		}
		
		
		
	}

}
