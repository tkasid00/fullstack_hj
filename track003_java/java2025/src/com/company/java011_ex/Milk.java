package com.company.java011_ex;
//public(어디서든지) > protected(상속extends) > package(default, 폴더) > private(클래스 내부)  

public class Milk{  // java011_ex에 설정해주세요!
	   private int  mno;   
	   private String mname;  
	   private  int mprice;
	   //alt+shift+s(2,3,4/getters+setters)

	   
	   public Milk() { super();  }
	   
	   
	   public Milk(int mno, String mname, int mprice) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.mprice = mprice;
	   }

	   
	   @Override
	   public String toString() {
		return "Milk [mno=" + mno + ", mname=" + mname + ", mprice=" + mprice + "]";
	   }

	   public int getMno() { return mno; }  
	   public void setMno(int mno) { this.mno = mno; }  
	   public String getMname() { return mname; }  
	   public void setMname(String mname) { this.mname = mname; }  
	   public int getMprice() { return mprice; } 
	   public void setMprice(int mprice) { this.mprice = mprice; } 

	   
	}