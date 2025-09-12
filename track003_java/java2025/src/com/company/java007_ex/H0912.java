package com.company.java007_ex;

import java.util.Scanner;

public class H0912 {
	public static void main(String[] args) {
		
		Scanner scanner =  new Scanner(System.in);
		char ch = '\u0000';
		
		System.out.print("알파벳 소문자를 입력하세요 > ");
		ch = scanner.next().charAt(0);
		
		if(ch=='m') {System.out.println("mango");}
		else if(ch=='n') {System.out.println("noodle");}
		else if(ch=='0') {System.out.println("orange");}
		else {System.out.println("m,n,o가 아닙니다");}
		
		System.out.print("숫자를 입력하세요 > ");
		int i = scanner.nextInt();
		
		
		switch(i) {
		case 1 : System.out.println("mango"); break;
		case 2 : System.out.println("noodle");break;
		case 3 : System.out.println("orange");break;
		default : System.out.println("m,n,o가 아닙니다");break;
		}
		
		
		
	}

}
