package com.company.java011_ex;

import java.util.Arrays;

////////////////////////////////////////////////////////
public class ClassArrEx1 {

	 public static void main(String[] args) {
		 
		 	//방법1
	        Apple[] apples= new Apple[] {
	        		
	        		new Apple("RED", "iron", 2, 1000),
	        		new Apple("GREEN", "hulk", 1, 1500),
	        		new Apple("GOLD", "captain", 3, 2000),
	        }; 
	        //일반 for
	        for(int i=0;i<apples.length;i++) {
	        	System.out.println(apples[i]);
	        }
	        //향상된 for 
	        //한개씩 : 베열, 객체명	
	        for(Apple a : apples) {System.out.println(a);}	
	        

	        // 방법2
	        Apple[] apples2 = new Apple[3];
	        
	        apples2[0] = new Apple("RED", "iron", 2, 1000);
	        apples2[1] = new Apple("GREEN", "hulk", 1, 1500);
	        apples2[2] = new Apple("GOLD", "captain", 3, 2000);

	        System.out.println(apples[0]);
	        System.out.println(apples[1]);
	        System.out.println(apples[2]);
	        
	        //방법 3
	        Apple[] apples3 = new Apple[] {
	        		new Apple("RED", "iron", 2, 1000),
	        		new Apple("GREEN", "hulk", 1, 1500),
	        		new Apple("GOLD", "captain", 3, 2000)
	        };
	        System.out.println(Arrays.toString(apples3));
	        
	  }
}
/////////////////////////////////////////////////////