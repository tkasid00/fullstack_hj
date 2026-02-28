## 📚 day025 복습   

# ■ JAVA
# ■ JAVA 복습문제
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
Q1. 다음과 같이 코드를 작성하시오.

public class ClassArrEx1{
  public static void main(String[] args) {
        Apple[] apples= new Apple[3]; 
        // 화면처럼 값 셋팅
        // 화면처럼 출력
  }
}

ㅁ출력된 화면
Apple [name=RED, order=iron, num=2, price=1000]
Apple [name=GREEN, order=hulk, num=1, price=1500]
Apple [name=GOLD, order=captain, num=3, price=2000]

```java
     
        
        Apple[] apples= new Apple[] { 
        		new Apple("RED" , "iron" , 2 , 1000) ,  new Apple("GREEN" , "hulk" , 1 , 1500)
        		,new Apple("GOLD" , "captain" , 3 , 2000)
        };

      for( Apple   a  :  apples ) { System.out.println(a);  }
```




Q2. 상속도를 달고 다음에 답변을 달으시오.   

 class Grand extends Object {
    public void one() { System.out.println("Grand : one"); }
    public void two() { System.out.println("Grand : two"); }
}
class Father extends Grand {
    public void three() { System.out.println("Father : three"); }
}
class Uncle extends Grand{
    public void four(){ System.out.println("Uncle : four"); }
    @Override public void one() { System.out.println("Uncle : one"); }  ##
    @Override public void two() { System.out.println("Uncle : two"); }  ##
}
 
public class ClassEx003 {
	public static void main(String[] args) {
		Father papa  = new Father(); papa.one();   papa.two();  papa.three();
		Uncle  uncle = new Uncle(); uncle.four();  uncle.one();  uncle.two();  
		//Q1. uncle이 쓸수 있는 메서드는?      
		//Q2. 24번째줄에서 출력되는 내용은?   
		//Q3.  개념은?  
	}
}

```
		//Q1. uncle이 쓸수 있는 메서드는?      Uncle { one() ,two() ,four()  } →   Grand{ one() ,two()  }
		//Q2. 24번째줄에서 출력되는 내용은?   Uncle { @one() ,@two() ,four()  } →   Grand{ one() ,two()  }
		//Q3.  개념은? 오버라이딩: 상속시 부모와 같은 메서드를 자식클래스에 맞게 수정한것!
```