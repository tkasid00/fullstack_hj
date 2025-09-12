package com.company.java005_ex_MiniProject_Bank;

import java.util.Arrays;
import java.util.Scanner;

public class Bank002_Array02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int num = -1;
		String[] id = new String[3];
		String[] pass = new String[3];
		double[] balance = new double[3];

		while (num != 9) {
			System.out.println(Arrays.toString(id));
			System.out.println(Arrays.toString(pass));
			System.out.println(Arrays.toString(balance));

			System.out.print(
					"_____________________\n (주)CODEJOHNS BANK   \n______*WELCOME*______\n\n* 1.신규 개설 \n* 2.내 계좌 조회 \n* 3.입금 \n* 4.출금 \n* 5.계좌 삭제 \n* 6.등급 안내 \n* 9.종료\n_____________________\n");
			System.out.print("메뉴를 선택해 주세요> ");
			num = scanner.nextInt();
			if (num == 1) {
				// 0번이 빈칸이면 find 0 -> if([0]=null;){find=0;}
				int find = -1;
//							if(id[i]==null) {find=i;}
				for (int i = 0; i < id.length; i++) {
					if (id[i] == null) {
						find = i;
						break;
					}
				} // 자료가 많으면 로딩 발생! 멈춰야함

				System.out.print("ID를 생성해 주세요 : ");
				id[find] = scanner.next();
				System.out.print("비밀번호를 생성해 주세요 : ");
				pass[find] = scanner.next();
				System.out.print("개설 초기 금액을 입금해 주세요 : ");
				balance[find] = scanner.nextDouble();
				System.out.println("축하합니다!\n계좌가 성공적으로 생성되었습니다");

			}

			else if (num == 2 || num == 3 || num == 4 || num == 5 || num == 6) {

				System.out.print("ID : ");
				String tempid = scanner.next();
				System.out.print("비밀번호 : ");
				String temppass = scanner.next();
				int find = -1;

				for (int i = 0; i < id.length; i++) {
					if (tempid.equals(id[i]) && temppass.equals(pass[i])) {
						System.out.println("사용자 정보가 일치합니다");
						find = i;
						break;
					}
					
					

				}

				if (find == -1) {
					System.out.println("ID와 비밀번호를 확인해 주세요");
				}

			}

		}

	}
}
