package com.company.java011_ex;

public class Pet{  
	   private String name;  
	   private int walkTime, snackCount, cuddleCount, moodScore;  
	   private String snackStars, tailWag, todayMessage;
	   
	   //2
	   public Pet() { super();  }

	   //3
	   public Pet(String name, int walkTime, int snackCount, int cuddleCount) {
			super();
			this.name = name;
			this.walkTime = walkTime;
			this.snackCount = snackCount;
			this.cuddleCount = cuddleCount;
		}


	   //4
	   @Override
	   public String toString() {
		return "Pet [name=" + name + ", walkTime=" + walkTime + ", snackCount=" + snackCount + ", cuddleCount="
				+ cuddleCount + ", moodScore=" + moodScore + ", snackStars=" + snackStars + ", tailWag=" + tailWag
				+ ", todayMessage=" + todayMessage + "]";
	   }

	  
	   //g+s
	   public String getName() { return name; } 
	   public void setName(String name) { this.name = name; }  
	   public int getWalkTime() { return walkTime; }  
	   public void setWalkTime(int walkTime) { this.walkTime = walkTime; }  
	   public int getSnackCount() { return snackCount; }  
	   public void setSnackCount(int snackCount) { this.snackCount = snackCount; }  
	   public int getCuddleCount() { return cuddleCount; }  
	   public void setCuddleCount(int cuddleCount) { this.cuddleCount = cuddleCount; }  
	   public int getMoodScore() { return moodScore; }  
	   public void setMoodScore(int moodScore) { this.moodScore = moodScore; }  
	   public String getSnackStars() { return snackStars; }  
	   public void setSnackStars(String snackStars) { this.snackStars = snackStars; }  
	   public String getTailWag() { return tailWag; }  
	   public void setTailWag(String tailWag) { this.tailWag = tailWag; }  
	   public String getTodayMessage() { return todayMessage; }  
	   public void setTodayMessage(String todayMessage) { this.todayMessage = todayMessage; }
	   
	   
	   
	   
	   //
	   public static void info() {
		   System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

		   System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t\t%-5s\n", 
				   "이름","산책시간","간식개수","쓰다듬횟수","행복도","간식보상","꼬리흔들기","오늘의멘트");

		   System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	   }
	   
	   
	   public void show() {
		   
			this.moodScore = walkTime + (snackCount * 10) + (cuddleCount * 5);
			this.snackStars= this.moodScore>=90? "★★★★★" :this.moodScore>=80? "★★★★" : this.moodScore>=70? "★★★" : this.moodScore>=60?  "★★":  "★";
			this.tailWag= this.moodScore>=90? "흔들흔들흔들" : this.moodScore>=60? "흔들흔들": this.moodScore>=40? "살짝 흔들" :"꼬리 내림";
			this.todayMessage=this.moodScore>=90? "오늘은 정말 행복했어요!" : this.moodScore>=60? "좋은 하루였어요!": this.moodScore>=40? "조금 더 놀아줘요!" :"외로웠어요...";	
		   
		   System.out.printf("%-5s\t%-5d\t%-5d\t%-5d\t%-5d\t%-5s\t%-5s\t\t%-5s\n", 
				   this.name, this.walkTime, this.snackCount, this.cuddleCount, this.moodScore, this.snackStars, this.tailWag, this.todayMessage);
	   }
	   

	   
	} // java011_ex에 설정해주세요!