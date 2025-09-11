package com.company.java006_ex;

import java.util.Scanner;

public class ArrayExUpgrade1 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int i =0;
		int cnt = 0;
		String str = null;
		char[] answers = new char[5];
		char[] correct = {'A', 'C', 'B', 'A', 'A'};
		
		System.out.print( "정답을 입력하세요 : ");
		
		
		
		
		for(i=0;i<answers.length;i++) {
			if(answers[i] == correct[i]) {str = "정답";}
			 else if(!(answers[i] == correct[i])) {str = "오답";}
			
		}
			
		System.out.println(answers[i]);
		
		if(str=="정답") {cnt++;}
		
		System.out.println("총 맞은 개수 : " + cnt);
		
		
//		문제 설명
//		배열명: answers → 사용자의 답안: 'A', 'C', 'B', 'D', 'A'
//		배열명: correct  → 정답: 'A', 'C', 'B', 'A', 'A'
//		두 배열을 비교하여 맞은 개수를 출력하세요.
//
//		🧪 출력 예시
//		정답을 입력하시오. >      ACBAA   (문자열로입력받기)          'A', 'C', 'B', 'A', 'A'
//		1번: 정답  
//		2번: 정답  
//		3번: 정답  
//		4번: 오답  
//		5번: 정답  
//		총 맞은 개수: 4개
		
	}

}
