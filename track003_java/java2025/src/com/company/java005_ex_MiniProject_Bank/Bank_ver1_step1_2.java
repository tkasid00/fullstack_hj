package com.company.java005_ex_MiniProject_Bank;

import java.util.Scanner;

public class Bank_ver1_step1_2 {
	public static void main(String[] args) {
		
		//변수
		int num1;
		Scanner scanner=new Scanner(System.in);
		String id, pass;
		double balance;
		
		for (;;) {
			System.out.print(
					"WELCOME! (주)CODEJOHNS BANK\n=======BANK======\n* 1.추가 \n* 2.조회 \n* 3.입금 \n* 4.출금 \n* 5.삭제 \n* 9.종료\n");
			System.out.print("입력>>>");
			num1 = scanner.nextInt();
			
			if (num1 == 1) {
				System.out.println("추가 기능입니다");
				
				System.out.print("아이디 입력 : ");
				id = scanner.next();
				System.out.print("비밀번호 입력 : ");
				pass = scanner.next();
				System.out.print("잔액 입력 : ");
				balance = scanner.nextDouble();
				
			} else if (num1 == 2) {
				System.out.println("조회 기능입니다");
				
				System.out.print("아이디 입력 : ");
				id = scanner.next();
				System.out.print("비밀번호 입력 : ");
				pass = scanner.next();
				
//				if(id==id && pass == pass) {System.out.println("사용자 정보가 일치합니다");}
//				else  {System.out.println("다시 확인해 주세요");}
				
//				System.out.println(id.equals(id)? "사용자 정보가 일치합니다" : "다시 확인해 주세요");
				
				
			} else if (num1 == 3) {
				System.out.println("입금 기능입니다");
			} else if (num1 == 4) {
				System.out.println("출금 기능입니다");
			} else if (num1 == 5) {
				System.out.println("삭제 기능입니다");
			} else if (num1 == 9) {
				System.out.println("종료합니다.");break;
			} //if num1
			
			

		}// for
						

	}

}
