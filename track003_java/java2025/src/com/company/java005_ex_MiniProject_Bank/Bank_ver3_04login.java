package com.company.java005_ex_MiniProject_Bank;

import java.util.Scanner;

public class Bank_ver3_04login {

	public static void main(String[] args) {

		int num1 = 0;
		int add = 0;
		String id = null, pass = null, tempid = null, temppass = null, lev = null;
		double balance = 0;
		char yn = '\u0000';
		Scanner scanner = new Scanner(System.in);
		boolean login = false;

		lev = balance >= 0 && balance < 10000 ? "BRONZ"
				: balance >= 10000 && balance < 100000 ? "SILVER"
						: balance >= 100000 && balance < 1000000 ? "GOLD" : "VIP";

		for (;;) {
			System.out.print(
					"_____________________\n (주)JAVATEXT BANK   \n______*WELCOME*______\n* 0.로그인 \n* 1.신규 개설 \n* 2.내 계좌 조회 \n* 3.입금 \n* 4.출금 \n* 5.계좌 삭제 \n* 6.등급 안내 \n* 9.종료\n_____________________\n");
			System.out.print("메뉴를 선택해 주세요> ");
			num1 = scanner.nextInt();

			if (num1 == 9) {
				System.out.println("종료합니다.");
				break;
			}

			else if (num1 == 0) {

				System.out.print("ID : ");
				tempid = scanner.next();
				System.out.print("비밀번호 : ");
				temppass = scanner.next();

				if (id == null && pass == null) {
					System.out.println("계정이 존재하지 않습니다\n계정을 생성해 주세요");
				}

				else if (tempid.equals(id) && temppass.equals(pass)) {
					System.out.println("사용자 정보가 일치합니다");
					login = true;
				}

				else if (!(id == null && pass == null || tempid.equals(id) && temppass.equals(pass))) {
					System.out.println("ID와 비밀번호를 확인해 주세요");
					continue;
				}
				

			} else if (num1 == 1) {
				System.out.print("ID를 생성해 주세요 : ");
				id = scanner.next();
				System.out.print("비밀번호를 생성해 주세요 : ");
				pass = scanner.next();
				System.out.print("개설 초기 금액을 입금해 주세요 : ");
				balance = scanner.nextDouble();
				System.out.println("축하합니다!\n계좌가 성공적으로 생성되었습니다\n로그인 후 이용해 주세요");
				lev = balance >= 0 && balance < 10000 ? "BRONZ"
						: balance >= 10000 && balance < 100000 ? "SILVER"
								: balance >= 100000 && balance < 1000000 ? "GOLD" : "VIP";
			} else if (login == false && (num1 == 2 || num1 == 3 || num1 == 4 || num1 == 5 || num1 == 6)) {
				System.out.println("로그인이 필요합니다");

			} else if (login == true && (num1 == 2 || num1 == 3 || num1 == 4 || num1 == 5 || num1 == 6)) {

				if (num1 == 2) {
					System.out.printf("%s \nID : %s \nPASS : %s \n잔액 : %d \n등급 : %s\n", "==계좌 조회", id, pass,
							(int) balance, lev);

				} else if (num1 == 6) {
					System.out.println("==등급 안내");
					System.out.println("[BRONZ]\n예금액 0~9999원 달성!\n출금 수수료 : 10%");
					System.out.println("[SILVER]\n예금액 10000~99999원 달성!\n출금 수수료 : 7%");
					System.out.println("[GOLD]\n예금액 100000~999999원 달성!\n출금 수수료 : 5%");
					System.out.println("[VIP]\n예금액 1000000원 이상 달성!\n출금 수수료 : 3%\n");
					System.out.println(id + "님의 현재 등급은" + lev + "입니다");
				

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

			}
				else if (num1 == 3) {

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
						balance = balance + newbalance;
					}

					lev = newlev;

				} else if (num1 == 4) {
				    System.out.printf("출금 : ");
				    add = scanner.nextInt();

				    double fee = 0;
				    switch (lev) {
				        case "BRONZ": fee = add * 0.1; break;
				        case "SILVER": fee = add * 0.07; break;
				        case "GOLD": fee = add * 0.05; break;
				        case "VIP": fee = add * 0.03; break;
				    }

				    double totaladd = add + fee;

				    if (totaladd > balance) {
				        System.out.println("잔액이 부족합니다");
				    } 
				    
				    else if (totaladd == balance) {
				        System.out.println("잔액이 부족합니다\n수수료를 확인해 주세요");
				    } else {
				        System.out.printf("%s님의 현재 등급은 %s이며\n출금 수수료 %.0f%%가 부과됩니다\n", id, lev, (fee / add) * 100);
				        System.out.print("출금을 진행하시겠습니까?(Y/N) : ");
				        yn = scanner.next().charAt(0);

				        if (yn == 'Y' || yn == 'y') {
				            balance -= totaladd;
				            System.out.println("==출금 완료");
				            System.out.println("출금액 : " + add);
				            System.out.println("수수료 : " + (int) fee);
				            System.out.println("잔액 : " + (int) balance);
				        } else if (yn == 'N' || yn == 'n') {
				            System.out.println("출금이 취소되었습니다");
				        } else {
				            System.out.println("Y 혹은 N을 입력해 주세요");
				        }
				    }
				}

				}   else {
				System.out.println("존재하지 않는 메뉴입니다");
			}

		} // for

	}

}
