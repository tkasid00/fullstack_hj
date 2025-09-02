package com.company.java002_ex;

import java.util.Scanner;

public class InputEx2002 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i;
		int e;
		int m;
		
		System.out.print("국어 점수를 입력하시오 _");
		i = scanner.nextInt();
		System.out.print("영어 점수를 입력하시오 _");
		e = scanner.nextInt();
		System.out.print("수학 점수를 입력하시오 _");
		m = scanner.nextInt();
		
		int total = i + e + m;
		int average = (i + e + m)/3;
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + average);
		
		
		
		
		
	}

}
