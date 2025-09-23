package com.company.java010_ex;

class Sawon3{ 
    int pay      =10000;    	//인스턴스 - heap area - new - 생성자 초기화
    static int su=10;     		//클래스 - method area- new x - 생성자 x >바로 사용 가능
    static int basicpay=pay;    //클래스 - method area- new x - 생성자 x >바로 사용 가능 클래스명.basicpay 
    							//static은 this 사용 불가 > this는 new로 heap 영역을 할당받은 다음 사용 가능하기 때문에 바로 사용 가능한 static과 시점이 맞지 않음. 
    static int basicpay2;    	//클래스 - method area- new x - 생성자 x >바로 사용 가능
    
  //클래스 메서드 - method area- new x - 생성자 x - 클래스명.메서드(Sawon3.showSu) >바로 사용 가능
    public static void showSu() {   System.out.println(su);  }
  //클래스 메서드 - method area- new x - 생성자 x - 클래스명.메서드(Sawon3.showPay) >this 사용 불가, 오류 발생
    public static void showPay() {   System.out.println(this.pay);  }    
  
  // 인스턴스 메서드 - heap area - new - 생성자 
    public  void  showAll001() {   
       System.out.println(su);  	//static 사용 가능 > new 이전 메모리상에 static 올라가 있음
       System.out.println(this.pay);  // this 사용 가능
    } 
    //클래스 메서드 - method area- new x - 생성자 x - Sawon3.showAll002
    public static  void  showAll002() {   
        showAll001();    			 //인스턴스 메서드 사용 불가로 오류 발생
       System.out.println(this.pay); //this(인스턴스) 사용 불가로 오류 발생
    } 
} 
/////////////////////////////////////
public class MemberVarEx001 {
	  public static void main(String[] args) {
		   Sawon3   sola = new Sawon3();  //1) new 메모리 빌리고 객체 생성 2)생성자 초기화 3)sola 번지 주기
		   sola.showAll001();
		  }
		}

/*
------------------------[ runtime data area]
[method: 정보, static, final : 공용정보]
>Sawon3.class, MemberVarEx001.class
>static : Sawon3.su(), Sawon3.basicpay2(), Sawon3.showSu(), Sawon3.showAll002() 
------------------------------------
[heap: 동적]            		| [stack : 잠깐빌리기]
								
		인스턴스ㄱ					showAll001
1번지{pay, showAll001()}		<-sola[1번지] 29번째줄 발생
					   		|main
------------------------------------
*/




/*
1. 인스턴스변수, 클래스변수, 지역변수 를 구분하시오.
->인스턴스변수: pay
	클래스변수: su, basicpay, basicpay
	지역변수 : sola, args(main 안에서 사용)

2. 인스턴스메서드, 클래스메서드 구분하시오.
-> 인스턴스메서드 : showAll001()
	클래스메서드 : public으로 시작하는 모든 메서드
	
3. 오류나는 이유는? 
->public은 공용이라 개별 지정인 this는 사용 불가
 basicpay=pay;도 동일 원리
 */
