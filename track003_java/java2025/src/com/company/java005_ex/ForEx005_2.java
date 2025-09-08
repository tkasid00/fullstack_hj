package com.company.java005_ex;

public class ForEx005_2 {
	public static void main(String[] args) {
		
		char ch = '\u0000';
		int cnt = 0;
		
		
		for(ch='a'; ch<='z';ch++) {switch(ch) { case 'a' : case 'e' : case 'i' :  case 'o' : case 'u' : cnt++; break;} }
		
		// 모음 : a, e, i, o, u
		// 스위치로 변경
		
		//switch(ch) { case 'a' : cnt++; case 'e' : cnt++; case 'i' : cnt++; case 'o' : cnt++; case 'u' : cnt++; } 
		
		
		
		System.out.println("소문자 a~z까지 모음의 개수 : "+ cnt);
		
	}
		
}
