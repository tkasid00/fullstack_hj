## 📚 day027 복습 


# ■ JAVA
# ■ JAVA 복습문제
Q1. 다음의 상속도를 그리시오.
Q2. 상속도에서  각각의 클래스에서 사용가능한 멤버변수/멤버함수를  적으시오.

abstract class Animal{    
	String name; 
	abstract void eat();   
	abstract void sleep(); 
	abstract void poo();  
}
class Cat  extends Animal{  // 구현클래스 - 고양이는 동물이다
	@Override void eat()   {  System.out.println(super.name + "고양이 냠냠!");  }
	@Override void sleep() {  System.out.println(super.name + "고양이 수면!");  }
	@Override void poo()   {  System.out.println(super.name + "고양이 시원");  }
}
class Dog  extends Animal{  // 구현클래스 - 강아지는 동물이다
	@Override void eat()   {  System.out.println(super.name + "강아지 냠냠!");  }
	@Override void sleep() {  System.out.println(super.name + "강아지 수면!");  }
	@Override void poo()   {  System.out.println(super.name + "강아지 시원");  }
}
public class Abstract001 {
	public static void main(String[] args) {
		//1. abstract  class : 일반클래스 + 설계
		Animal ani = new Animal();   Q3. 이코드에서 오류나는 이유는? 
	 
		Animal ani = null;
		ani = new Cat();   //Q4. 다형성에서 다음을 뭐라하는가?   업캐스팅/다운캐스팅? , 타입캐스팅 필요여부
		ani.name = "sally";   ani.eat();
 
		
		//2. 사용목적
		Animal [] arr = {new Cat() , new Cat() , new Dog() , new Dog() , };
		int cnt=0;
		//Q5.  다음이 출력되게 코드를 작성하시오.
		/*ani1고양이 냠냠!
		  ani2고양이 냠냠!
		  ani3강아지 냠냠!
		 ani4강아지 냠냠!   */
	}
}


>>>>>>>>>>>>>>>>> Answer
```
/* Q1,Q2
	    Object  
      	↑
	     Animal {name / eat(), sleep(), poo() }
	     ↑   ↑ 
	    Cat  Dog  { @eat(), @sleep(), @poo() }
*/

abstract class Animal{   //일반클래스 + 설계
	String name; 
	abstract void eat();  // 추상메서드가 있으면 반드시 추상클래스로 만들어줘야함.
	abstract void sleep();// 구현부가 없음 {}
	abstract void poo();  // 추상화, 일반화, 설계: 공통의 속성, 구체적인 내용이 없음
}
class Cat  extends Animal{  // 구현클래스 - 고양이는 동물이다
	@Override void eat()   {  System.out.println(super.name + "고양이 냠냠!");  }
	@Override void sleep() {  System.out.println(super.name + "고양이 수면!");  }
	@Override void poo()   {  System.out.println(super.name + "고양이 시원");  }
}
class Dog  extends Animal{  // 구현클래스 - 강아지는 동물이다
	@Override void eat()   {  System.out.println(super.name + "강아지 냠냠!");  }
	@Override void sleep() {  System.out.println(super.name + "강아지 수면!");  }
	@Override void poo()   {  System.out.println(super.name + "강아지 시원");  }
}
public class Abstract001 {
	public static void main(String[] args) {
		//1. abstract  class : 일반클래스 + 설계
		// Animal ani = new Animal();   Q3 new 메모리빌리고,객체생성/ Animal()초기화, {}구현부없음
		// 
		Animal ani = null;
		ani = new Cat();   // Q4. 부모 = 자식 , 업캐스팅, 타입캐스팅 필요없음
		ani.name = "sally";   ani.eat();

		ani = new Dog();   // 부모 = 자식 , 업캐스팅, 타입캐스팅 필요없음
		ani.name = "alpha";   ani.eat();
		
		//2. 사용목적
		Animal [] arr = {new Cat() , new Cat() , new Dog() , new Dog() , };
		int cnt=0;
		//Q5
      for(Animal a :  arr) {  a.name = "ani" + ++cnt;  a.eat();  }
	}
} 
```