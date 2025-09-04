package com.company.java003_ex;

import java.util.Scanner;

public class Repeat009 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int num1, num2;
		double result;
		
		System.out.print("숫자 입력1> ");
		num1 = scanner.nextInt();
		System.out.print("숫자 입력2> ");
		num2 = scanner.nextInt();
		
		result = (double)num1/num2;
		
		System.out.printf("%d / %d = %.2f\n", num1, num2, result);
		
	}

}
