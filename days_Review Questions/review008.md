## 📚 day007복습  

■ 복습문제
복습문제1) 
1. 자바의 자료형은 (     /     )
2. 자바 기본형의 분류는 - boolean ,  (     )  , (    )
3. 정수형의 종류는(   ,   ,   ,   )    
4. 실수형의 종류는(   ,    )    


복습문제2)  다음코드에 문제가 있다. 이유를 적고 해결하시오.
short sh1 = 1;
short sh2 = 2;
short result = sh1 + sh2;  


복습문제3)  eclipse
패키지명 : com.company.java003_ex
클래스명 : CastingEx001
출력내용 :  Scanner이용해서 나누기 프로그램만들기 
   숫자입력1>  _입력받기  10   ( ☆자료형을 int )
   숫자입력2>  _입력받기  3     ( ☆자료형을 int )              
   
   10 / 3 = 3.33




■ 복습문제 -  answer

복습문제1)
1. 자바의 자료형은기본형(Primitive Type) / 참조형(Reference Type)  
2. 자바 기본형의 분류는 - boolean,정수형,실수형  
3. 정수형의 종류는byte, short, int, long  
4. 실수형의 종류는float, double


복습문제2)
```java
short sh1 = 1;
short sh2 = 2;
short result = sh1 + sh2;
```

###  문제점
자바에서는short + short` 연산 결과가자동으로 int 타입으로 변환됩니다. 
따라서sh1 + sh2`는int` 타입이 되고, 
이를short` 타입 변수에 저장하려고 하면컴파일 오류가 발생합니다.

###   해결 방법
명시적 형 변환(casting)을 사용해야 합니다:

short result = (short)(sh1 + sh2);
 

복습문제3)  eclipse
패키지명 : com.company.java003_ex
클래스명 : CastingEx001
출력내용 :  Scanner이용해서 나누기 프로그램만들기 
   숫자입력1>  _입력받기  10   ( ☆자료형을 int )
   숫자입력2>  _입력받기  3     ( ☆자료형을 int )              
   
   10 / 3 = 3.33

```java
package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자입력1> ");
        int num1 = scanner.nextInt();

        System.out.print("숫자입력2> ");
        int num2 = scanner.nextInt();

        double result = (double) num1 / num2;

        System.out.printf("%d / %d = %.2f\n", num1, num2, result);
    }
}
```

### 🧾 출력 예시
```
숫자입력1> 10  
숫자입력2> 3  
10 / 3 = 3.33
```
 