package com.company.java010_bank;

public class Show {
	//상태:멤버변수
	private UserInfo userInfo;

	public Show() { super();  }
	public Show(UserInfo userInfo) { super(); this.userInfo = userInfo; }

	//행위:멤버함수
	
	public void exec() {
		
		

		System.out.println("ID : " +this.userInfo.getId()
							+"\nPASS : " + this.userInfo.getPass()
							+ "\nBALANCE : "+ this.userInfo.getBalance());
		
		}

	
		
	@Override
	public String toString() {
		return "Show [userInfo=" + userInfo + "]";
	}
	


}
/*
기능 :  유저 정보 보여주기
*/
