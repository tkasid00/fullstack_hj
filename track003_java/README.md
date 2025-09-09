# 🚀 박현주 | 실전 프로젝트 중심 풀스택 포트폴리오

> 코드를 넘어 흐름을 설계하는 개발자.  
**기획 → 구현 → 배포**, 전 과정을 주도한 실전형 풀스택 포트폴리오

***문제 해결 중심 사고**와 **협업 경험**으로  
실무에 가까운 프로젝트를 직접 구현했습니다.*

---
<!-- 이름, 이메일, 깃허브 주소, 포트폴리오 2*4의 테이블 형식으로-->
## 💡Contact & Links
<img src="../track001_github/3319946_수정.gif" alt="프로필" width="100"/>

|||
|-|-|
|**NAME**|박현주|
|**EMAIL**|tkasid00@gmail.com|
|**GITHUB**|https://github.com/tkasid00/fullstack_hj|


---
## ✨Golds (Java)

- 자바의 핵심 문법과 객체지향 프로그래밍 원리를 이해하고 실습을 통한 개발 역량 강화
- 다양한 자료구조와 알고리즘을 활용하여 문제 해결 능력 향상
- 예외 처리, 파일 입출력, 컬렉션 등 실무에서 자주 사용하는 기능을 직접 구현한 경험
- 협업 프로젝트에서 GitHub를 활용한 버전 관리 및 코드 리뷰 경험
- 코드 품질 향상을 위한 테스트 및 디버깅 역량 강화


---
✔기술 스택 기반 CS 역량
---


## 😱트러블슈팅(Java 발생)

<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅01(; 누락 오류)</summary>

**[문제점]**  
- 코드 실행 시 Syntax error, insert ";" to complete Statement라는 컴파일 오류 발생.

**[오류 코드]**  
  ```java
  System.out.println("Hello World!")
  ```

**[원인 분석]**  
- 세미콜론(;)이 빠져 있어 문장이 완결되지 않음.

**[해결 방안]**  
- 아래와 같이 수정함.
  ```java
  System.out.println("Hello World!");
  ```

**[느낀점]**  
- 기본적인 문법 실수 하나가 전체 프로그램 실행을 막을 수 있다는 점을 실감함.
- 엄격한 문법 규칙을 가진 언어에서는 세미콜론 하나도 놓치지 않는 꼼꼼함이 중요. 
</details>




<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅02(System.out.println 문법 오류)</summary>

**[문제점]**  
- `System.out.println(  10 , "+" , 3 , "=" , (10+3)  );` 코드에서 컴파일 오류가 발생함.

**[해결 방안]**  
- `System.out.println`은 인자를 하나만 받을 수 있으므로, 여러 값을 출력하려면 문자열 연결(`+`)을 사용해야 함.
- 아래와 같이 수정:
  ```java
  System.out.println(10 + " + " + 3 + " = " + (10 + 3));
  ```

**[느낀점]**  
- 자바의 출력문은 인자 개수에 제한이 있으므로, 여러 값을 출력할 때는 반드시 문자열 연결을 사용해야 함을 알게 됨.
- 기본 문법을 정확히 이해하고 사용하는 것이 중요함을 다시 한 번 인식함.
</details>




<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅03(char 타입 연산 오류)</summary>

**[문제점]**  
- 자바에서 1 + 2 = 3을 출력하려 했으나 실제 출력 결과는 1+2로 나타남. 
  덧셈 결과가 출력되지 않고 단순히 숫자와 연산자가 이어진 문자열처럼 보임.

**[오류 코드]**  
```java
int num1 = 1;
int num2 = 2;
char ch1 = '+';

System.out.println(num1 + (char)ch1 + num2);
```

**[원인 분석]**  
- (char)ch1은 '+' 문자로 변환되지만 자바에서 int + char 연산은 문자 코드값을 기준으로 덧셈이 수행됨.
  따라서 '+'의 아스키 값은 43이므로 46으로 출력됨.
- 그래서 (char)로 강제 형 변환을 시도한 결과 숫자+문자+숫자 출력으로 단순 문자열 나열이 되어 1+2의 출력값을 얻음.

**[해결 방안]**  
- 아래와 같이 result 값을 새로 만들고 if를 통안 출력 처리를 함.
  ```java
  String result;
  if(ch1=='+') {result += (num1+num2);}
  ```

**[느낀점]**  
- 조건문과 문자열 조합을 활용해 유연한 출력 로직을 구현할 수 있었고 타입 간 연산 방식에 대한 이해가 중요하다는 걸 배움.
- 기본 문법을 정확히 이해하고 사용하는 것이 중요함을 다시 한 번 인식함.
</details>



<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅04(데이터 타입 선택 오류)</summary>


**[문제점]**  
- 사용자로부터 "sud111" 같은 문자열을 입력받으려 했지만 char ch1 = scanner.next().charAt(0);를 사용하자 첫 글자인 's'만 저장되고 나머지는 무시됨.

**[오류 코드]**  
```java
  char ch1;
  System.out.print("학번을 입력하세요> ");
	ch1 = scanner.next().charAt(0);
```

**[원인 분석]**  
- charAt(0)은 입력받은 문자열의 첫 번째 문자만 추출함.
- "sud111"을 입력해도 ch1에는 's'만 저장됨.
- 전체 문자열을 저장하려면 char가 아닌 String 타입을 사용해야 함.

**[해결 방안]**  
- 아래와 같이 result 값을 새로 만들고 if를 통안 출력 처리를 함.
  ```java
  char ch1; -> String ch1
  ch1 = scanner.next();
  ```

**[느낀점]**  
- 입력 처리 시 데이터 타입 선택의 중요성을 실감함.
- 데이터 타입에 대한 명확한 개념 정리 필요성을 느낌.
</details>



<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅05(조건문 생략 문법 오류)</summary>

**[문제점]**  
- 두 번째 조건문에서 if 키워드를 생략하고 조건식만 사용하여 컴파일 오류 발생.

**[오류 코드]**  
```java

    int i, cnt = 0;
		String re = " ";

for (i = 1; i <= 10; i++) {
    if ((i % 3) == 0) {
        re += (i == 3 ? " " : ",") + i;
    }

    ((i % 3) == 0) { // ❌ 컴파일 에러 발생
        cnt++;
    }
}
```

**[원인 분석]**  
- Java에서는 조건식, + 블록만으로 실행 로직을 구성할 수 없음
- if나 while 등의 제어문 키워드가 필요.


**[해결 방안]**  
1) 조건 블록 앞에 if를 명시적으로 추가함으로써 컴파일 오류 해결:
```java
for (i = 1; i <= 10; i++) {
    if ((i % 3) == 0) {
        re += (i == 3 ? " " : ",") + i;
    }

    if ((i % 3) == 0) {
        cnt++;
    }
}
```

2) 초기 의도대로 두 개의 if문을 하나로 합쳐 조건을 한 번만 평가하도록 개선:
```java
for (i = 1; i <= 10; i++) {
    if ((i % 3) == 0) {
        cnt++;
        re += (i == 3 ? " " : ",") + i;
    }
}
```

**[느낀점]**  
- 초보자 입장에서 흔히 범할 수 있는 실수(조건식만 쓰고 블록 열기)를 통해, 기초 문법의 중요성을 실감.
- 대안적인 방법으로 if 블록을 통합하여 효율적으로 처리할 수 있다는 것도 함께 배움.
- 앞으로는 간단한 조건이라도 명확하게 if, else 등의 키워드를 사용하여 정적 분석기나 컴파일러가 이해할 수 있도록 코드를 작성하는 습관을 들일 것.
</details>

<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅06(전체 입력 반복 오류)</summary>

**[문제점]**  
- 2번 입력값(num2)이 유효하지 않을 경우 1번 입력부터 다시 받는 문제가 발생함

**[오류 코드]**  
```java
Scanner scanner = new Scanner(System.in); 
int num1, num2 = 0; 
char op = '\u0000'; 

for(;;) { System.out.print("1. 정수를 하나 입력해주세요 >"); 
              num1 = scanner.nextInt(); if(num1<0 || num1>100) {continue;} 
          System.out.print("2. 정수를 하나 입력해주세요 >"); 
              num2 = scanner.nextInt(); if(num2<0 || num2>100) {continue;} 
          System.out.print("3. 연산자를 입력해주세요(+,-,*,/) >"); 
            op = scanner.next().charAt(0); if(op=='+'|| op=='-'||op=='*'||op=='/'){continue;}
          break;}

```

**[원인 분석]**  
- for(;;) 루프 내에서 모든 입력(1, 2, 3)을 순차적으로 처리하고 있음.
- 각 입력값에 대해 유효성 검사를 한 후 continue를 사용했지만 모든 조건이 하나의 루프에 묶여 있어서 한 조건이 실패해도 루프가 처음부터 다시 시작됨.
- 이로 인해 이미 유효했던 입력값도 다시 입력하게 되는 UX 문제 발생.

**[해결 방안]**  
- 아래와 같이 수정함.
```java
for(;;) {
          if(!(num1 >=0 && num1<=100)) {System.out.print("1. 정수를 하나 입력해주세요 >"); 
                                        num1 = scanner.nextInt(); continue;} 
          if(!(num2 >=0 && num2<=100)) { System.out.print("2. 정수를 하나 입력해주세요 >"); 
                                        num2 = scanner.nextInt(); continue;} 
          if(!(op=='+'|| op=='-'||op=='*'||op=='/')) { System.out.print("3. 연산자를 입력해주세요(+,-,*,/) >"); 
                                        op = scanner.next().charAt(0); continue;}
          break;}
```

**[느낀점]**  
- continue는 루프 구조와 위치에 따라 원치 않는 흐름 제어를 초래할 수 있음.
- 유효성 검사 단계와 순서를 정확하게 파악하고 배치해야 함.
</details>



<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅07(== 연산자 논리 오류)</summary>

**[문제점]**  
- 입력받은 두 id값을 비교 중 항상 일치하는 결과 발생.

**[오류 코드]**  
  ```java
    if(id == id && pass == pass){ }
  ```

**[원인 분석]**  
- == 연산자는 문자열(String)에서는 주소(reference) 비교를 수행함.
- id와 pass가 String일 경우 ==은 우리가 원하는 값이 같은지를 판단하지 않고 객체가 같은 메모리를 참조하는지만 봄.

**[해결 방안]**  
- 각각 다른 String에 대입하는 방식을 사용하여 아래와 같이 수정함.
  ```java
  if(tempid.equals(id) && temppass.equals(pass)){ }
  ```

**[느낀점]**  
- ==과 .equals()의 차이를 명확히 이해하는 것이 Java 프로그래밍에서 매우 중요함.
- 논리 오류는 눈에 잘 띄지 않지만 프로그램의 의도를 완전히 벗어날 수 있어 코드에 대한 확실한 이해가 필요함.
</details>



<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅08(nextInt() 버퍼 오류)</summary>

**[문제점]**  
- id 입력을 건너뛰는 현상 발생

**[오류 코드]**  
```java
  a = sc.nextInt(); 
         
  switch(a) {
    case 1 :
        System.out.print("아이디 입력 : ");
        id = sc.nextLine(); 
        System.out.print("비밀번호 입력 : ");
        pw = sc.nextLine();}

  ```

**[원인 분석]**  
- Scanner의 nextInt()는 숫자만 읽고 줄바꿈 문자(엔터)는 버퍼에 남겨둠.
- 이후 nextLine()을 호출하면 남아 있는 엔터가 그대로 읽혀져 입력을 받지 않고 넘어가게 됨.

**[해결 방안]**  
- 1) next() 사용
  ```java
  System.out.print("아이디 입력 : ");
  id = sc.next();
  System.out.print("비밀번호 입력 : ");
  pw = sc.next();
  ```

- 2) 버퍼 비우기 : nextLine() 앞에 nextLine() 한 번 더 호출. 
  ```java
  a = sc.nextInt();
  sc.nextLine();

  System.out.print("아이디 입력 : ");
  id = sc.nextLine();
  System.out.print("비밀번호 입력 : ");
  pw = sc.nextLine();
  ```

**[느낀점]**  
- nextInt() → nextLine() 전환 시 항상 버퍼 정리를 신경 써야 함.
- 눈에 띄지 않는 줄바꿈 문자 하나가 입력 로직을 완전히 망가뜨릴 수 있음.
- 입력 타입이 섞일 경우 입력 흐름을 명확히 파악하고 테스트하는 습관이 중요함.

---

## ✔참고문헌
