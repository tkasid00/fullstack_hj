package com.company.java010_bank;

import java.util.Scanner;

public class Widthdraw {
	
	//멤버변수
	private UserInfo userInfo;

	public Widthdraw() { super(); }
	public Widthdraw(UserInfo userInfo) { super(); this.userInfo = userInfo; }

	
	//멤버함수
	public void exec() {
		Scanner  scanner= new Scanner(System.in);
		System.out.print("출금 : ");
		double add = scanner.nextDouble();
		double newbalance = this.userInfo.getBalance() - add;
			System.out.println("==입금 완료 \n잔액:" + newbalance);
			 this.userInfo.setBalance(newbalance);
		
	
	}//exec
	
	
}
