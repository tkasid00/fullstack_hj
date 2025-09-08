package com.company.java005_ex;

public class ForEx004_2 {

	public static void main(String[] args) {
		
		int i, cnt = 0;
		String re = " ";
		
		
		//for(i=1;i<=10;i++) {if ((i%3) == 0)  {re += (i==3? " " : ",")+ i;} ;    if ((i%3) == 0) {cnt++;};}
		
		for(i=1;i<=10;i++) {if ((i%3) == 0)  {cnt++; re += (i==3? " " : ",")+ i;} ;}
		
		System.out.println("3의 배수 : " + re);
		System.out.println("3의 배수 개수 : " + cnt);
		
		//for(int i=1;i<=10;i++) {if ((i%3) == 0) {cnt++;};}
		
		//for(int i=1;i<=10;i++) {if ((i%3) == 0) {cnt++;};}
		
		//for(i=1;i<=10;i++) {		if ((i%3) == 0) {System.out.print((i==3? " " : ",")+  i);}		;}
		
		
		
	//	System.out.println("3의 배수 : " + );
	//	System.out.println("1~10까지 3의 배수 개수 : " + cnt);
		
		
		
		
		//if(1%3==0) {cnt++;} 
		
//		upgrade)  시간나면 도전!
//		3의배수 : 3,6,9    
//		갯수 : 3개

	}
}