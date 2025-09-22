package com.company.java009_ex;

import java.util.Scanner;

class AnimalCharacter {
    // 상태 - 멤버변수  
     String name;  
     String type;  // 육식 or 초식  
     int baseSpeed;  
     int specialBoost;  
     double finalSpeed;
     
    public AnimalCharacter() { super();  }
    
	 // 행위 - 멤버함수  
     void input() {
    	 Scanner scanner = new Scanner(System.in);
    	 
    	 System.out.print("동물을 입력하세요 : "); this.name=scanner.next();
    	 System.out.print("동물 타입을 선택하세요(육식/초식) : "); this.type =scanner.next();
    	 System.out.print("기본 속도를 입력하세요 : "); this.baseSpeed =scanner.nextInt();
    	 System.out.print("특수 능력치를 입력하세요(육식/초식) : "); this.specialBoost =scanner.nextInt();

     } //input
     void calculateSpeed() { 
    	 
    	 switch(type) {
    	 case "육식" : this.finalSpeed = this.baseSpeed + (this.specialBoost*0.2); break;
    	 case "초식" : this.finalSpeed = this.baseSpeed + (this.specialBoost*0.1); break;
    	 }
    		
     
     }//calculate
    	 
     	void show() {calculateSpeed();
     				System.out.printf("🦁 동물 캐릭터:%s\n🌿 타입:%s\n🚀 최종 속도:%.2f\n", this.name, this.type, this.finalSpeed);
     	}//show

		public AnimalCharacter(String name, String type, int baseSpeed, int specialBoost) {
			super();
			this.name = name;
			this.type = type;
			this.baseSpeed = baseSpeed;
			this.specialBoost = specialBoost;
		}
     	
}//class


////////////////////////////////////
public class ClassEx008 {
    public static void main(String[] args) {
        AnimalCharacter a1 = new AnimalCharacter("치타", "육식", 100, 30);
        a1.show();

        AnimalCharacter a2 = new AnimalCharacter();
        a2.input();
        a2.show();
    }
}
