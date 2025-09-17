package com.company.java008_ex;

import java.util.Scanner;

public class MethodEx006 {
	
	
	public static int process_total(int attack, int defense,int speed) {return attack+defense+speed;}
	public static float process_avg(int total) {return (float)(total/3.0);}
	public static String process_grade(float avg) {return avg>=90? "S등급" : avg>=80? "A등급" :avg>=70? "B등급" :avg>=60? "C등급" : "D등급";}
	public static String process_star(float avg) { String result = "";
						for(int i=0; i<(int)(avg*0.1);i++) {result += "*";} return result; }
	public static String process_quest(float avg)  {return avg>=90? "전설의 용 퇴치" : avg>=80? "호수 던전 1인 클리어" :avg>=70? "토너먼트 메달 획득" :avg>=60? "해골 광산 100층 도달" : "데일리 퀘스트";}
	public static String process_type(int attack, int defense,int speed) {    String result = "";
												if(attack>defense && attack>speed) {result = "전사형";}
												else if(defense>attack && defense>speed) {result = "힐러형";}
												else if(speed>attack && speed>defense) {result = "도적형";}
												else if(attack==100 && defense==100 && speed==100 ) {result = "고인물";}
												return result;}
	public static String process_title(float avg) { return avg==100? "전설의 영웅" : "-";}
	
	public static void process_show(String name,   int attack,   int defense,   int speed, int total,  float avg,  String grade,  String star,  String quest, String type, String title) 
	{	
	
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t\t%-5s\t\t%-5s \n", 
				"캐릭터",   "공격력",   "방어력",   "민첩성",   "총합",  "평균",   "등급",   "랭킹",   "추천퀘스트" ,  "캐릭터타입", "칭호");
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.printf("%-5s\t%-5d\t%-5d\t%-5d\t%-5d\t%-5.2f\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\n", 
				name,   attack,   defense,   speed,  total,  avg,   grade,   star,  quest,  type, title);
		System.out.println("-------------------------------------------------------------------------------------------------");  

	}
		
	
///////////////////////////////////////	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = "";
		int attack=0, defense=0, speed=0;
		int total=0;
		float avg=0;
		String grade="", star="", quest="", type ="";
		String title ="";

		System.out.print("이름을 입력하세요 : "); name = scanner.next();
		System.out.print("공격력을 입력하세요(0~100) : "); attack = scanner.nextInt();
		System.out.print("방어력을 입력하세요(0~100) : "); defense = scanner.nextInt();
		System.out.print("민첩성을 입력하세요(0~100) : "); speed = scanner.nextInt();
		
		total = process_total(attack,defense,speed);
		avg = process_avg(total);
		grade = process_grade(avg);
		star = process_star(avg);
		quest = process_quest(avg);
		type = process_type(attack,defense,speed);
		title = process_title(avg);
		
		process_show(name,attack, defense,speed, total,avg,grade,star, quest, type, title);
		

		
		
		
	}
////////////////////////////////////////
}
