package com.company.java005_ex;

import java.util.Scanner;

public class ForEx002 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = 0;
		System.out.print("구구단 몇 단인지 입력하세요> ");
		num1 = scanner.nextInt();
	
		
		for(int i = 1; i <= 9; i++) {System.out.println(num1 + "x" + i + "=" + (num1*i));}

			
	}

}
