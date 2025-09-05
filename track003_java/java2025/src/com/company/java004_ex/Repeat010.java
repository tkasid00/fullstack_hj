package com.company.java004_ex;

import java.util.Scanner;

public class Repeat010 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1;
		
		System.out.print("숫자 한 개를 입력하세요> ");
		num1 = scanner.nextInt();
		
		if(num1==1) {System.out.println("one");}
		else if(num1==2) {System.out.println("two");}
		else if(num1==3) {System.out.println("three");}
		else {System.out.println("1, 2,3이 아니다.");}
			
	}

}
