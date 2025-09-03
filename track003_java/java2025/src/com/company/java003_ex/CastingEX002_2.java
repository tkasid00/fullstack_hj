package com.company.java003_ex;

import java.util.Scanner;

public class CastingEX002_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		
		int w1, e1, s1, w2, e2, s2, total;
		double avg, lev;
		
		
		System.out.print("-하루 걸음 수 : ");
		w1 = scanner.nextInt();
		System.out.print("-운동 시간 : ");
		e1 = scanner.nextInt();
		System.out.print("-수면 시간 : ");
		s1 = scanner.nextInt();
		
		//점수
		w2 = w1/(int)1000;
		e2 = e1/(int)10;
		s2 = s1*2;
		
		//총점과 평균
		total = w2+e2+s2;
		avg = total/3.0;
		lev = (int)avg/2;
		
		
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":: HEALTH TRACKER ::");
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\n", "걸음수", "운동시간", "수면시간", "총점", "평균", "건강레벨");
		System.out.printf("%-5d\t%-5d\t%-5d\t%-5d\t%-5s\t%-5d\n", w1, e1, s1, total, String.format("%.2f", avg), (int)lev);
		
	}
}
