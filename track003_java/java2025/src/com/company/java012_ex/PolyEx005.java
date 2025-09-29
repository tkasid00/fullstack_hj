package com.company.java012_ex;

/*
	Object
	  ↑
	 Parent7{x = 100, method()}
	  ↑
	 Child7{x = 200, @method()} - {x = 100, ---- }
*/

class Parent7  extends Object{
	   int x = 100;
	   public Parent7() { super(); }
	   void method() { System.out.println("Parent Method"); }
	} 
	class Child7 extends Parent7 {
	   int x = 200;
	   public Child7() { super(); }
	   @Override  void method() { System.out.println("Child Method"); }
	}
////////////////////////////////////////////////////////////////////////////	
	public class PolyEx005 {
	   public static void main(String[] args) {
	      Parent7 p = new Child7();     
	      // Q3.  Parent7 p   보장하는 범위   
	      //	>Parent7{x = 100, method()}
	      // Q4. 인스턴스화 했을때 사용가능한 범위 : new Child7()  
	      //	>@method(), x = 100
	      
	                            Child7 c = new Child7();     
	      System.out.println("p.x = " + p.x);  // Q5. 출력되는 내용   > p.x = 100
	      p.method();  // Q6. 출력되는 내용     >Child Method(오버라이드)
	      System.out.println("c.x = " + c.x);   // Q7. 출력되는 내용  >c.x = 200
	      c.method();   // Q8. 출력되는 내용   >Child Method
	   }
	}