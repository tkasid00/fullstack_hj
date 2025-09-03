package com.company.java003_ex;

import java.util.Scanner;

public class CastingCharEx {
	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);
	char upper = ' ';
	char lower = ' ';
		  
		  
	System.out.print("알파벳 대문자를 입력하세요> ");
	upper = scanner.next().charAt(0);  // next()는 문자 입력, charAt(0)는 첫 번째 문자
	
	lower = (char)(upper+32);
	
	System.out.println("입력하신 대문자 " + upper + "는 소문자 " +lower);
	
	}
}
