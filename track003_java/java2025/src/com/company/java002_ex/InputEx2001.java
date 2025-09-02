package com.company.java002_ex;

import java.util.Scanner;

public class InputEx2001 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("파이값을 입력하시오> ");
		double d = 3.14;
		
		d = scanner.nextDouble();
		
		System.out.println("파이값은 " + d + "입니다.");
		
		
		
	}

}
