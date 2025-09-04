package com.company.java004_ex;
import java.util.Scanner;

public class IfEx003 {
	public static void main(String[] args) {
		int i;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요> ");
		i = scanner.nextInt();
		
		if(i==1) {System.out.println("one");}
		else if(i==2) {System.out.println("two");}
		else if(i==3) {System.out.println("three");}
		else {System.out.println("1,2,3이 아니다");}
	}

}
