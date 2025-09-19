package com.company.java008_ex;

import java.util.Scanner;

public class Repeat0919 {
	
	public static void dog() {System.out.println("멍멍");}
	
	///////////////////////////////////
	public static void main (String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		for (;;) {
			System.out.print("사칙연산 부호를 입력하세요 : ");
			char ch = scanner.next().charAt(0);
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				break;
			}
		}
		

	char ch1 = '\u0000';
	do{
		System.out.print("사칙연산 부호를 입력하세요 : ");
		ch1 = scanner.next().charAt(0);
		if (ch1 == '+' || ch1 == '-' || ch1 == '*' || ch1 == '/') {
			break;}
		}while(!(ch1 == '+' || ch1 == '-' || ch1 == '*' || ch1 == '/'));
	

	char ch2 = '\u0000';
	while(!(ch2 == '+' || ch2 == '-' || ch2 == '*' || ch2 == '/')){
		System.out.print("사칙연산 부호를 입력하세요 : ");
		ch2 = scanner.next().charAt(0);
		if (ch2 == '+' || ch2 == '-' || ch2 == '*' || ch2 == '/') {
			break;}
	}
	
	
	//while(ch1 != '+' && ch1 != '-' && ch1 != '*' && ch1 != '/'));   <-이렇게도 표현 가능
	
	
			
//		for(int i=0;i<5;i++) {break;}
//		int i=0;
//		while(i<5) {break; i++;}
//		int j=0;
//		do {break; i++;} while(j<5);
		
		
		
		
		int[][] arr = new int[2][3];
		int data = 101;
		

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = data;
				data++;
				
				System.out.print(arr[i][j] + " ");
			} System.out.println();
		}
		
			dog();
		
		
		
	}
//////////////////////////////
}
