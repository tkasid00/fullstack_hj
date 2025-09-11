package com.company.java006_ex;

public class ArrayEx005 {
	public static void main(String[] args) {
		
		int i = 0;
		int cnt1 = 0; 
		int cnt2 = 0;
		char[] ch = { 'B', 'a', 'n', 'a', 'n', 'a' };
		
		
		for(i=0;i<ch.length;i++) {
		
		if(ch[i] >= 'a' && ch[i] <='z' ) {cnt1++;}
		else if(ch[i] >= 'A' && ch[i] <='Z' ) {cnt2++;}
		}
		
		System.out.print("대문자의 개수 : " + cnt2 + "\n소문자의 개수 : " + cnt1);
		
		
  }
}

