package com.company.java005_ex;

public class RepeatEx010 {
	public static void main(String[] args) {

		char ch = '\u0000';
		
		for(ch='A'; ch<='Z'; ch++) 
			{System.out.print((ch == 'F'? "\n" :ch == 'K'? "\n": ch == 'P'? "\n":ch == 'U'? "\n":ch == 'Z'? "\n":"") + ch);}
		
		System.out.println();
		
		ch = 'A';
		while(ch<='Z'){System.out.print((ch == 'F'? "\n" :ch == 'K'? "\n": ch == 'P'? "\n":ch == 'U'? "\n":ch == 'Z'? "\n":"") + ch); ch++;}
		
		
		System.out.println();
	
		
		ch = 'A';
		do{System.out.print((ch == 'F'? "\n" :ch == 'K'? "\n": ch == 'P'? "\n":ch == 'U'? "\n":ch == 'Z'? "\n":"") + ch); ch++;} while(ch<='Z');
			

		
		
		
	}

}
