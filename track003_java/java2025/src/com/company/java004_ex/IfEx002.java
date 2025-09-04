package com.company.java004_ex;

import java.util.Scanner;

public class IfEx002 {
	public static void main(String[] args) {
		
		int i;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요> ");
		i = scanner.nextInt();
		
		if (i>0) {System.out.println("양수");}
		else if (i<0) {System.out.println("음수");}
		else if (i==0) {System.out.println("zero");}
		
	}

}
