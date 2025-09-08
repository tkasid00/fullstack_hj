package com.company.java005_ex;

public class ForEx004 {
	public static void main(String[] args) {
		
		int cnt = 0;
		
		for(int i=1;i<=10;i++) {if ((i%3) == 0) {cnt++;};}
		
		System.out.println("1~10까지 3의 배수 개수 : " + cnt);
		
		
		//if(1%3==0) {cnt++;} 
	}
}
