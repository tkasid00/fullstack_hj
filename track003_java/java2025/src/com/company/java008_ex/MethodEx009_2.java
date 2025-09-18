package com.company.java008_ex;

import java.util.Scanner;

public class MethodEx009_2 {
	
	public static void who_are_you(String[][] users) {
		String tempid = "", result = "존재하지 않는 아이디입니다";
		
		Scanner scanner = new Scanner(System.in);
		System.out.print( "아이디를 입력해 주세요 : ");
		tempid= scanner.next();
		
		for (int i = 0; i < users.length; i++) {
			if (tempid.equals(users[i][0])) {
				result = users[i][0] + "는 " + users[i][2] + "사람 입니다"; break;
			}

		}System.out.println(result); 

	}
	////
	public static void who_pass_change(String[][] users) {
		// 변수
		String tempid = "", temppass = "";
		// 입력
		Scanner scanner = new Scanner(System.in);
		System.out.print("아이디를 입력해 주세요 : ");
		tempid = scanner.next();
		System.out.print("비밀번호를 입력해 주세요 : ");
		temppass = scanner.next();

		// 처리1
		int a = -1;//유저의 번호를 찾아서 a에 담기, 못 찾으면 -1
		for (int i = 0; i < users.length; i++) {

//			if (!(tempid.equals(users[i][0]) && temppass.equals(users[i][1]))) {
//				System.out.println("사용자 정보가 일치하지 않습니다");
//				break;
//			}
			if (tempid.equals(users[i][0]) && temppass.equals(users[i][1])) {

				System.out.print("변경하실 비밀번호를 입력해 주세요 > ");
				String nextpass = scanner.next();
				users[i][1] = nextpass;
				a=i;
				break;

			}



		}
		//출력
		
		if(a!=-1) {
		System.out.println("변경한 정보 : [" + users[a][0] + "][" + users[a][1] + "][" + users[a][2] + "]");}
	
		else{System.out.println("사용자 정보가 일치하지 않습니다");}
		
	}


////////////////////////////////////////	
	public static void main(String[] args) {
		
		// 변수
		   String [][] users = {{ "aaa"  , "111"   , "한국"     } ,     // 00 01 02
		                      { "bbb" , "222"   , "호주"       } ,       // 10 11 12
		                      { "ccc"  , "333"   , "중국"      }};      // 20 21 22
		   // 입력
		   who_are_you(users);    
		   //  public static void who_are_you(String [][] users){  아이디를입력받아서 나라조회 }
		  who_pass_change(users); 
		   //  public static void who_pass_change(String [][] users){ 아이디,비밀번호가 맞으면 비밀번호 바꾸기}
		
	}
//////////////////////////////////////////
}
