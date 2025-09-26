package com.company.java011_ex;


/*
 Object										    *3. Object(){					} *4
 ↑
 Color 클래스 - 멤버 변수 : name (String, public), *2. Color(){	name=null, num=0	} *5
 						 num (int, private)
 ↑
 Green 클래스 - void show(){}						*1. Green(){	show()			} *6
 												*0. 1번지
 ----------------------------------------
 Green mygreen = new Green();
 ----------------------------------------
 1. Green은 Color이다, Green은 Object이다
 2. 생성자 호출 : Green() -> Color() -> Object()
 3. 객체 생성 : Object -> Color -> Green
 */


class Color{
	public String name;
	private int num;
	
	public Color() { super(); }

	public Color(String name, int num) { super(); this.name = name; this.num = num; }

	@Override
	public String toString() { return "Color [name=" + name + ", num=" + num + "]"; }

	public int getNum() { return num; }  
	public void setNum(int num) { this.num = num; }  
	
}

class Green extends Color{
		void show(){ 
			System.out.println("GREEN");
			System.out.println("NAME : " +this.name);
			System.out.println("NUM : " +this.getNum());
		}
}


public class ExtendsEx001 {

    public static void main(String[] args){
    	
        Green mygreen = new Green();
        mygreen.name = "LIGHT_GREEN";
        mygreen.setNum(5);
        mygreen.show();
    
    }
   
}

 