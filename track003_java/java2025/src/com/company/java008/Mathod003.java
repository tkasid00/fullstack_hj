package com.company.java008;

import java.util.Random;

public class Mathod003 {
	
	
	public static String sign() {
		return "전설의_갤럭시_소드를_든_광산_중독자_용감한_농부⛏";
		//System.out.println("unreachable code");} 리턴 이후 수행x
				}
	public static String intro(String name, int level){
		return " ["  +  name +   "]님은 레벨"  +  "["  +  level  +  "]";
	}
	

	
	
/////////////////////////////////////////////////////////	
	public static void main(String[] args) {
		
		//public static 리턴값 메서드명(파라미터){}
		// 1. 당신의 이름은? 전설의_갤럭시_소드를_든_광산_중독자_폭탄마_농부
		System.out.println("1. 당신의 이름은? "+ sign());
		
		//2. 이름, 직업, 레벨을 주면 위에서 소개 문장
		//[홍길동]님은 레벨[9]
		System.out.println("2. 당신 설명? " + intro(sign(), 9));
		
		//3. 두 개의 숫자를 넣어주면 나누기 처리 9->4.5
		System.out.println("3. 반타작 저주 : " + spell(9));
		
		//4. 오늘의 운세 1~100
		System.out.println("4. 운세 : " + luck());

	}
///////////////////////////////////////////////////////
///
	public static double spell(int level) {return level/2.0;}
	
	public static int luck(){
		
		Random rand = new Random();
		int result = rand.nextInt(100)+1; //0~100보다 작은 숫자
		
		return result;}
}
