package com.company.java008_ex;

import java.util.Scanner;

public class MethodEx006_02 {
	
	String[] name = new String[5];
	
	int[] attack= new int[5];
	int[] defense= new int[5];
	int[] speed= new int[5];
	int[] total= new int[5];
	float[] avg= new float[5];
	String[] grade= new String[5];
	String[] star= new String[5];
	String[] quest= new String[5];
	String[] type= new String[5];
	String[] title= new String[5];

	int i=0;
	int [] rank = {1,1,1,1,1};
	
	
	
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
	
	public static int poocess_rank(avg[i]) { 
		for(int j=0; j<rank.length;j++){
				for(int i =0; i<rank.length;i++){
						if(avg[j] < avg[i]) {avg[j]++;}
						}
				}
		
		}
	
	
	public static void process_show(String name,   int attack,   int defense,   int speed, int total,  float avg,  String grade,  String star,  String quest, String type, String title) 
	{	
	
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t\t%-5s\t\t%-5s\t\t%-5s \n", 
				"캐릭터",   "공격력",   "방어력",   "민첩성",   "총합",  "평균",   "등급",   "랭킹",   "추천퀘스트" ,  "캐릭터타입", "칭호", "순위");
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.printf("%-5s\t%-5d\t%-5d\t%-5d\t%-5d\t%-5.2f\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\n", 
				name,   attack,   defense,   speed,  total,  avg,   grade,   star,  quest,  type, title, rank);
		System.out.println("-------------------------------------------------------------------------------------------------");  

	}
		
	
///////////////////////////////////////	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] name = new String[5];
		
		int[] attack= new int[5];
		int[] defense= new int[5];
		int[] speed= new int[5];
		int[] total= new int[5];
		float[] avg= new float[5];
		String[] grade= new String[5];
		String[] star= new String[5];
		String[] quest= new String[5];
		String[] type= new String[5];
		String[] title= new String[5];

		int i=0;
		int [] rank = {1,1,1,1,1};
		

		System.out.print("이름을 입력하세요 : "); name[i] = scanner.next();
		System.out.print("공격력을 입력하세요(0~100) : "); attack[i] = scanner.nextInt();
		System.out.print("방어력을 입력하세요(0~100) : "); defense[i] = scanner.nextInt();
		System.out.print("민첩성을 입력하세요(0~100) : "); speed[i] = scanner.nextInt();
		
		total[i] = process_total(attack[i],defense[i],speed[i]);
		avg[i] = process_avg(total[i]);
		grade[i] = process_grade(avg[i]);
		star[i] = process_star(avg[i]);
		quest[i] = process_quest(avg[i]);
		type[i] = process_type(attack[i],defense[i],speed[i]);
		title[i] = process_title(avg[i]);
		rank[i] = process_rank(avg[i]);
		
		process_show(name[i],attack[i], defense[i],speed[i], total[i],avg[i],grade[i],star[i], quest[i], type[i], title[i], rank[i]);
		

		
		
		
	}
////////////////////////////////////////
}
