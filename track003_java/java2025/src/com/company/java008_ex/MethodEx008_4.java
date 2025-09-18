package com.company.java008_ex;

import java.util.Arrays;

public class MethodEx008_4 {
////////////////////////////////////////////
	public static void main(String[] args) {
		
		String[][] apt = {
				{"이자헌", "은하제", "김민성"}, //00 01 02
				{"김솔음", "고영은", "백사헌"}, //10 11 12
				{"진나솔", "이성해", "브라운"}  //20 21 22
		};
		
		System.out.println("main > APT- " + Arrays.deepToString(apt));
		
		ringBell(apt);
		
		System.out.println("main > APT - BELL 🔔 " +Arrays.deepToString(apt));
		
	}
///////////////////////////////////
	public static void ringBell(String[][] apt) {apt[1][1] ="🔔";}
}
 /*	[heap]										[stack]
  												ringBell(1000번지)
  	1000번지 apt[3][3]							apt[1000번지] 9번줄
  	apt[0층 1001번지|1층 1002번지|2층 1003번지]
  	1001번지 {"이자헌", "은하제", "김민성"}
  	1002번지 {"김솔음", "고영은", "백사헌"}
  	1003번지 {"진나솔", "이성해", "브라운"}
  	
  */