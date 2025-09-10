package com.company.java006_ex;

import java.util.Scanner;

public class Repeat0910_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char ch = '\u0000';
		
		System.out.print("알파벳 소문자를 입력하세요 : ");
		ch = scanner.next().charAt(0);
		
		switch(ch) {
					case 'a' : System.out.println("apple"); break;
					case 'b' : System.out.println("bnana"); break;
					case 'c' : System.out.println("coconut"); break;
					default : System.out.println("a, b, c가 아니다"); break;
		}

	
	
	}
}
	