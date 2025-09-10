package com.company.java005_ex;

public class RepeatEx010_2 {
	public static void main(String[] args) {
		
		
	char ch = '\u0000';

	for(ch='A'; ch<='Z'; ch++) 
		{System.out.print( (ch%5==0? "\n":"") + ch );}
	
	System.out.println();
	
	ch='A';
	while(ch<='Z'){System.out.print( (ch%5==0? "\n":"") + ch ); ch++;}

	System.out.println();
	
	ch='A';
	do {System.out.print( (ch%5==0? "\n":"") + ch ); ch++;} while(ch<='Z');
	
	
}

}
