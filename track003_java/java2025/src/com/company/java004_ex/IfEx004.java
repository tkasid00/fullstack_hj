package com.company.java004_ex;

import java.util.Scanner;

public class IfEx004 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		char ch = '\u0000';
		
		System.out.print("영문자를 입력하세요> ");
		ch = scanner.next().charAt(0);
		
		if(ch>='A' && ch<='Z') {System.out.println("대문자");}
		else if(ch>='a'  &&  ch<='z') {System.out.println("소문자");} // 숫자 92, 122로 표현 가능
		else {System.out.println("영문자가 아닙니다.");}
		
		
		
		
	}

}
