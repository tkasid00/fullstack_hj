package com.company.java011_ex;
/*클래스 재사용(상속)

 Object		{		}					 				Object
	↑														↑
 Grand	{one(), two()}				   					Uncle, Ant
	↑					 ↑	
 Father	{three()}		Uncle{one(), two(), four()}

*/


class Grand extends Object {
    public Grand() { super(); }
    
	public void one() { System.out.println("grand : one"); }
    public void two() { System.out.println("grand : two"); }
}

class Father extends Grand{
	public Father() { super(); }
	
	public void three() { System.out.println("Father : three"); }
}

class Uncle extends Grand{
	public Uncle() { super(); }
	
	public void four() { System.out.println("uncle : four"); }
	@Override public void one() { System.out.println("uncle : one"); }
	@Override public void two() { System.out.println("uncle : two"); }

}
class Aunt extends Object{
 public Aunt() { super();  }	
 
 String name="mimi";

 @Override   //Object
 public String toString() { return "Aunt [name=" + name + "]"; }
}

/////////////////////////////////////////////////
public class ClassEx003 {

	public static void main(String[] args) {
		Father father = new Father();
		father.one(); father.two(); father.three();
		Uncle uncle = new Uncle();
		uncle.four(); uncle.one(); uncle.two();
		
		//Q1. uncle이 쓸 수 있는 메서드는?
		//>one(), two(), four()
		//Q2. 49번째줄에서 출력되는 내용은?
		//>uncle : four
		//uncle : one
		//uncle : two
		//Q3. 30,31의 개념은?
		//>@Override : 상속 시 부모와 같은 메서드를 자식에게 맞게 수정해서 사용
	}

}
//////////////////////////////////////////////	