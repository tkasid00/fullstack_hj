package com.company.java008_ex;

import java.util.Scanner;

public class MethodEx010 {

	
//	###  ④  보너스 과제 (선택)
//
//	- 신규 동물 등록 기능을 추가 
//	- 전체 예약 목록을 출력하는 기능 
//	- 진료 항목을 랜덤으로 추천해주는 기능 	
	
	
///////////////////////////
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[][] pets = {
			    {"콩이", "010-1234-5678", "예방접종"}, //00 01 02
			    {"초코", "010-2345-6789", "건강검진"}, //10 11 12
			    {"보리", "010-3456-7890", "치아관리"}  //20 21 22
			};
		
		String petname = "", pn = "", other = "";
		//int find = -1;

		
		
		for(;;) {int find = -1;
			System.out.println("🐾 동물 병원 시스템 메뉴 \n1. 진료 항목 조회 \n2. 진료 항목 변경 \n3. 종료");
			System.out.print("👉 메뉴 번호를 선택해주세요: "); 
			int j = scanner.nextInt();
			
			
			
			if(j==3) {System.out.println("👋 시스템을 종료합니다. 안녕히 가세요!"); break;  }
			else if (j == 1) {
				System.out.print("🐶 동물 이름을 입력해주세요");
				petname = scanner.next();

				for (int i = 0; i < pets.length; i++) {
					
					if (petname.equals(pets[i][0])) { 
						 find = i;
						break;			
					}
					
					
				}//1번 for
				if(find != -1) {
						System.out.println("✅ " + pets[find][0] + "는 " + pets[find][2] + "예약이 되어 있어요.");  
				}else {System.out.println("❌ 등록 정보를 확인해주세요!"); }
			}
				
			 else if (j == 2) {
				System.out.print("🐶 동물 이름을 입력해주세요");
				petname = scanner.next();
				System.out.println("📞 보호자 전화번호를 입력해주세요");
				pn = scanner.next();
				
				for (int i = 0; i < pets.length; i++) {
					
					if (  petname.equals(pets[i][0]) &&   pn.equals(pets[i][1]) ) {
						System.out.print("🩺 변경하실 진료 항목을 입력해주세요");
						other = scanner.next();
						pets[i][2] =  other;
						 find = i;
						break;
					} 
					
				}//2번 for 
				if(find!= -1) {System.out.println("예약 정보 확인 :" + pets[find][0] + pets[find][1] + pets[find][2]);
				}else {System.out.println("❌ 등록 정보를 확인해주세요!"); }
		
			}
			

			
		}//end for
		

	}
/////////////////////////
}
