package com.company.java008_ex;

import java.util.Arrays;

public class MethodEx008 {

	public static void upper(char[] ch) {
		
		for(int i=0; i<ch.length;i++) { System.out.print((char)(ch[i]-32) + " ");} System.out.println();
	} 
	
	
////////////////////////////////////////////////
	public static void main(String[] args) {
		
		
		 char[] ch = {'a','b','c'};
		    upper(ch);     
		    System.out.println("main. 배열값 : "      +  Arrays.toString(ch)          );  // [A,B,C]
		    
		    

		    
////////////////////////////////////////// 
		}	

}
