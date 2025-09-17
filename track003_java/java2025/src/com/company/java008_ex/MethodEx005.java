package com.company.java008_ex;

import java.util.Scanner;

public class MethodEx005 {

	private static final String String = null;

	public static int process_total(int kor, int eng, int math) {
		return kor + eng + math;
	}

	public static float process_avg(int total) {
		return (float) (total / 3.0);
	}

	public static String process_pass(float avg, int kor, int eng, int math) {
		return avg >= 60 ? "합격" : kor >= 40 ? "불합격" : eng >= 40 ? "불합격" : math >= 40 ? "불합격" : "재시험";
	}

	public static String process_scholar(float avg) {
		return avg >= 95 ? "장학생" : "-";
	}

	public static String process_star(float avg) {
		String result = "";
		for (int i = 0; i < (int) (avg * 0.1); i++) {
			result += "*";
		}
		return result;
	}

///////////////////////////////
	public static void main(String[] args) {
		String name = "";
		int kor, eng, math, total;
		float avg = 0.0f;
		String pass = "";
		String jang = "";
		String star = "";
		Scanner scanner = new Scanner(System.in);

		System.out.print("이름을 입력하세요 : ");
		name = scanner.next();
		System.out.print("국어 점수를 입력하세요 : ");
		kor = scanner.nextInt();
		System.out.print("영어 점수를 입력하세요 : ");
		eng = scanner.nextInt();
		System.out.print("수학 점수를 입력하세요 : ");
		math = scanner.nextInt();

		total = process_total(kor, eng, math); // 1. 총점처리

		avg = process_avg(total); // 2. 평균처리

////////3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/합격 // 재시험-각각 40미만인게 있다면  
		pass = process_pass(avg, kor, eng, math);

		//////// 4. 평균이 95점이상이면 장학생
		jang = process_scholar(avg);

		//////// 5. 평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개
		// String process_star (float avg)
		star = process_star(avg);

		System.out.println(
				"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: ");
		System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t\n", "이름", "국어", "영어", "수학", "총점",
				"평균", "합격여부", "장학생", "랭킹");
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		System.out.printf("%-5s\t%-5d\t%-5d\t%-5d\t%-5d\t%-5.2f\t%-5s\t%-5s\t%-5s\t\n", name, kor, eng, math, total,
				avg, pass, jang, star);

	}
////////////////////////////////////////

}
