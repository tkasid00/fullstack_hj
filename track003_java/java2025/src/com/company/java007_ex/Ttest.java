package com.company.java007_ex;

public class Ttest {

	public static void main(String[] args) {
		char [] answer = {'A', 'C', 'B', 'D', 'A'};
		char [] correct = new char[answer.length];
		int a = 0; // 맞은 개수
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<answer.length; i++) {
			System.out.print("입력 > ");
			correct[i] = sc.next().charAt(0);
		}
		
		for(int i=0; i<answer.length; i++) {
			if(answer[i]==correct[i]) {
				System.out.println((i+1) + "번: 정답");
				a++;
			}
			else if(answer[i]!=correct[i]) {
				System.out.println((i+1) + "번: 오답");
			}
		}
		
		System.out.println("총 맞은 개수: " + a + "개");
		
	}
}
}
