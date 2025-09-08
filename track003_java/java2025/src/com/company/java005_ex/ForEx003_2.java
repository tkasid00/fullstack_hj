package com.company.java005_ex;

public class ForEx003_2 {
	
	public static void main(String[] args) {

		int i, sum = 0;
		String re= " ";
		
		for(i = 1; i <= 10; i++ ) {re += ( (i==1? " ": "+") + i ); sum += i;} 
//		for(i = 1; i <= 10; i++ ) {sum += i;}
		
		
		System.out.println(re + "=" + sum);
		

		
		
		
//		for(i = 1; i <= 10; i++ ) {sum += i;}
//		
//		System.out.println("1부터 10까지의 합> " + sum);
		
		
		//		for(i = 1; i <= 10; i++ ) {System.out.print( (i==1? " ": "+") + i );}
		
		
		
	}
	
}
