package com.company.java006_ex;

import java.util.Scanner;

public class Repeat0910_3 {
	public static void main(String[] args) {

		int i = 0;
		Scanner scanner = new Scanner(System.in);

		for (;;) {
			System.out.print("1을 입력해 주세요 : ");
			i = scanner.nextInt();
			if (i == 1) {
				System.out.println("종료합니다");
				break;
			}
		}

	}

}
