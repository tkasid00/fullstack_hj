package com.company.java003_ex;

public class OperatorEx001 {
	public static void main(String[] args) {
	    int a=3, b=10;
	    
	    System.out.println(  b+=10 - a-- ); // 0. 연산자 우선순위 [-- > - > +=]
	    									// 1. a-- : a 출력 후 마지막에 --연산이므로 -- 순서는 맨 뒤로 밀림
	    									// 2. 10-a -> 10-3 -> 7
	    									// 3. b+=7 -> 10+=7 -> b=10+7
	    System.out.println(  a+=5 ); // 2. a는 위에서 2가 됐으니까 + 5 해서 7이 됨
	    System.out.println(  a>=10 || a<0 && a>3); //3. a==7
	            //a가 10과 같거나 크다 || a가 0보다 작다 && a가 3보다 크다
	    		//				(하나만 만족)	 	(둘다 만족)
	    		//7가 10과 같거나 크다 || 7가 0보다 작다 && 7가 3보다 크다
	}			//	false			|| (false	&&		true)-> false

}
