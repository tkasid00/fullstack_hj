package com.company.java007_ex;

public class Array2_upgrade3 {
	public static void main(String[] args) {

		int[][] datas = {
		    { 15, 22, 8, 19 },
		    { 33, 5, 17, 11 },
		    { 9, 27, 14, 6 }
		};  // 3층 4칸

		int[][] result = new int[datas.length + 1][datas[0].length + 1];
		
		for(int i =0; i<datas.length; i++) {
			for(int j=0; j< datas.length;j++) {
				result[i][j] = datas[i][j];
			}
		}
		
		
	//	result[0][4] = result[0][1]~[0][4] 중에서 제일 큰 값
		//비교를어케하지 
		result[0][1] result[0][2] result[0][3] result[0][4]
				
					
				

				
				
				
				
		for(int i =0; i<result.length-1; i++) {
			for(int j=0; j< result.length-1;j++) {
				result[][]
			}
		}
		
		
//		2. 구현 조건
//		result 배열에 datas 데이터를 복사한다.
//		각 행의 최댓값을 해당 행의 마지막 열에 저장한다.
//		각 열의 최댓값을 해당 열의 마지막 행에 저장한다.
//
//		전체 최댓값을 마지막 행과 마지막 열의 교차점에 저장한다.
//
//		✅ 출력 예시
//		코드
//		15  22  8   19  22  
//		33  5   17  11  33  
//		9   27  14  6    27  
//		33  27  17  19  33

		
		
		
	}

}
