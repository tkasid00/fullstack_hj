package com.company.java009_ex;
class Score{
	
	   String stdid; 
	   int kor,eng,math; 
	   int total,avg;
   
  public Score() { super();  }  

	   void total() {System.out.print((kor+eng+math) + "\t");}	   
	   void avg() {	System.out.printf("%.2f", (kor+eng+math)/3.0);}

	   void info() {
		   System.out.print(stdid+"\t"+kor+"\t"+eng+"\t"+math+"\t");
		   total();  avg();
	   }
		
		public Score(String stdid, int kor, int eng, int math) {
			super();
			this.stdid = stdid;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
	}

///////////////////////////////////////
public class ClassEx006 {
		public static void main(String[] args) {
			   Score  s1= new Score("std1234" , 100, 100 , 99 ); 
			   s1.info();
			   }
			}