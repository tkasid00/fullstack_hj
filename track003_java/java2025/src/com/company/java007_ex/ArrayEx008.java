package com.company.java007_ex;

public class ArrayEx008 {
	public static void main(String[] args) {
		
	    String[] name = {"아이언맨","헐크","캡틴","토르","호크아이"};
	    int[] kor={100,20,90,70,35};   
	    int[] eng={100,50,95,80,100};
	    int[] mat={100,30,90,60,100};
	    int[] aver=new int[5];
	    int[] total=new int[5];
	    String[] hap =  new String[5];
	    String[] jang =  new String[5];
	    int [] rank = {1,1,1,1,1};
	    
	 
	    
		for (int i = 0; i < name.length; i++) {
			total[i] = kor[i] + eng[i] + mat[i];
			aver[i] = total[i] / 3;
			hap[i] = aver[i] >= 60 ? "합격" : "불합격";
			jang[i] = aver[i] >= 95 ? "장학생" : "";
		}
	    
//	    for(i=0;i<name.length;i++){total[i] = kor[i] + eng[i] + mat[i];}
//	    for(i=0;i<name.length;i++) {aver[i] = total[i] / 3;}
//	    for(i=0;i<name.length;i++) {hap[i] = aver[i] >= 60? "합격":"불합격"; }
//	    for(i=0;i<name.length;i++) {jang[i] = aver[i] >= 95? "장학생":""; }

	    
	    //for(i=0;i<name.length;i++){
//	    	if(aver[0] < aver[1]) {rank[0]++;}
//			if(aver[0] < aver[2]) {rank[0]++;}
//			if(aver[0] < aver[3]) {rank[0]++;}
//			if(aver[0] < aver[4]) {rank[0]++;}
//			if(aver[0] < aver[0]) {rank[0]++;}
	    //						}
	    //
			
//			for(int i =0; i<aver.length;i++){if(aver[0] < aver[i]) {rank[0]++;}}
//			for(int i =0; i<aver.length;i++){if(aver[1] < aver[i]) {rank[1]++;}}
		
		for(int j =0; j<aver.length;j++){for(int i =0; i<aver.length;i++){if(aver[j] < aver[i]) {rank[j]++;}}}
			
	    
	    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	    System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\n", "이름","국어","영어","수학","평균", "합격여부","장학생", "랭킹" );
	    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	    for(int i=0;i<name.length;i++) {System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5d\n", name[i], kor[i], eng[i], mat[i], aver[i], hap[i] , jang[i], rank[i] );}
	    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

	    

	    
	    

		
		
	}
}
