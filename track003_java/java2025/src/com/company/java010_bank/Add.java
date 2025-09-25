package com.company.java010_bank;

import java.util.Scanner;

//클래스=부품객체
//상태+행위
public class Add {
	//상태:멤버변수
	private UserInfo userInfo;

	public Add() { super();  }
	public Add(UserInfo userInfo) { super(); this.userInfo = userInfo; }
	
	@Override
	public String toString() {
		return "Add [userInfo=" + userInfo + "]";
	}
	
	//행위:멤버함수
	public void exec() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("id 입력 : "); this.userInfo.setId(scanner.next());
		System.out.print("비밀번호 입력 : "); this.userInfo.setPass(scanner.next());
		System.out.print("잔액 입력 : "); this.userInfo.setBalance(scanner.nextDouble() );
		
		//this.userInfo = new UserInfo(id, pass, balance); private에서는 주소만 던지면 적용이 안됨
		//setter getter 사용해서 입력받기
		
		System.out.println("사용자 추가 완료 : " + this.userInfo);
	}
	
}
/*
 기능 :  유저 추가
 */