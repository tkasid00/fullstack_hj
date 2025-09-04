package com.company.java004_ex;

import java.util.Scanner;

public class IfEx001 {
	public static void main(String[] args) {
		
		int avg;  String result="불합격";
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("평균을 입력하세요> ");
		avg = scanner.nextInt();
		
		if(avg >= 60) {result="합격";}
		
		System.out.println(result);
		
		//삼항연산자
		System.out.println(avg >=60? "합격" : "불합격");
		
	}

}
