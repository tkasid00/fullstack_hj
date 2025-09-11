package com.company.java006_ex;

import java.util.Scanner;

public class Re0911 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		char ch = '\u0000';
		
		System.out.print("소문자를 하나 입력하세요 : ");
		ch =  scanner.next().charAt(0);
		
		if(ch == 'x') {System.out.println("x-ray");}
		else if(ch == 'y') {System.out.println("yogurt");}
		else if(ch == 'z') {System.out.println("zebra");}
		else {System.out.println("x, y, z가 아닙니다");}
		
		switch(ch) {
		case 'x' : System.out.println("x-ray"); break;
		case 'y' : System.out.println("yogurt"); break;
		case 'z' : System.out.println("zebra"); break;
		default : System.out.println("x, y, z가 아닙니다"); break;
		}
		
		int i;
		 for (;;) {System.err.print("숫자를 입력하세요(7 입력 시 종료) : ");
		 				i = scanner.nextInt();
		 			if(i==7) {System.out.println("종료합니다");break;}
		 
		 }
		
		
		
	}

}
