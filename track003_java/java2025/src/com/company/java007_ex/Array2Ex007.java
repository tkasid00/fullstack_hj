package com.company.java007_ex;

public class Array2Ex007 {
	public static void main(String[] args) {
		

		int[][] arr = new int[4][4];
		int data=1;
		

		for (int ch = 0; ch < arr.length; ch++) {
			for (int kan = 0; kan < arr[ch].length; kan++) {
				arr[ch][kan] = data++;
				
				System.out.print(arr[ch][kan] + "\t");
			}
			System.out.println();
			data = 1;
		}
	}
}
