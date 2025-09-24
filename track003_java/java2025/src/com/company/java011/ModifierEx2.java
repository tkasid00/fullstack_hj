package com.company.java011;

import com.company.java011_ex.Milk;

public class ModifierEx2{ // java011 패키지에 설정해주세요.
	   public ModifierEx2() { super(); }

	   public static void main(String[] args) {
	      Milk m1 = new Milk();  
	      System.out.println( m1 );  
	      m1.setMprice(2000);       
	      System.out.println( m1 );
	   } // end main
	} // end class
