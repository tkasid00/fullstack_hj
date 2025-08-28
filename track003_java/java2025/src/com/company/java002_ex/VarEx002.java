package com.company.java002_ex;

public class VarEx002 {
	public static void main(String[] args) {
		int a=10;
		int b=3;
		System.out.println(a + "+" + b + "=" + (a+b));
		System.out.println(a + "-" + b + "=" + (a-b));
		System.out.println(a + "*" + b + "=" + (a*b));
		System.out.println(a + "/" + b + "=" + (a/b));
		
		
		System.out.printf("%d+%d=%d\n",a,b,(a+b));
		System.out.printf("%d-%d=%d\n",a,b,(a-b));
		System.out.printf("%d*%d=%d\n",a,b,(a*b));
		System.out.printf("%d/%d=%d\n",a,b,(a/b));
		
		System.out.printf("%s  %d", a, b); //맞는 형식 선택해서 사용
	
		
	}

}
