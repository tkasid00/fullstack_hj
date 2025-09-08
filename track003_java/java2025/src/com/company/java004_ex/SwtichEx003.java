package com.company.java004_ex;

import java.util.Scanner;

public class SwtichEx003 {
		public static void main(String[] args) {
			Scanner scanner =  new Scanner(System.in);
			
			int num1, num2;
			char op;
			String re = " ";
			
			System.out.print("1. 정수를 하나 입력해 주세요 > ");
			num1 = scanner.nextInt();
			System.out.print("2. 정수를 하나 입력해 주세요 > ");
			num2 = scanner.nextInt();
			System.out.print("3. 연산자를 입력해 주세요 > ");
			op = scanner.next().charAt(0);
			
			re = " " + num1 + op + num2 + "=";
			
			switch(op) { case '+' : System.out.println(re += (num1+num2)); break;
						case '-' : System.out.println(re += (num1-num2)); break;
						case '*' : System.out.println(re += (num1*num2)); break;
						case '/' : System.out.println(re += String.format("%.2f", (double)(num1/num2))); break;}
			
			
		}
}
