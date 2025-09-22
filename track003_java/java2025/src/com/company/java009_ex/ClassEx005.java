package com.company.java009_ex;

import java.util.Scanner;

class Card {
	int cardNum;
	boolean isMembership;
	
	

	public Card() {
		super();
	}

	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("채널 입력 : ");
		this.cardNum = scanner.nextInt();

		System.out.print("볼륨 입력 : ");
		this.isMembership = scanner.nextBoolean();
	}

	void show() {
		System.out.printf(this.cardNum + "\t" + this.isMembership);
	}

	@Override
	public String toString() {
		return "Card [cardNum=" + cardNum + ", isMembership=" + isMembership + "]";
	}

}

///////////////////////////////////////////////
public class ClassEx005 {
	public static void main(String[] args) {
		Card c1 = new Card();
		System.out.println(c1);   //Card [cardNum=0, isMembership=false]
	}
}

/////////////////////////////////////////////