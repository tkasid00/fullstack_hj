package com.company.java005;

import java.util.Scanner;

public class Repeat002_Ifor2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		
		//1. 무한반복은 for(;;){} ->시작x종료x패턴x (break로 나갈 조건 만들어야됨)
		
		for(;;) {	System.out.println("숫자 1을 입력하세요 > ");
			int a = scanner.nextInt();
			if(a==1) {break;}	}
		
		// for - break : 중단하고 나가기 1	2
		for(int i =1; i<=10; i++) {if (i==3) {break;}
					System.out.print(i + "\t");}
		
		
		System.out.println();
		
		// for - continue : 해당 조건 건너뛰기 1	2	4	5	6	7	8	9	10	
		for(int i =1; i<=10; i++) {if (i==3) {continue;}
		System.out.print(i + "\t");}
		
		
		
		
		
		
		
		
	}

}
