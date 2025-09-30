package com.company.java012_ex;

/*
 		Object
 		  ↑
 		 Papa{money = 10000, sing(GOD)}
 		  ↑
 		 Son{money = 1500, @sing(빅뱅)}-{money = 10000, ----}
 */

class Papa extends Object{  
	   int money = 10000;     
	   public Papa() { super(); }
	   public void sing() {  System.out.println("GOD-거짓말");  }
	}// end class

	class Son extends Papa{ 
	   int money = 1500;
	   public Son() { super(); }
	   @Override public void sing() {  System.out.println("빅뱅-거짓말"); }
	} // end class
////////////////////////////////////////////////////////	
	public class PolyEx004 {
	   public static void main(String[] args) { 
		   
	      Papa mypapa = new Son();    
	      // Q3. Papa mypapa 의미?
	      // 	>Papa{money = 10000, sing()} 사용 가능
	      //	>부모 = 자식 / 업캐스팅 / 타입캐스팅x 
	      // Q4. 인스턴스화한 실제 메모리 빌려온그림
	      //							   보장 범위 = 실제 생성 범위 
	      //	>mypapa : {money = 10000, sing()}  =  1000번지{money = 1500, [@sing(빅뱅)}-{money = 10000,] ---} <[여기만 만들어짐]
	      
	      System.out.println(mypapa.money); // Q5.  출력   >10000
	      mypapa.sing();  //Q6. 출력 >빅뱅-거짓말(오버라이드)
	      
	       //Q7. mypapa.money 를 이용해서  1500 출력되게 해주세요. 
	      System.out.println(((Son)mypapa).money);
//	      >mypapa : {money = 10000, sing()}  =  1000번지{money = 1500, [@sing(빅뱅)}-{money = 10000,] ---} <[여기만 만들어짐]
//												근데 	 money = 1500, 이건 청소한 채로 남아 있어서 타입캐스팅으로 사용 가능!     		

	      	
	   }
	}
