package com.company.java011;
import com.company.java011_ex.Pet;
public class PetMoodEx {

	   public static void main(String[] args) {  
		      Pet kong = new Pet();       
		      Pet nabi = new Pet("나비", 10, 1, 2);    

		      // Pet.info()위에 메서드작성해주세요!  ##  
		      // setter를 이용해주세요!  
		      kong.setName("콩이"); kong.setWalkTime(60); kong.setSnackCount(3); kong.setCuddleCount(10);  

		      Pet.info();     // 클래스메서드  
		      kong.show();          
		      nabi.show();   
		   }  
		}