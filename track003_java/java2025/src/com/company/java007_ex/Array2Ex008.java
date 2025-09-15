package com.company.java007_ex;

import java.util.Arrays;

public class Array2Ex008 {
	public static void main(String[] args) {
//		1. 다음의 주어진조건을 이용하여 총점과 평균을 구하시오.
//
//		#1. result 에 datas데이터 복사하기
//		#2. 가로방향누적데이터
//		#3. 세로방향데이터누적
//		#4. 총합
//
//		출력내용:
//		10   10   10   10   40   
//		20   20   20   20   80   
//		30   30   30   30   120   
//		60   60   60   60   240   
//		
		int[][] datas = { { 10, 10, 10, 10 }, { 20, 20, 20, 20 }, { 30, 30, 30, 30 }, }; // 3층 4칸
		int[][] result = new int[datas.length + 1][datas[0].length + 1];

		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				result[i][j] = datas[i][j];
				
				result[0][4] += result[0][j];
				result[3][0] += result[i][0];
				
				System.out.print(result[i][j] + " ");
				}
				System.out.println();
				
				System.out.println(Arrays.deepToString(datas));
				System.out.println(Arrays.deepToString(result));
		

				}

		
			
		

//			result[0][4] += result[0][0];
//			result[0][4] += result[0][1];
//			result[0][4] += result[0][2];
//			result[0][4] += result[0][3];
//			
//			result[3][0] += result[0][0];
//			result[3][0] += result[1][0];
//			result[3][0] += result[2][0];

		
		
	}
}
