package com.company.java005_ex_MiniProject_Bank;
import java.util.Arrays;
import java.util.Scanner;

public class Bankver_0 {
	
	   public static void main(String[] args) {
		      //변수                          0   1    2
		      String []id=new String[3];       //  one two three
		      String []pass = new String[3];   // 1111 2222 3333
		      double []balance = new double[3];// 1100 2200 3300   
		      int num=-1;  
		      Scanner scanner = new Scanner(System.in);
		      int i=0;
		      
		      
		      
		      //입력 + 처리 + 출력
		      
		      
		      while(num!=9) {
		    	  
		    	  // 빈칸인지 확인. if(0번째가 빈칸이면){find는 0}
		    	  int find=-1; //<빈칸에 넣을 번호
		    	  for(i=0; i<id.length;i++){if (id[i] == null) {find = i; break;} 
		    	  if(find == -1) {System.out.println("계좌 생성이 불가능합니다"); continue; }
		    	  
		    	  }	
		    	 
		    	  
		    	  
					System.out.print(
							"_____________________\n (주)JAVATEXT BANK   \n______*WELCOME*______\n* 0.로그인 \n* 1.신규 개설 \n* 2.내 계좌 조회 \n* 3.입금 \n* 4.출금 \n* 5.계좌 삭제 \n* 6.등급 안내 \n* 9.종료\n_____________________\n");
					System.out.print("메뉴를 선택해 주세요> ");
					num = scanner.nextInt();
					
					//전체적인 큰 틀 잡기
					if(num==1) {
						System.out.print("아이디 입력 : "); id[find] = scanner.next();
						System.out.print("비밀번호 입력 : "); pass[find] = scanner.next();
						System.out.print("금액 입력 : "); balance[find] = scanner.nextDouble();
						
						
					}else if(num==2||num==3||num==4||num==5) {
						
						//1사용자 인증
						int find = -1; //find 인증할 번호
						//2.각각의 처리
						System.out.print("아이디 입력 : "); String tempid = scanner.next();
						System.out.print("비밀번호 입력 : "); String tempass = scanner.next();
						
						for (i=0;i<id.length;i++) {
						if(tempid.equals(id[find]) && tempass.equals(tempass)) {find=i; break;}
						}
						
						if(find==-1) {System.out.println("아이디와 비밀번호를 확인해 주세요"); continue;}
						
						switch(num) { 
						case 2: System.out.println("아이디 : " + id[find] + "\n비밀번호 : " + pass[find] + "\n잔액 : " + balance[find]); break;
						case 3: System.out.print("입금할 금액 : "); double temp1 = scanner.nextDouble();
						balance[find] += temp1; break;
						case 4: System.out.println("출금할 금액 : "); double temp2 = scanner.nextDouble();
						balance[find] -= temp2; break;
						case 5: System.out.println("정말로 삭제하시겠습니까?");
						 if(scanner.next().toLowerCase().equals("y")) {
							 id[i] =null; pass[i] = null; balance[i] = 0;
						 }else {}break;
						
							 
						 } 
						
						
						
					}else {System.out.println("메뉴를 확인해 주세요");}
		    	  
		    	  
		      }
		       
		   }// end main
		}//end class


