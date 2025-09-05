package com.company.java004_ex;

import java.util.Scanner;

public class IfEx006 {
	public static void main(String[] args) {
		
		int num1, num2, num3;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요(1)>");
		num1 = scanner.nextInt();
		System.out.print("숫자를 입력하세요(2)>");
		num2 = scanner.nextInt();
		System.out.print("숫자를 입력하세요(3)>");
		num3 = scanner.nextInt();
		
//		if(num1>num2 && num1>num3) {System.out.printf("%d, %d, %d 중의 최대값은 : %d", num1, num2, num3, num1);}
//		else if(num2>num1 && num2>num3) {System.out.printf("%d, %d, %d 중의 최대값은 : %d", num1, num2, num3, num2);}
//		else {System.out.printf("%d, %d, %d 중의 최대값은 : %d", num1, num2, num3, num3);}
		
		
		System.out.printf("%d, %d, %d 중의 최대값은 : %d", num1, num2, num3, 
				num1>num2 && num1>num3? num1:num2>num1 && num2>num3? num2:num3);
		
		
	}
}
