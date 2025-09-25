package com.company.java010_bank;

import java.util.Scanner;

public class Login {
	
 private UserInfo userInfo;
 public Login() { super();  }
 public Login(UserInfo userInfo) { super(); this.userInfo = userInfo; }  
 

 
 	public void exec() {
	
			
			}//exec

 }//class







//Scanner scanner = new Scanner(System.in);
//
//System.out.print("ID : ");
//String tempid = scanner.next();
//System.out.print("비밀번호 : ");
//String temppass = scanner.next();
//
//String id =this.userInfo.getId();
//String pass = this.userInfo.getPass();
//
//if (this.userInfo.getId() == null && this.userInfo.getPass() == null) {
//	System.out.println("계정이 존재하지 않습니다\n계정을 생성해 주세요");
//}
//
//else if ((tempid.equals(id) && temppass.equals(pass))) {
//	System.out.println("사용자 정보가 일치합니다");
//	this.userInfo.setLogin(true);
//}
//
//else if (!(id == null && pass == null || tempid.equals(id) && temppass.equals(pass))) {
//	System.out.println("ID와 비밀번호를 확인해 주세요"); }