package com.company.java005_ex;

public class RepeatEx009 {
	public static void main(String[] args) {

		
		int i1, i2, i3, hap1 = 0, hap2 = 0, hap3 = 0;

		for(i1=1; i1<=10; i1++) { if(i1%3==0){hap1 +=i1;}}
		System.out.println(hap1);
		
		i2=1;
		while(i2<=10) {if(i2%3==0){hap2 +=i2;}i2++;}
		System.out.println(hap2);
		
		i3=1; 
		do {if(i3%3==0){hap3 +=i3;}i3++;} while(i3<=10);
		System.out.println(hap3);	
		
		
		
	}

}
