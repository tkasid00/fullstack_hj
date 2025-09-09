package com.company.java006_ex;

import java.util.Scanner;

public class ForEx006_2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num1, num2 = 0;
		char op = '\u0000';
		String  re ;
		
		for(;;) {

			System.out.print("1. 정수를 하나 입력해주세요 >");
			num1 = scanner.nextInt();
			if (num1 >= 0 && num1 <= 100) {
				System.out.print("2. 정수를 하나 입력해주세요 >");
				num2 = scanner.nextInt();
				if (num1 >= 0 && num1 <= 100) {
					System.out.print("3. 연산자를 입력해주세요(+,-,*,/) >");
					op = scanner.next().charAt(0);
					if (op == '+' || op == '-' || op == '*' || op == '/') {
						break;
					}
					
				}
				
			}
			
		}

		re =  "" + num1 + op + num2 + "=";
		
		switch(op) {
		case '+' : System.out.println( re += num1+num2); break;
		case '-' : System.out.println( re += num1-num2); break;
		case '*' : System.out.println( re += num1*num2); break;
		case '/' : System.out.println( re += String.format("%.2f", (double)(num1/num2))); break;
		}

		
		
	}
	}
