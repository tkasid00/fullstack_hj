package com.company.java009_ex;
import java.util.Scanner;

class TV {
	String channel;
	int volume;

	public TV() { super(); }

	public TV(String channel, int volume) {
		this.channel = channel;
		this.volume = volume;
	}

	void input() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("* channel입력> ");
		this.channel = scanner.next();
		System.out.print("* volume 입력> ");
		this.volume = scanner.nextInt();

	}

	void show() {
		System.out.printf(this.channel + "\t" + this.volume + "\n");
	}
}
/////////////////////////////////////////////////////////
public class ClassEx004 {

	public static void main(String[] args) {
		TV t1 = new TV("JDBC", 8);
		t1.show();
		TV t2 = new TV();
		t2.input();
		t2.show();
	}
}
/////////////////////////////////////////////////////////