package com.company.java005_ex_MiniProject_SH;

import java.util.Scanner;

public class StrayToHome_01 {
	public static void main(String[] args) {


	int num1 = 0;
	int add = 0;
	String id = null, pass = null, tempid = null, temppass = null, lev = null, name= null;
	char yn = '\u0000';
	double balance =0;
	boolean login =false;
	
	Scanner scanner = new Scanner(System.in);

	for (;;) {
		 System.out.print( "  /|_/|\n" +
                 "_( o.o )__Stray to Home___♡♡\n" +"============================"+

            "\n0. 로그인" + "\n1. 보호자 등록" + "\n2. 고양이 정보 등록"+ "\n3. 상태 조회" + "\n4. 돌봄 활동" + "\n5. 병원 방문" + "\n9. 보호 종료 ");
         System.out.print("\n▶활동을 선택해 주세요 : ");
         
		num1 = scanner.nextInt();

		if (num1 == 9) {
			System.out.println("종료합니다.");
			break;

		} else if (num1 == 1) {
			System.out.print("ID를 생성해 주세요 : ");
			id = scanner.next();
			System.out.print("비밀번호를 생성해 주세요 : ");
			pass = scanner.next();
			System.out.println("보호자 정보가 등록되었습니다");
			
		} else if (num1 == 0) {			
			
			System.out.print("ID : ");
			tempid = scanner.next();
			System.out.print("비밀번호 : ");
			temppass = scanner.next();

			if (tempid.equals(id) && temppass.equals(pass)) {
				System.out.println("사용자 정보가 일치합니다");
				login = true;}
				
				else if (!(tempid.equals(id) && temppass.equals(pass))) {
			System.out.println("ID와 비밀번호를 확인해 주세요");
			continue;
			

		}
	
		} else if (num1 == 2) {
			
			System.out.print("ID : ");
			tempid = scanner.next();
			System.out.print("비밀번호 : ");
			temppass = scanner.next();
			login =true;

			if (!(tempid.equals(id) && temppass.equals(pass))) {
				System.out.println("ID와 비밀번호를 확인해 주세요");
				continue;
			}
			
	
		} else if (num1 == 2 || num1 == 3 || num1 == 4 || num1 == 5 || num1 == 6) {

			if (login==true) {continue;}
			else if (login=false){
			System.out.print("ID : ");
			tempid = scanner.next();
			System.out.print("비밀번호 : ");
			temppass = scanner.next();

			if (!(tempid.equals(id) && temppass.equals(pass))) {
				System.out.println("ID와 비밀번호를 확인해 주세요");
				continue;
			}}



			if (num1 == 2) {
				System.out.printf("%s \nID : %s \nPASS : %s \n잔액 : %d \n등급 : %s\n", "==계좌 조회", id, pass,
						(int) balance, lev);

			} else if (num1 == 3) {

				System.out.printf("입금 : ");
				add = scanner.nextInt();
				System.out.println("==입금 완료 \n잔액:" + (int) (balance += add));

				String newlev = balance >= 0 && balance < 10000 ? "BRONZ"
						: balance >= 10000 && balance < 100000 ? "SILVER"
								: balance >= 100000 && balance < 1000000 ? "GOLD" : "VIP";
				double newbalance = (int) (balance * 0.05);

				if (!newlev.equals(lev)) {
					System.out.println("축하합니다! 등급이 올랐습니다!" + "\n" + lev + "->" + newlev + "\n승급 축하 이자 5%가 지급됩니다 : +"
							+ (int) newbalance);
				}

				lev = newlev;
				balance = balance + newbalance;

			} else if (num1 == 4) {
				System.out.printf("출금 : ");
				add = scanner.nextInt();

				if ((double) add > balance) {
					System.out.println("잔액이 부족합니다");
				} else if ((double) add == balance) {
					System.out.println("잔액이 부족합니다\n수수료를 확인해 주세요");
				} else {
					switch (lev) {
					case "BRONZ":
						System.out.println(id + "님의 현재 등급은 BRONZ이며\n출금 수수료 10%가 부과됩니다");
						break;
					case "SILVER":
						System.out.println(id + "님의 현재 등급은 SILVER이며\n출금 수수료 7%가 부과됩니다");
						break;
					case "GOLD":
						System.out.println(id + "님의 현재 등급은 GOLD이며\n출금 수수료 5%가 부과됩니다");
						break;
					case "VIP":
						System.out.println(id + "님의 현재 등급은 VIP이며\n출금 수수료 3%가 부과됩니다");
						break;
					}

					System.out.print("출금을 진행하시겠습니까?(Y/N) : ");
					yn = scanner.next().charAt(0);
					if (yn == 'N' || yn == 'n') {
					} else if (lev == "BRONZ" && (yn == 'Y' || yn == 'y')) {
						System.out.println("==출금 완료 \n잔액:" + (int) ((balance -= add) - (add * 0.1)));
					} else if (lev == "SILVER" && (yn == 'Y' || yn == 'y')) {
						System.out.println("==출금 완료 \n잔액:" + (int) ((balance -= add) - (add * 0.07)));
					} else if (lev == "GOLD" && (yn == 'Y' || yn == 'y')) {
						System.out.println("==출금 완료 \n잔액:" + (int) ((balance -= add) - (add * 0.05)));
					} else if (lev == "VIP" && (yn == 'Y' || yn == 'y')) {
						System.out.println("==출금 완료 \n잔액:" + (int) ((balance -= add) - (add * 0.03)));
					} else {
						System.out.println("Y 혹은 N을 입력해 주세요");
					}
				}

			} else if (num1 == 5) {
				System.out.print("계좌를 삭제하시겠습니까?(Y/N) : ");
				yn = scanner.next().charAt(0);
				if (yn == 'N' || yn == 'n') {
				} else if (yn == 'Y' || yn == 'y') {
					id = null;
					pass = null;
					balance = 0;
					System.out.println("계좌를 성공적으로 삭제했습니다");
				} else {
					System.out.println("Y 혹은 N을 입력해 주세요");
				}

			} else if (num1 == 6) {
				System.out.println("==등급 안내");
				System.out.println("[BRONZ]\n예금액 0~9999원 달성!\n출금 수수료 : 10%");
				System.out.println("[SILVER]\n예금액 10000~99999원 달성!\n출금 수수료 : 7%");
				System.out.println("[GOLD]\n예금액 100000~999999원 달성!\n출금 수수료 : 5%");
				System.out.println("[VIP]\n예금액 1000000원 이상 달성!\n출금 수수료 : 3%\n");
				System.out.println(id + "님의 현재 등급은" + lev + "입니다");
			}

		} else {
			System.out.println("존재하지 않는 메뉴입니다");
		}

	} // for

}

}