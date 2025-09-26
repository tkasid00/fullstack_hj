package com.company.java011_ex;

/*클래스 재사용(상속)
 
 Object		{		}
 	↑
MobileNote	{show()}
 	↑
MobileNote7	{iris, face / newShow()}
 	↑
MobileNote8 {@face / @newShow()}
 	↑
MobileNote9 {battery / @newShow()}

-------------------------------------------
MobileNote9 my9 = new MobileNote9();
-------------------------------------------
1. MobileNote9은 MobileNote이다.
2. 생성자 호출 순서 : MobileNote9() -> MobileNote8() -> MobileNote7() -> MobileNote() -> Object()
3. 객체 생성 순서 : Object -> MobileNote -> MobileNote7 -> MobileNote8 -> MobileNote9
	3번지 : {battery / @newShow()} - {@face / @newShow()} - {iris, face / newShow()}- {show()}

Q.8과 7의 newShow 호출 방법은?

-------------------------------------------
MobileNote8 my8 = new MobileNote8();
-------------------------------------------
1. MobileNote8은 MobileNote이다.
2. 생성자 호출 순서 : MobileNote8() -> MobileNote7() -> MobileNote() -> Object()
3. 객체 생성 순서 : Object -> MobileNote -> MobileNote7 -> MobileNote8
	2번지 : {@face / @newShow()} - {iris, face / newShow()}- {show()}
	오버라이딩 : 상속 시 부모와 같은 메서드를 자식에게 맞게 수정해서 사용
-------------------------------------------
MobileNote7 my7 = new MobileNote7();
-------------------------------------------
1. MobileNote7은 MobileNote이다.
2. 생성자 호출 순서 : MobileNote7() -> MobileNote() -> Object()
3. 객체 생성 순서 : Object -> MobileNote -> MobileNote7
	1번지 : {iris, face / newShow()} - {show()}
	
-------------------------------------------


 */

import java.util.Arrays;

class MobileNote{
	 public MobileNote() { super(); }
	 
	 void show() {System.out.println("MobileNote 입니다");}
}//MobileNote

class MobileNote7 extends MobileNote {
	private String iris;
	private String face; 

	 public MobileNote7() { super();  }

	 public MobileNote7(String iris, String face) { super(); this.iris = iris; this.face = face; }

	 @Override
	 public String toString() {
		return "MobileNote7 [iris=" + iris + ", face=" + face + "]";
	 }

	 public String getIris() { return iris; }  public void setIris(String iris) { this.iris = iris; }  
	 public String getFace() { return face; }  public void setFace(String face) { this.face = face; } 
	 
	 void newShow() {
		 System.out.println("\nNOTE7 객체 기능(Overriding)");
		 System.out.println("iris=" + this.iris);
		 System.out.println("face=" + this.face );
	 }

}//MobileNote7

class MobileNote8 extends MobileNote7 {
	private String face; 
	
	public MobileNote8() { super();  }	
	public MobileNote8(String face) { super(); this.face = face; }
	
	
	@Override
	void newShow() { 
		 super.newShow();
		 System.out.println("\nNOTE8 객체 기능(syOverriding) 추가");
		 System.out.println("iris=" + this.getIris());
	}

//	 void newShow() {
//		 System.out.println("NOTE8 객체 기능(syOverriding) 추가");
//		 System.out.println("iris=" + this.getIris());
//
//	 }
}//MobileNote8
class MobileNote9 extends MobileNote8 {
	private int battery;

public MobileNote9() { super();  }
public MobileNote9(int battery) { super(); this.battery = battery; }
public int getBattery() { return battery; } public void setBattery(int battery) { this.battery = battery; }

@Override
	public String toString() {
		return "MobileNote9 [battery=" + battery + "]";
	}
@Override

void newShow() {
	super.newShow();
	 
	 System.out.println("\nNOTE9 객체 기능(Overriding) 추가");
	 System.out.println("battery 예쁘게 사용하기!");
	 System.out.println("battery=" + this.getBattery());
	
}

}//MobileNote9

/////////////////////////////////////////////
public class ClassEx002 {

    public static void main(String[] args) {
//        MobileNote7 my7 = new MobileNote7();
//        my7.setIris("brown");
//        my7.setFace("pretty");
//        my7.newShow();
//
//        MobileNote8 my8 = new MobileNote8();
//        my8.setFace("pretty");
//        my8.newShow();
//
//        MobileNote9 my9 = new MobileNote9();
//        my9.setBattery(24);
//        my9.newShow();
    	
      MobileNote9 my92 = new MobileNote9();
      my92.setIris("black");
      my92.setFace("cuty");
      my92.setBattery(24);
      my92.newShow();
    	
    }
}


