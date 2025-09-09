package com.company.java006_ex;

import java.util.Scanner;

public class ForEx006_3 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		// 범위에 걸리지 않는 값으로 설정ㄴ
		int num1 = -1; 
		int num2 = -1;
		char op = '\u0000';
		String re =  " ";
		
		for(;;) { 
					if(!(num1 >=0 && num1<=100)) {						// 0~100 범위가 아니면
						System.out.print("1. 정수를 하나 입력해주세요 >");	// 입력받기
						num1 =  scanner.nextInt();	
						continue;}										//건너뛰기
			
		
						if(!(num2 >=0 && num2<=100)) {
						System.out.print("2. 정수를 하나 입력해주세요 >");
						num2 =  scanner.nextInt();	
						continue;}	
	
						if(!(op=='+'|| op=='-'||op=='*'||op=='/')) {
							System.out.print("3. 연산자를 입력해주세요(+,-,*,/) >");
							op =  scanner.next().charAt(0);
						continue;}break;}	

		
		
		re =  "" + num1 + op + num2 + "="; 
		
		switch(op) {
		case '+' : System.out.println( re += num1+num2); break;
		case '-' : System.out.println( re += num1-num2); break;
		case '*' : System.out.println( re += num1*num2); break;
		case '/' : System.out.println( re += String.format("%.2f", (double)(num1/num2))); break;
		}

		
		
	
	}
		}
