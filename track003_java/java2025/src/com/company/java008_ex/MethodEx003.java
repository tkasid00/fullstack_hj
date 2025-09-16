package com.company.java008_ex;

public class MethodEx003 {
	
	public static void printProfile(String a, int b, String c) {
		System.out.println("=== 사용자 프로필 ===");
		System.out.printf("이름:%s \n나이:%d \n지역:%s \n", a, b ,c);
		System.out.println("===================");}
	
	
	public static void checkAge(int d) {
		if (d>=20) {System.out.println("성인입니다");}
		else {System.out.println("미성년자입니다");}
	}
	
	
	public static void repeatMessage(String e, int f) {
		for(int i=0; i<f; i++) {System.out.println(e);} }
	
	public static void drawBox(int g, char h) {
		for (int i = 0; i < g; i++) {
			for (int j = 0; j < g; j++) {
				System.out.print(h);
			}System.out.println();
		}

	}
	
	
//////////////////////////////////////////////////////

	public static void main(String[] args) {
		
		
	    printProfile("홍길동", 25, "서울");   // 이름, 나이, 지역 출력
	    checkAge(17);                      // 미성년자 여부 판단
	    repeatMessage("안녕하세요!", 3);     // 메시지 반복 출력
	    drawBox(5, '#');                   // 문자로 박스 출력
	}
	

}
