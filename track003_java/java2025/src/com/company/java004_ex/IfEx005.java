package com.company.java004_ex;

import java.util.Scanner;

public class IfEx005 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int i;
			
		//숫자 1개 입력받고 절대값 출력하기 : -1, 1 입력 1출력
		
		System.out.print("숫자를 입력하세요> ");
		i = scanner.nextInt();
		
		if (i>=0) {System.out.println(i);}
		else if (i<0) {System.out.println(i*(-1));}
	

		
		
	}

}
