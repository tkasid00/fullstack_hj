package com.company.java004_ex;

import java.util.Scanner;

public class IfEx008 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int kor, eng, mat, total;
		double avg;
		String pass = "불합격", str1="x", lev, ch1;
		
		System.out.print("학번을 입력하세요> ");
		ch1 = scanner.next();
		System.out.print("국어 점수를 입력하세요> ");
		kor = scanner.nextInt();
		System.out.print("수학 점수를 입력하세요> ");
		mat = scanner.nextInt();
		System.out.print("영어 점수를 입력하세요> ");
		eng = scanner.nextInt();
		
		
		total = kor + mat + eng;
		avg = total/3.0;
		
		if(avg>=60 && (kor>=40 && (mat>=40 && eng>=40))){pass="합격";}

		if(avg>=95) {str1="장학생";}
		

		if(avg>=90) {lev="수";}
		else if(avg>=80) {lev="우";}
		else if(avg>=70) {lev="미";}
		else if(avg>=60) {lev="양";}
		else {lev="가";}
		
		
		System.out.println("======================================================================== ");
		System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t", 
							"학번", "국어", "수학", "영어", "총점", "평균", "합격여부", "레벨", "장학생");
		System.out.println("\n======================================================================== ");
		
		System.out.printf("%-5s\t%-5d\t%-5d\t%-5d\t%-5d\t%-5.2f\t%-5s\t%-5s\t%-5s\t",
							ch1, kor, mat, eng, total, avg, pass, lev, str1);
	}
}
