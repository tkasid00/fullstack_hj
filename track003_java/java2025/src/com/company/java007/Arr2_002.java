package com.company.java007;

public class Arr2_002 {
	public static void main(String[] args) {
		
		int[][] arr = new int[2][3]; //2층 3칸
									// 00 01 02
									// 10 11 12
									// 20 21 22
		int data=1;
//		arr[0][0] = data++; arr[0][1] = data++; arr[0][2] = data++;
//		arr[1][0] = data++; arr[1][1] = data++; arr[1][2] = data++;
		
		
//		for(int kan=0;kan<arr[0].length;kan++) {arr[0][kan] = data++;}
//		for(int kan=0;kan<arr[0].length;kan++) {arr[1][kan] = data++;}
		
		
		for (int ch = 0; ch < arr.length; ch++) {
			for (int kan = 0; kan < arr[ch].length; kan++) {
				arr[ch][kan] = data++;
			}
		}

		for (int ch = 0; ch < arr.length; ch++) {
			for (int kan = 0; kan < arr[ch].length; kan++) {
				System.out.print(arr[ch][kan] + "\t");
			}
			System.out.println();
		}

	}

}
