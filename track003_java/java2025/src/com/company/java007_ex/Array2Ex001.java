package com.company.java007_ex;

public class Array2Ex001 {
	public static void main(String[] args) {
		
		   int[][] arr2={{100,200,300},{400,500,600}};
		   
//		   for(int i=0;i<=2;i++) {System.out.print( arr2[0][i] + " ");}
//		   for(int i=0;i<=2;i++) {System.out.print( arr2[1][i] + " ");}
//		   
		   
		   for(int j=0;j<arr2.length;j++)
	{	for(int i=0;i<arr2[j].length;i++) {System.out.print( arr2[j][i] + " ");} 	}
		
		
	
	}

}
