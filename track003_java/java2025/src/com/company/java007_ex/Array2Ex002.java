package com.company.java007_ex;

public class Array2Ex002 {
	public static void main(String[] args) {
		
		
		   int[][] arr2={{101,102,103},{201,202,203}};

//		   for(int i=0;i<=2;i++) {System.out.print( arr2[0][i] + "\t");}
//		   for(int i=0;i<=2;i++) {System.out.print( arr2[1][i] + "\t");}
//		   
		   
		   for(int j=0;j<arr2.length;j++)
		   {	for(int i=0;i<=2;i++) {System.out.print( arr2[j][i] + "\t");}	}
	
	}
}
