package com.company.java005_ex;

public class ForEx008 {
	public static void main(String[] args) {
		
		int i;
		
//		1.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  1 2 3 4 5		
		
		for(i=1;i<=5;i++) {System.out.print(i + "\t");}
		System.out.println();
		
		i=1;
		while(i<=5) {System.out.print(i + "\t"); i++;}
		System.out.println();
		
		i=1;
		do {System.out.print(i + "\t"); i++;} while(i<=5);
		System.out.println();
		
//		2.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  5 4 3 2 1
		
		for(i=5; i>=1; i--) {System.out.print(i + "\t");}
		System.out.println();
		
		i=5;
		while(i>=1) {System.out.print(i + "\t"); i--;}
		System.out.println();
		
		i=5;
		do {System.out.print(i + "\t"); i--;} while(i>=1);
		System.out.println();
		
		
//		3.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  JAVA1   JAVA2  JAVA3
		
		for(i=1; i<=3;i++) {System.out.print("Java" + i + "\t");}
		System.out.println();
		
		i=1;
		while(i<=3) {System.out.print("Java" + i + "\t"); i++;}
		System.out.println();
		
		i=1;
		do {System.out.print("Java" + i + "\t"); i++;} while(i<=3);
		System.out.println();
		
		
	}

}
