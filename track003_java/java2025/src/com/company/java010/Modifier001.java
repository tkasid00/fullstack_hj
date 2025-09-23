package com.company.java010;

// public(아무데나) > protected(extends) > default(같은 폴더) > private(클래스 안에서) 


public class Modifier001 {
	public static void main(String[] args) {
		System.out.println("\n\n1. 홍길동 아버지 정보"); //본인 : public, protected, default 가능/ private(x)
		UserInfo user = new UserInfo();
		user.name="홍상직";	//public 아무데서나 접근 가능
		user.safeCode = "1234"; //protected 본인 정보 접근 가능
		user.house = "전라남도 장성군";
//		user.iQ = 148;   //The field UserInfo.iQ is not visible
		user.setiQ(148);
		System.out.println(user.getiQ());
	
	}

}
////////////////////////////////////////////////////