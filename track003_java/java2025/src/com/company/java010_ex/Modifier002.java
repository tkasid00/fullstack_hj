package com.company.java010_ex;

import com.company.java010.UserInfo;

class UserSon2 extends UserInfo{
	public void show() {
		System.out.println("홍길동 아버지 이름 : " + super.name);			//자식 - public
		System.out.println("홍길동 아버지 금고 번호 : " + super.safeCode);	//자식 - protected
		System.out.println("홍길동 아버지 집 : " + super.house);			//자식 - package(같은 폴더)
	//	System.out.println("홍길동 아버지 IQ : " + super.iQ);
		System.out.println("홍길동 아버지 IQ : " + super.getiQ());	
	} 
	//Q1. super.house 오류 : UserInfo 클래스의 house는 접근자가 package(같은 폴더-com.company.java010)
	//		UserSon2 클래스는 com.company.java010_ex; 안에 있음
	
}
////////////////////////////////////////////////////
public class Modifier002 {
	public static void main(String[] args) {
		System.out.println("\n\n1. 홍길동 아버지 정보"); //본인 : public, protected, default 가능/ private(x)
		UserInfo user = new UserInfo();
		user.name="홍상직";	//public 아무데서나 접근 가능
		user.safeCode = "1234"; //protected 본인 정보 접근 가능		//Q2. 오류 : Modifier002는 extends 상속받은 적이 없음
		user.house = "전라남도 장성군";								//Q3. 오류 : 같은 폴더 아님
//		user.iQ = 148;   //The field UserInfo.iQ is not visible
		user.setiQ(148);
		System.out.println(user.getiQ());
	
	}

}
////////////////////////////////////////////////////