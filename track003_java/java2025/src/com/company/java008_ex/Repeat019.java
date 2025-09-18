package com.company.java008_ex;

public class Repeat019 {
	
	public static void start() {
		System.out.println("부우웅...");
	}

	public static void scan(int n, char ch) {
		for (int i = 0; i < n; i++) {
			System.out.print(ch);
		}

	}

	public static String signalGrade(int strength) {
		return strength >= 90 ? "A" : strength >= 70 ? "B" : strength >= 50 ? "C" : "D";
	}

	public static int charge(int current, int added) {
		return current + added;
	}

////////////////////////////////////////////////////////	
    public static void main(String[] args) {
        System.out.println("🤖 탐사 로봇이 기동합니다!");
        start();                    // "부우웅..." 출력

        System.out.println("\n🪐 행성 스캔 중...");
        scan(5, '#');              // ##### 출력

        System.out.println("\n📡 신호 강도 분석 결과:");
        System.out.println("신호 등급: " + signalGrade(65));  // C 출력

        System.out.println("\n🔋 배터리 충전 중...");
        System.out.println("충전 완료: " + charge(40, 40) + "%");  // 80 출력
    }
////////////////////////////////////////////////////////
}
