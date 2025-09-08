package com.company.java005_ex;

public class ForEx005 {
	public static void main(String[] args) {
		
		char ch = '\u0000';
		int cnt = 0;
		
		
		for(ch='a'; ch<='z';ch++) {{if (ch=='a'|| ch=='e' || ch=='i'||ch=='o'||ch=='u') {cnt++;} }}
		

		System.out.println("소문자 a~z까지 모음의 개수 : "+ cnt);
		
		// 모음 : a, e, i, o, u
		// 스위치로 변경
		
		
	}
		
}
