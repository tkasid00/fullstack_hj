## 📚 day028 복습 



# ■ JAVA
# ■ JAVA 복습문제
복습문제1)  [note]  이론  
```
1. interface의 멤버변수는 __(1)__이고, 멤버함수는 __(2)__로 이루어진 설계 클래스이다.
2. abstract와 interface의 차이점은 __(3)__의 정도인데, __(4)__가 더 크다.
3. 콜렉션 프레임워크는 __(5)__의 단점을 보완하고자 나온 __(6)__이다.
4. List의 특징은 __(7)__이 있고, __(8)__이 가능하다.
5. 사용할 수 있는 메서드의 종류는 __(9)__, __(10)__, __(11)__, __(12)__, __(13)__이다.
```

```
1. interface의 멤버변수는 __(1) 상수__이고, 멤버함수는 __(2) 추상메서드__로 이루어진 설계 클래스이다.
2. abstract와 interface의 차이점은 __(3) 추상화__의 정도인데, __(4) interface__가 더 크다.
3. 콜렉션 프레임워크는 __(5) 배열__의 단점을 보완하고자 나온 __(6) 동적배열__이다.
4. List의 특징은 __(7) 순번(index)__이 있고, __(8) 중복허용__이 가능하다.
5. 사용할 수 있는 메서드의 종류는 __(9) add__, __(10) get__, __(11) size__, __(12) remove__, __(13) contains__이다.
```


복습문제2) [note]
Q1. 상속도를 그리시오.
Q2. Driver 클래스를 작성하시오.  
interface Vehicle {
	public void run();
} 
class MotorCycle implements Vehicle {
	@Override
	public void run() {
		System.out.println("오토바이가 달립니다.");
	}
}
class Car implements Vehicle {
	@Override
	public void run() {
		System.out.println("자동차가 달립니다.");
	}
}
public class Oop014_method_polymorphism {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Car car = new Car();
		MotorCycle mo = new MotorCycle();
		
		driver.drive(car);   // 자동차가 달립니다.
		driver.drive(mo);  // 오토바이가 달립니다.
	} 
}
 
```
class Driver{   void  drive(Vehicle  v){  v.run();  }  }
```


복습문제3) [eclipse]
클래스명 : Repeat029
다음과 같이 코드를 작성하시오.
 1.  ArrayList이용해서 colors 만들기
 2. red, green, blue 데이터 추가
 3. 출력

```
public class ListEx001 {
	public static void main(String[] args) {
		 List<String> colors = new ArrayList<>();
		 colors.add("red");
		 colors.add("green");
		 colors.add("blue"); 
		 
		 System.out.println( colors); 
	}
}
```
