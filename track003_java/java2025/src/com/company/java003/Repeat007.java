package com.company.java003;

import java.util.Scanner;

public class Repeat007 {
	public static void main(String[] args) {
		int kor, eng, mat, total;
		double avg;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어 점수를 입력하시오. >");
		kor = scanner.nextInt();
		System.out.print("영어 점수를 입력하시오. >");
		eng = scanner.nextInt();
		System.out.print("수학 점수를 입력하시오. >");
		mat = scanner.nextInt();
		
		total = kor + eng + mat;
		avg = total/3.0;
		
		System.out.println("총점: " + total);
		System.out.println("평균: " + avg);
		
				
	}
}
