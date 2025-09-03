package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx001 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i1, i2;
		double d;
		
		System.out.print("숫자 입력1> ");
		i1 = scanner.nextInt();
		System.out.print("숫자 입력2> ");
		i2 = scanner.nextInt();
		
		d = i1/(double)i2;   //한쪽이 실수면 결과는 실수로 출력됨
		
		System.out.println(i1 + "/" + i2 + "=" + String.format("%.2f", d));
		System.out.printf("%d/%d = %.2f", i1, i2, d);

		
	}

}
