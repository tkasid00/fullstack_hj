package com.company.java010_ex;
//1.클래스=부품객체
//2. 클래스=상태(멤버변수)+행위(멤버함수)

class Mobile2{  
	//상태
    String   serialNo;   //인스턴스 변수 heap area, new, this 사용ㅇ (생성자에서 초기화)
    static  int count=0; //클래스 변수 method, new x, this x, 생성자x 지금 당장 바로
    
    //행위
    public Mobile2() {
    	//객체를 한 개씩 만들 때마다 serialNo 숫자를 한 개씩 증가 / ++count
    
    	this.serialNo = "2030-" + ++count;
    }

    
} 

////////////////////////////////////////////////
public class StaticEx002 {

	public static void main(String[] args) {
		
		  Mobile2 m1 = new Mobile2(); //1. new 공간빌리기  2. 생성자()  3. 번지
		   Mobile2 m2 = new Mobile2(); 
		   Mobile2 m3 = new Mobile2();  
		   Mobile2 m4 = new Mobile2();  

		   System.out.println("모바일 갯수는 모두 "+ Mobile2.count +"개 입니다.");  //클래스명.변수 클래스 변수
		   System.out.println("m1의 제품번호 " + m1.serialNo);  //1  1번지.변수명
		   System.out.println("m2의 제품번호 " + m2.serialNo);  //2
		   System.out.println("m3의 제품번호 " + m3.serialNo);  //3
		   System.out.println("m4의 제품번호 " + m4.serialNo);  //4


	}

}
