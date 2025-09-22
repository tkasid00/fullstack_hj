package com.company.java009_ex;
class Score1{
	
	   String stdid; 
	   int kor,eng,math; 
	   int total,avg;
   
  public Score1() { super();  }  

	   void total() {this.total= this.kor + this.eng+this.math;}	   
	   void avg() {	this.avg=this.total/3;}

	   void info() {
		   this.total(); this.avg();
		   System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t", "학번", "KOR", "ENG", "MATH", "TOTAL", "AVG");
		   
		   System.out.printf("\n%-5s\t%-5d\t%-5d\t%-5d\t%-5d\t%-5d\t", stdid, kor, eng, math, total, avg);
		   
	   }

	   public Score1(String stdid, int kor, int eng, int math) {
		super();
		this.stdid = stdid;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	   }
		
	}

///////////////////////////////////////
public class ClassEx006_02 {
		public static void main(String[] args) {
			   Score1  s1= new Score1("std1234" , 100, 100 , 99 ); 
			   s1.info();
			   }
			}