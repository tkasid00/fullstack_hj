package com.company.java010_bank;

import java.util.Scanner;

import com.company.bank005_interface.BankController;

public class Deposit implements BankController {
	
	//멤버변수
	private UserInfo userInfo;

	public Deposit() { super(); }
	

	public Deposit(UserInfo userInfo) {
		super();
		this.userInfo = userInfo;
	}


	//멤버함수
	public void exec() {
		
		Scanner  scanner= new Scanner(System.in);
				
		System.out.print("입금 : ");
		double add = scanner.nextDouble();

		double newbalance = this.userInfo.getBalance() + add;
			System.out.println("==입금 완료 \n잔액:" + newbalance);
			 this.userInfo.setBalance(newbalance);
			 
//				this.userInfo.setBalance(this.userInfo.getBalance()+add);		
		
	
	}//exec
	
}
