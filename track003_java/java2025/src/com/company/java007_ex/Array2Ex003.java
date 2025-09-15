package com.company.java007_ex;

public class Array2Ex003 {
	public static void main(String[] args) {
		
//		1. new 연산자 이용하여 다차원배열만들기
//		2. for + length 이용해서 대입   
//		3. for + length 이용해서 출력 
//		   101       102       103
//		   104    105    106
		
		int[][] arr = new int[2][3];
		
		int data=101;
		
		//for(int kan=0; kan<=5; kan++) {arr[0][kan]=data++; System.out.print(arr[0][kan] + "\t");}
		
		for(int ch=0;ch<arr.length;ch++)
		
		{		for(int kan=0; kan<arr[ch].length; kan++) {arr[ch][kan]=data++; System.out.print(arr[ch][kan] + "\t");} 
		System.out.println();}
		
		

	}

}
