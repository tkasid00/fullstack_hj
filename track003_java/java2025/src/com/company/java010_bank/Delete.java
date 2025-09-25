package com.company.java010_bank;

import java.util.Scanner;

public class Delete {
	
	private UserInfo userInfo;
	public Delete() { super();  }
	public Delete(UserInfo userInfo) { super(); this.userInfo = userInfo; }
	
	
	public void exec() { 
		Scanner scanner = new Scanner(System.in);
		

		
		System.out.print("계좌를 삭제하시겠습니까?(Y/N) : ");
		char yn = scanner.next().charAt(0);
		if (yn == 'N' || yn == 'n') {
		} else if (yn == 'Y' || yn == 'y') {
			
			this.userInfo.setId(null);
			this.userInfo.setPass(null);
			this.userInfo.setBalance(0);


			System.out.println("계좌를 성공적으로 삭제했습니다");
		} else {
			System.out.println("Y 혹은 N을 입력해 주세요");
		
		
	}
	}
}
