package com.company.java003;

import java.util.Scanner;

public class Operator001 {
	public static void main(String[] args) {
		
		//먼저() 값(+,-,*,/,%,++,--) 비교(>,<) 조건(&,||,?:) 대입(=)
		
		//1. 값
		int a = 10, b = 3;
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b); //몫 3
		System.out.println(a%b); //나머지 1
		
		
		//Q1. 나머지 연산자 - 짝수? 홀수?
		//	0%2 1%2 2%2 3%2
		System.out.println(0%2 + "\t" + 1%2 + "\t" + 2%2 + "\t" + 3%2); //0 1 0 1
		
		//Q2. 3의 배수?
		// 	3으로 나눴을 때 0/ 나머지는 0 1 2
		System.out.println(0%3 + "\t" + 1%3 + "\t" + 2%3 + "\t" + 3%3 + "\t" + 4%3); //0 1 2 0 1 2
		
		
		// 2. 비교(==, !=, <, >, <=, >=)
		System.out.println(10>3); //true
		System.out.println(10==3);
		
		//Q1. a가 짝수니?
		System.out.println(a%2==0);
		
		//Q1. b가 3의 배수니?
		System.out.println(b%3==0);
		
		
		//3. &&(모든 조건 만족 시) ||(여러 조건 중 하나라도 만족하면 true)
		System.out.println(true & true); //true
		System.out.println(true && true); //1번 조건과 && 2번 조건 만족 시 true 
		System.out.println(false & true); // & 처음에 false여도 뒤의 조건까지 읽음
		System.out.println(false && true); // Dead code 
		
		System.out.println(true | true); // true
		System.out.println(true || true); // Dead code (앞에서 이미 만족, 뒤를 읽을 필요가 없음)
		System.out.println(false | true); // true
		System.out.println(false || true); // true
		
		//Q1. a가 2의 배수이면서 5의 배수라면 true/false
		System.out.println(a%2==0 && a%5==0);
		
		//Q1. a가 2의 배수거나 3의 배수라면 true/false
		System.out.println(a%2==0 || a%3==0);
		
		
		//4. 삼항연산자 (조건)? 참 : 거짓
		System.out.println(a==10? "10이다" : "10이 아니다");
		
		//Q3. 숫자를 입력받아 양수, 음수, 0
//		Scanner scanner = new Scanner(System.in);
//		int q3 = scanner.nextInt();
//		String result = q3>0? "양수":q3<0? "음수" : "0";		
		
		
		//5. 대입연산자
		a=10; b=3;
		System.out.println("1: " + (a+=b));  //1.a+b 2.a=13 
		System.out.println("2: " + (a-=b));  //1.a-b 2.a=10 
		
		//6. 단항
		int a1=1, b1=1, c1=1, d1=1;
		System.out.println(++a1); // 증가한 다음 a 출력 > 1 
		System.out.println(a1); // 앞줄에서 a는 2가 됐으니까 > 2
		
		System.out.println(b1++); // bl 먼저 출력한 다음 증가> 1 
		System.out.println(b1); // 앞줄에서 증가를 했으니까 > 2
		
		System.out.println(--c1); // 감소 후 출력 > 0
		System.out.println(c1); // 앞에서 감소 > 0
		
		System.out.println(d1--); //출력하고 감소 > 1
		System.out.println(d1); //앞에서 감소 후 출력 > 0
				
	}
}
