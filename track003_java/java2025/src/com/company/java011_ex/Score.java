package com.company.java011_ex;

public class Score{
	   private String name;
	   private int kor, eng, math , total;
	   private double aver;
	   private String p  , s  , rank;
	  
	   
	   public Score() { super();  }

	   public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	   //상태 확인
	   @Override
	   public String toString() {
		return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", total=" + total
				+ ", aver=" + aver + ", p=" + p + ", s=" + s + ", rank=" + rank + "]";
	   }


	   public String getName() { return name; }   
	   public void setName(String name) { this.name = name; }   
	   public int getKor() { return kor; }   
	   public void setKor(int kor) { this.kor = kor; }   
	   public int getEng() { return eng; }   
	   public void setEng(int eng) { this.eng = eng; }   
	   public int getMath() { return math; }  
	   public void setMath(int math) { this.math = math; }  
	   public int getTotal() { return total; }   
	   public void setTotal(int total) { this.total = total; }   
	   public double getAver() { return aver; }   
	   public void setAver(double aver) { this.aver = aver; }   
	   public String getP() { return p; }   
	   public void setP(String p) { this.p = p; }   
	   public String getS() { return s; }   
	   public void setS(String s) { this.s = s; }  
	   public String getRank() { return rank; }   
	   public void setRank(String rank) { this.rank = rank; } 
	   
	   
	   public static void info() {
		   System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

		   System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t\n", 
				   "이름","국어","영어","수학","총점","평균","합격여부","장학생","랭킹");

		   System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	   }
	   
		public String rank(double aver) {
			String result = "";
			for (int i = 0; i < (int) (aver*0.1); i++) {
				result+="*";
			}return result;
		} 
		
	   public void show() {
		   
		    this.total = this.kor+this.math+this.eng;
		    this.aver = this.total/3.0;
		    this.p = aver<60? "불합격" : "합격";
		    this.s = aver<90? "장학생" : "-";
		    this.rank = rank(aver);

		    
		    
		   System.out.printf("%-5s\t%-5d\t%-5d\t%-5d\t%-5d\t%-5.2f\t%-5s\t%-5s\t%-5s\n", 
				   this.name, this.kor, this.eng, this.math, this.total, this.aver, this.p, this.s, this.rank);
	   }
	   
//	   iron   100   100   100   300   100.00   합격   장학생   **********
	   

}
