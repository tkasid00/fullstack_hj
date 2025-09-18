package com.company.java008_ex;

import java.util.Arrays;

public class MethodEx008_2 {
	
	public static void lower(char[]letters){ 
		
		for(int i=0;i<letters.length;i++) {
		if(letters[i]>='A' && letters[i]<='Z') {letters[i] +=32;} }
	}
	
	
	/////////////////////////////////////
	public static void main(String[] args) {
		char [] letters = {'A', 'B', 'C', '1', '@'};
		lower(letters);
		//public static void lower(char[]letters){ }
		
		/*	[heap]									[stack]
		 * 										 <- 4) lower(1000번지) 		7번째줄 발생
		 *  2) 1000번지{'A', 'B', 'C', '1', '@'}  <- 3) letters[1000번지]			6번째줄에서 발생
		 *  
		 * 											1)main : 먼저 로딩됨
		 * 
		 * 
		 * */
		System.out.println(Arrays.toString(letters));
	}
	////////////////////////////////
}
