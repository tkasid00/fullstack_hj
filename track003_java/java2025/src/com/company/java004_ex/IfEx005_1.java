package com.company.java004_ex;

import java.util.Scanner;

public class IfEx005_1 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		char ch; 
		
		System.out.print("영문자 1개를 입력하세요> ");
		ch = scanner.next().charAt(0);
								
		if(ch>='a' && ch<='z') {System.out.println(ch-=32);} // ch-=32는 자동으로 변경됨
		else if(ch>='A' && ch<='Z') {System.out.println(ch+=32);}
		
		//삼항연산자 변환 (조건? "ㅁ" : "ㅇ")
		
		//System.out.println((ch>='a' && ch<='z')? (char)(ch-32):(char)(ch+32));
		
		ch = ch>='a' && ch<='z'? ch-=32 : ch>='A' && ch<='Z'? ch+=32:'x';
			System.out.println(ch);

	}

}
