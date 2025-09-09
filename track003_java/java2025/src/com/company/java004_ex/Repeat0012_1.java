package com.company.java004_ex;

import java.util.Scanner;

public class Repeat0012_1 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int i = 0;
		
		System.out.print("숫자를 하나 입력하세요 > ");
		i = scanner.nextInt();
		
		if(i == 1) {System.out.println("one");}		
		else if(i == 2) {System.out.println("two");}		
		else if(i == 3) {System.out.println("three");}		
		else {System.out.println("1,2,3이 아니다");}		
		
	}

}
