package com.company.java008_ex;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx009 {

	public static void  who_are_you(String[][] users) {
		Scanner scanner = new Scanner(System.in);
		int find = -1;	
		String id = null;
		System.out.print("아이디를 입력해 주세요 > ");
		id = scanner.next();
		
		
		for(int i=0; i<users.length;i++) {
		if (id.equals(users[i][0]) ) {System.out.println(users[i][0] + "는 " + users[i][2]  + "사람 입니다");break;}
		
		
		}

	}
	
	/////////////
	
	public static void who_pass_change(String[][] users) {
		Scanner scanner = new Scanner(System.in);
		String id = null, pass = null;
		int find = -1;
		System.out.print("아이디를 입력해 주세요 > ");
		id = scanner.next();
		System.out.print("비밀번호를 입력해 주세요 > ");
		pass = scanner.next();
		

			for (int i = 0; i < users.length; i++) {
				
				if (id.equals(users[i][0]) && pass.equals(users[i][1])) {
					
				find = i;
	
					
				System.out.print("변경하실 비밀번호를 입력해 주세요 > ");
				String nextpass = scanner.next();
				users[i][1]=nextpass;
				break;
			}

		}

			System.out.println("변경한 정보 : " + users[i][0] + users[i][1]+users[i][2]);
			
		}

		
		}
///////////////////////////////////////////////
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
		   
		 //  System.out.println("정보 확인 : " + users[][]);
		   

		}
		   
		   
		   
		
		
	
///////////////////////////////////////////////
}
