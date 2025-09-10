package com.company.java006;

public class Repeat003_while_Dowhile {

	public static void main(String[] args) {

		// 1. for(반복 횟수 알 때)
		System.out.println("1. for");
		for (int i = 1; i <= 3; i++) {
			System.out.print(i + "\t");
		}

		
		
		System.out.println("");
		// 2. while(반복 횟수 모를 때-게시판) : 조건만 봄
		System.out.println("2. while");
		int i = 1;       // 2-1. 초기문 위로
		while (i <= 3) { // 2-2. 조건문만 봄
			System.out.print(i + "\t");
			i++;         // 2-3.증감문은 맨 끝으로 이동
		} 

		
		System.out.println();
		// 2. do while(무조건 1번은 실행 필요)
		System.out.println("3. do while");
		i = 1;
		do{  //3-2. 일단 실행
			System.out.print(i + "\t");
			i++; 
		} while (i <= 3); //3-3. 조건이 do 괄호 밖 뒤에 위치

	}

}
