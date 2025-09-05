package com.company.java004_ex;

import java.util.Scanner;

public class IfEx007_1 {
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num1, num2;
		String result;
		char ch1;
		
		System.out.print("정수를 하나 입력해 주세요> ");
		num1 = scanner.nextInt();
		System.out.print("정수를 하나 입력해 주세요> ");
		num2 = scanner.nextInt();
		System.out.print("연산자를 입력해 주세요(+,-,*,/)> ");
		ch1 = scanner.next().charAt(0);
		
		result = "" + num1 + ch1 + num2 + "=";
		
		if(ch1=='+') {result += (num1+num2);}
		else if(ch1=='-') {result += (num1-num2);}
		else if(ch1=='*') {result += (num1*num2);}
		else if(ch1=='/') {result += String.format("%.2f", (double)num1/num2);}

		
//		if(ch1=='+') {System.out.printf("%d%s%d=%d", num1, ch1, num2, (num1+num2));}
//		else if(ch1=='-') {System.out.printf("%d%s%d=%d", num1, ch1, num2, (num1-num2));}
//		else if(ch1=='*') {System.out.printf("%d%s%d=%d", num1, ch1, num2, (num1*num2));}
//		else if(ch1=='/') {System.out.printf("%d%s%d=%d", num1, ch1, num2, (num1/num2));}
		
		System.out.println(result);
		
		

	
		
	}

}