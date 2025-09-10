package com.company.java006_ex;

import java.util.Scanner;

public class Repeat0910_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char ch = '\u0000';
		
		System.out.print("알파벳 소문자를 입력하세요 : ");
		ch = scanner.next().charAt(0);
		
		if(ch == 'a') {System.out.println("apple");}
		else if(ch == 'b') {System.out.println("banana");}
		else if(ch == 'c') {System.out.println("coconut");}
		else {System.out.println("a, b, c가 아니다");}
		
		
		
	}

}
