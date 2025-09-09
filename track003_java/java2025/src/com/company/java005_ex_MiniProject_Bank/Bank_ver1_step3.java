package com.company.java005_ex_MiniProject_Bank;

import java.util.Scanner;

public class Bank_ver1_step3 {
	public static void main(String[] args) {
		
		//변수
		int num1;
		int add = 0;
		Scanner scanner=new Scanner(System.in);
//		String id ="\u0000";
//		String pass ="\u0000";
		String id = null, pass = null;
		double balance = 0;
		
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
				//System.out.println("조회 기능입니다");
				
				//임시 아이디, 비번 입력
				String tempid, temppass;
				
				System.out.print("아이디 입력 : ");
				tempid = scanner.next();
				System.out.print("비밀번호 입력 : ");
				temppass = scanner.next();
				
				if(tempid.equals(id) && temppass.equals(pass) ) {
					System.out.printf("%s \nID : %s \nPASS : %s \n잔액 : %d \n", "==계좌 조회", id, pass, (int)balance);
				}else  {System.out.println("다시 확인해 주세요");}
				
				
			} else if (num1 == 3) {
				//System.out.println("입금 기능입니다");
				
				String tempid, temppass;
				
				System.out.print("아이디 입력 : ");
				tempid = scanner.next();
				System.out.print("비밀번호 입력 : ");
				temppass = scanner.next();
				
				if(tempid.equals(id) && temppass.equals(pass) ) {
					System.out.printf("입금 : ");
					add = scanner.nextInt();
					System.out.println("==입금 완료 \n잔액:" +(int)(balance+=add) );
					
				}else  {System.out.println("다시 확인해 주세요");}
				
			} else if (num1 == 4) {
				//System.out.println("출금 기능입니다");
				
				String tempid, temppass;
				
				System.out.print("아이디 입력 : ");
				tempid = scanner.next();
				System.out.print("비밀번호 입력 : ");
				temppass = scanner.next();
				
				if(tempid.equals(id) && temppass.equals(pass) ) {
					System.out.printf("출금 : ");
					add = scanner.nextInt();
					System.out.println("==출금 완료 \n잔액:" +(int)(balance-=add));
					
				}else  {System.out.println("다시 확인해 주세요");}
				
				
				
			} else if (num1 == 5) {
				//System.out.println("삭제 기능입니다");
				
				String tempid, temppass;
				char yn;
				
				System.out.print("아이디 입력 : ");
				tempid = scanner.next();
				System.out.print("비밀번호 입력 : ");
				temppass = scanner.next();
				
				if(tempid.equals(id) && temppass.equals(pass) ) {
					
					System.out.print("계좌를 삭제하시겠습니까?(Y/N) : ");
					yn = scanner.next().charAt(0);
					if(yn == 'N' || yn == 'n') {} 
					else if (yn == 'Y' || yn == 'y') {id = null; pass = null; balance = 0;}
					else  {System.out.println("다시 확인해 주세요");}
				}else  {System.out.println("다시 확인해 주세요");}
				
				
			} else if (num1 == 9) {
				System.out.println("종료합니다.");break;
			} //if num1
			
			

		}// for
						

	}

}
