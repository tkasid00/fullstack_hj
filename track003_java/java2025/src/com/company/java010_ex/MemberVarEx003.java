package com.company.java010_ex;

class LunchTray {
    String owner;        
    int rice = 90;               
    int soup = 85;               
    
    static int trayCount = 0;           

    int totalFood = rice + soup;

    static int maxRice = 100;       

    public int getFoodAmount() {
        return rice + soup;         
    }

    public static void showTrayCount() {
    	
        System.out.println("전체 급식판 수: " + trayCount);   
    }

    public void showOwner() {
 
    	this.owner = "std-" + ++trayCount;

    }

    public void showTray() {
    	showOwner();
        System.out.println("\n\n:: 주인 이름: " + this.owner);                
        System.out.println("총 음식량: " + getFoodAmount());     
    }
}
////////////////////////////////////////////////
public class MemberVarEx003 {
	   public static void main(String[] args) {
	        LunchTray tray1 = new LunchTray();   
	        tray1.showTray();                    
	        LunchTray.showTrayCount();         

	        LunchTray tray2 = new LunchTray();   
	        tray2.showTray();                   
	        LunchTray.showTrayCount();         
	   }
	} 

//////////////////////////////////////////////
/*
- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
	->인스턴스변수(heap): owner, rice, soup
	  클래스변수(method) : soup, totalFood, maxRice
	  지역변수(stack): tray1, tray2, args
	 
- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
	>인스턴스 메서드 : getFoodAmount(),showTray()
	 클래스 메서드 : showTrayCount(), showOwner()
	 
- 문제 3. 오류가 발생하는 이유를 설명하시오.
	->static은 this 사용 불가
	
- 문제 4. runtime data area 위치영역 그림그리기

------------------------[ runtime data area]
[method: 정보, static, final : 공용정보]
>class : LunchTray.class, MemberVarEx003.class
>static : soup, totalFood, maxRice,
			 showTrayCount(), showOwner()
------------------------------------
[heap: 동적]            | [stack : 잠깐빌리기]

2번지					<-tray2[2번지]
1번지					<-tray1[1번지]
						|main
------------------------------------

- 문제 5. 다음과 같이 출력되도록 코드를 작성하시오.
:: 주인 이름: std-1
총 음식량: 175
전체 급식판 수: 1


:: 주인 이름: std-2
총 음식량: 175
전체 급식판 수: 2

			초기값		명시적 초기화		초기화블록		생성자
/////////////////////////////////////////////////////////////////			
trayCount	0				0			x ->0		공용으로 생성자 관련x
maxRice		0				100			x ->100		생성자 안에서 클래스 변수 사용 가능
/////////////////////////////////////////////////////////////////			
owner		null		x -> null		x -> null	x -> null
rice		0				90			x -> 90		x -> 90
soup		0				85			x -> 85		x -> 85

*/