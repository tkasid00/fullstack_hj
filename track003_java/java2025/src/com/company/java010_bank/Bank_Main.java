package com.company.java010_bank;

import java.util.Scanner;

//1.클래스=부품객체
//상태+행위
public class Bank_Main {
	//상태:멤버변수
	UserInfo userInfo;   //정보 보관 용도 - model -db
	Add		add;
	Show	show;
	Deposit	deposit;   //입금
	Widthdraw widthdraw;   //출금
	Delete delete;
	Login login;

	//행위:멤버함수(초기화)
	public Bank_Main() {
		this.userInfo = new UserInfo("","",0); //null 출력 방지
		this.add = new Add(this.userInfo);
		this.show = new Show(this.userInfo);
		this.deposit = new Deposit(this.userInfo);
		this.widthdraw = new Widthdraw(this.userInfo);//new는 한 곳에서만
		this.delete = new Delete(this.userInfo);
		this.login = new Login(this.userInfo);
	}

	public void run() {
		//1.무한반복 
		Scanner scanner = new Scanner(System.in);
		int num=-1;
		while(num != 9) {
			System.out.println("MAIN:"+this.userInfo +"\n" + System.identityHashCode(this.userInfo));
			System.out.print(
					"WELCOME! (주)CODEJOHNS BANK\n=======BANK====== \n* 1.추가 \n* 2.조회 \n* 3.입금 \n* 4.출금 \n* 5.삭제 \n* 9.종료\n");
			System.out.print("입력>>>");
			num = scanner.nextInt();
			
			switch(num) {
			case 1 : this.add.exec(); break;
			case 2 : case 3 : case 4 : case 5 :
				//유저 정보 확인
				if(this.login.exec()==-1) {System.out.println("유저 정보를 확인해 주세요");} break;}

				// 각각의 처리
				switch (num) { 
				case 2: this.show.exec(); break; 
				case 3: this.deposit.exec(); break; 
				case 4: this.widthdraw.exec(); break; 
				case 5: this.delete.exec(); break; 
				//case 0: this.login.exec(); break; 
				} //switch2
				
				 
				
			}//while

		
	}//run
	
	public static void main(String[] args) {
		
		Bank_Main bank = new Bank_Main();
		bank.run();
		


	}
}