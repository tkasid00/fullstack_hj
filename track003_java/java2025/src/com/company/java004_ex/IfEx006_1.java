package com.company.java004_ex;

import java.util.Scanner;

public class IfEx006_1 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num1;
		
		System.out.print("숫자 한 개를 입력하세요> ");
		num1 = scanner.nextInt();
		
		System.out.println(num1%2==0? "남자" : "여자");
		
//		num1 = (%2==0? "남자" : "여자";)
//		System.out.println(num1);
		
//		if(num1%2==0) {System.out.println("남자");}
//		else{System.out.println("여자");}
	}
}
