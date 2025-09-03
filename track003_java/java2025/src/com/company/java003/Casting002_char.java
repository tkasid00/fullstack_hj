package com.company.java003;

public class Casting002_char {
 public static void main(String[] args) {
	 //#1. 문자 초기화
	 // 문자는 저장(숫자) - 출력(문자)
	 char ch1 =' '; //공백이라도 있어야 오류 방지 가능.
	 char ch2 = '\u0000'; //정석
	 
	 System.out.println("step1 : " + ch1 + "\t" + ch2);
	 System.out.println("step2 : " + (int)ch1 + "\t" + (int)ch2);
	 
	 //#2. 문자의 연산
	 
	 char c = 'A';
	 System.out.println("step3 : " + c + "\t" +(int)c);
	 System.out.println("step4 : " + (c+1)); //+ 기호로 연결된 경우 동등한 취급. 1이 숫자이므로 c도 숫자가 된다.
	 
	 //2-1)	'A'+1
	 //2-2) char(65|2byte) + int(1|4byte) = int(66|4byte)
	 
	 System.out.println("step5 : " + (char)(c+1)); //문자열 B로 되돌리는 방법
	 
	 
	 //Q1. 대문자 'A'를 소문자 'a'로 변환시키기
	 System.out.println("hint : " + 'A' + "\t" + (int)'A'); // A 65
	 System.out.println("hint : " + 'a' + "\t" + (int)'a'); // a 97
	 
	 System.out.println((char)('A'+32));
	 
	 char q1 = 'A';
	 char a1 = (char)(q1+32);
	 System.out.println(q1 + "을 소문자로 변환시키려면 +32 : " + a1);
			 
	 
	 //#3. 문자열
	 // 자료형의 분류는 기본형(값) - 참조형(주소)로 나뉨
	 String str1 = "abc";
	 String str2 = "abc";
	 String str3 = new String("abc");
	 
	 System.out.println(System.identityHashCode(str1) ); //주소값 표현
	 System.out.println(System.identityHashCode(str2) ); //한 매서드 안에서 같은 문자열을 쓰면 같은 주소 취급
	 System.out.println(System.identityHashCode(str3) ); 
	 
	 System.out.println(str1 == str3); //주소값 비교 -> false
	 System.out.println(str1.equals(str3)); // 문자열 비교 -> true
 }
}
