package com.company.java007_ex;

public class H0912_2 {
	public static void main(String[] args) {
		
		for(int i=5;i>=1;i--) {System.out.print(i + " ");}
		
		System.out.println();
		
		int j=5;
		while(j>=1) {System.out.print(j + " ");j--;}
		
		System.out.println();
		
		int k=5;
		do{System.out.print(k + " ");k--;}while(k>=1);
		
		System.out.println();
		
		
		
		int[] nums = new int[3];
		int data=10;
		
		for(int i=0;i<nums.length;i++) {nums[i]=data; data+=10;}
		for(int i=0;i<nums.length;i++) {System.out.print( (i==0? "":", ") + nums[i]);}
		
		
		
	}

}
