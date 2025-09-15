package com.company.java007;

import java.util.Arrays;

public class Arr2_001 {
	public static void main(String[] args) {
		
		int[][] arr = { {1,2,3} ,//00 01 02
						{4,5,6}  // 10 11 12				
					  };
		 
		System.out.println(arr);   //[[I@28a418fc 주소 출력
		System.out.println(Arrays.toString(arr));  //[[I@5305068a, [I@1f32e575]
		System.out.println(Arrays.deepToString(arr));  //[[1, 2, 3], [4, 5, 6]]
		
		
		//ver-1 눈에 보이는 대로
		
		System.out.print(arr[0][0] + "\t"); 		System.out.print(arr[0][1] + "\t");		System.out.print(arr[0][2] + "\t"); System.out.println();
		System.out.print(arr[1][0] + "\t"); 		System.out.print(arr[1][1] + "\t");		System.out.print(arr[1][2] + "\t"); System.out.println();
		
		//ver-2 칸 정리
		for(int kan=0; kan<=2;kan++) {System.out.print(arr[0][kan] + "\t"); } System.out.println();
		for(int kan=0; kan<=2;kan++) {System.out.print(arr[1][kan] + "\t"); } System.out.println();
		
		
		//ver-3 층 정리
		
		for(int ch = 0; ch<=1; ch++){
		{for(int kan=0; kan<=2;kan++) {System.out.print(arr[0][kan] + "\t"); } }
		}
		
		//ver-3 층 정리
		for(int ch = 0; ch<arr.length; ch++){ //아파트.층수
									//층의 칸수
					{for(int kan=0; kan<arr[ch].length;kan++) 
						{System.out.print(arr[0][kan] + "\t"); } }
		}
		
		
	}//end main

}// end class
