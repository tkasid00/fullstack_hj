package com.company.java008_ex;

public class Repeat018 {
	
	public static void dog(){System.out.println("멍멍");}
	public static void disp(int a, char b) { for(int i=0;i<a;i++) {System.out.print(b);} System.out.println();}
	public static char stdAvg(int c) {return c>=90? 'A' :c>=80? 'B' : c>=70? 'C' : 'D';  }
	
	
	//////////////////////////////////////
	public static void main(String[] args) {
		
		
        System.out.println("🐶 강아지가 등장합니다!");
        dog();                      // 멍멍 출력

        System.out.println("\n🎯 강아지가 시험을 봤습니다. 점수를 공개합니다!");
        disp(7, '*');              // ******* 출력

        System.out.println("\n📊 평가 결과는?");
        System.out.println("당신의 평균은? " + stdAvg(88));  // B 출력
      // 90점이상이면 A ,  80점이상이면 B ,  70점이상이면 C , 아니라면  D

	}
	////////////////////////////////////

}
