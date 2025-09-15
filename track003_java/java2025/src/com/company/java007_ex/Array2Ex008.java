package com.company.java007_ex;

import java.util.Arrays;

public class Array2Ex008 {
	public static void main(String[] args) {

		int[][] datas = { { 10, 10, 10, 10 }, { 20, 20, 20, 20 }, { 30, 30, 30, 30 }, }; // 3층 4칸
		int[][] result = new int[datas.length + 1][datas[0].length + 1];

		
		//1. datas 복사
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				result[i][j] = datas[i][j];
			}

		} //for

		//2. 더한 값 계산
		for (int i = 0; i < result.length - 1; i++) {
			for (int j = 0; j < result[i].length - 1; j++) {
				result[i][result.length] += result[i][j];
				result[3][j] += result[i][j];
				result[3][result.length] += result[i][j];
			}
		}//for

		//3. 결과
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}//for

//		result[0][4] += result[0][0];
//		result[0][4] += result[0][1];
//		result[0][4] += result[0][2];
//		result[0][4] += result[0][3];

//		result[3][0] += result[0][0];
//		result[3][0] += result[1][0];
//		result[3][0] += result[2][0];

	}
}
