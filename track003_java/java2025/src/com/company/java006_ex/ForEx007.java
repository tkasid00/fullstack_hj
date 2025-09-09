package com.company.java006_ex;

import java.util.Scanner;

public class ForEx007 {
	
	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		
		int kor = -1; 
		int eng = -1;
		int mat = -1;
		int total;
		double avg;
		String std, pass, jang, lev;
		
		System.out.print("학번 : ");
		std =  scanner.next();
		
		for(;;) { 
			if(!(kor >= 0 && kor <= 100)) {System.out.print("국어 점수 : ");
										kor = scanner.nextInt(); continue;}
			
			if(!(eng >= 0 && eng <= 100)) {System.out.print("영어 점수 : ");
										eng = scanner.nextInt(); continue;}
			if (!(mat >= 0 && mat <= 100)) {System.out.print("수학 점수 : ");
										mat = scanner.nextInt(); continue;}
																			break;}
			total = kor + eng + mat;
			avg = total/3.0;
			pass = avg<60? "불합격": kor<40? "불합격" : eng<40? "불합격" : mat<40? "불합격":"합격";

//			if(avg>=90) {lev="수";}
//			else if(avg>=80) {lev="우";}
//			else if(avg>=70) {lev="미";}
//			else if(avg>=60) {lev="양";}
//			else {lev="가";}
			
			lev = avg>=90? "수" : avg>=80? "우" : avg>=70? "미" : avg>=60? "양" : "가";

			jang = avg>=90? "장학생":"x";
	
		System.out.println("==============================================================");
		System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t",
								"학번", "국어", "영어", "수학", "총점", "평균", "합격 여부", "레벨", "장학생");
		System.out.println("\n==============================================================");
		System.out.printf("%-5s\t%-5d\t%-5d\t%-5d\t%-5d\t%-5.2f\t%-5s\t%-5s\t%-5s\t", 
								std, kor, eng, mat, total, avg, pass, lev, jang);
		
		
	}

}
