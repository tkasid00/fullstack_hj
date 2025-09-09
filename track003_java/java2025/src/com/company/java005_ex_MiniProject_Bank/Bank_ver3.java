package com.company.java005_ex_MiniProject_Bank;

import java.util.Scanner;

public class Bank_ver3 {
	
	public static void main(String[] args) {


				int num1 = 0;
				int add = 0;
				String id = null, pass = null, tempid = null, temppass = null;
				double balance = 0;
				char yn = '\u0000';
				Scanner scanner=new Scanner(System.in);
				
				
				for (;;) {
					System.out.print(
							"WELCOME! (주)CODEJOHNS BANK\n=======BANK======\n* 1.추가 \n* 2.조회 \n* 3.입금 \n* 4.출금 \n* 5.삭제 \n* 9.종료\n");
					System.out.print("입력>>>");
					num1 = scanner.nextInt();
					
		 			if (num1 == 9) {
						System.out.println("종료합니다.");break;

					} else if (num1 == 1) {
						System.out.print("아이디 입력 : ");
						id = scanner.next();
						System.out.print("비밀번호 입력 : ");
						pass = scanner.next();
						System.out.print("잔액 입력 : ");
						balance = scanner.nextDouble();
						
					} else if (num1 == 2 || num1 == 3 ||num1 == 4||num1 == 5 ) {

						System.out.print("아이디 입력 : ");
						tempid = scanner.next();
						System.out.print("비밀번호 입력 : ");
						temppass = scanner.next();
						
						
						if(!(tempid.equals(id) && temppass.equals(pass)) ){
							System.out.println("ID와 비밀번호를 확인해 주세요");
							continue; 
						}

						if(num1 == 2){
							System.out.printf("%s \nID : %s \nPASS : %s \n잔액 : %d \n", "==계좌 조회", id, pass, (int)balance);
						}else if(num1 == 3 ){
							System.out.printf("입금 : ");
							add = scanner.nextInt();
							System.out.println("==입금 완료 \n잔액:" +(int)(balance+=add) );
						
						}else if(num1 == 4 ){
							System.out.printf("출금 : ");
							add = scanner.nextInt();
							System.out.println(add>balance? "출금할 수 없습니다" :  "==출금 완료 \n잔액:" +(int)(balance-=add));
							
						}else if(num1 == 5){
							System.out.print("계좌를 삭제하시겠습니까?(Y/N) : ");
							yn = scanner.next().charAt(0);
							if(yn == 'N' || yn == 'n') {} 
							else if (yn == 'Y' || yn == 'y') {id = null; pass = null; balance = 0;}
							else  {System.out.println("Y 혹은 N을 입력해 주세요");}
						}else  {System.out.println("다시 확인해 주세요");}
						
					} 
					
				}// for
								

			} 

		}
