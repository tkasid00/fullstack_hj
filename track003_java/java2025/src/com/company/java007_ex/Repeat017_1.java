package com.company.java007_ex;

public class Repeat017_1 {
	public static void main(String[] args) {
		
		
		
		int[][] arr = new int [2][3];
		int data=101;
		
		for(int i=0; i<arr.length;i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j]+=data++; 
				System.out.print(arr[i][j] + "\t");
			}System.out.println();
		}
		
		
	}

}
