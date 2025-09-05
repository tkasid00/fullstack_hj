# 🚀 박현주 | 실전 프로젝트 중심 풀스택 포트폴리오

> 코드를 넘어 흐름을 설계하는 개발자.  
**기획 → 구현 → 배포**, 전 과정을 주도한 실전형 풀스택 포트폴리오

***문제 해결 중심 사고**와 **협업 경험**으로  
실무에 가까운 프로젝트를 직접 구현했습니다.*

---
<!-- 이름, 이메일, 깃허브 주소, 포트폴리오 2*4의 테이블 형식으로-->
## 💡Contact & Links
<img src="./track001_github/3319946_수정.gif"
    alt="프로필" width="100"/>

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

**문제점**  
- 코드 실행 시 Syntax error, insert ";" to complete Statement라는 컴파일 오류 발생.

**오류 코드**  
  ```java
  System.out.println("Hello World!")
  ```

**원인 분석**  
- 세미콜론(;)이 빠져 있어 문장이 완결되지 않음.

**해결 방안**  
- 아래와 같이 수정함.
  ```java
  System.out.println("Hello World!");
  ```

**느낀점**  
- 기본적인 문법 실수 하나가 전체 프로그램 실행을 막을 수 있다는 점을 실감함.
- 엄격한 문법 규칙을 가진 언어에서는 세미콜론 하나도 놓치지 않는 꼼꼼함이 중요. 
</details>




<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅02(System.out.println 문법 오류)</summary>

**▪문제점**  
- `System.out.println(  10 , "+" , 3 , "=" , (10+3)  );` 코드에서 컴파일 오류가 발생함.

**▪해결 방안**  
- `System.out.println`은 인자를 하나만 받을 수 있으므로, 여러 값을 출력하려면 문자열 연결(`+`)을 사용해야 함.
- 아래와 같이 수정:
  ```java
  System.out.println(10 + " + " + 3 + " = " + (10 + 3));
  ```

**▪느낀점**  
- 자바의 출력문은 인자 개수에 제한이 있으므로, 여러 값을 출력할 때는 반드시 문자열 연결을 사용해야 함을 알게 됨.
- 기본 문법을 정확히 이해하고 사용하는 것이 중요함을 다시 한 번 인식함.
</details>




<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅03(char 타입 연산 오류)</summary>

**문제점**  
- 자바에서 1 + 2 = 3을 출력하려 했으나 실제 출력 결과는 1+2로 나타남. 
  덧셈 결과가 출력되지 않고 단순히 숫자와 연산자가 이어진 문자열처럼 보임.

**오류 코드**  
```java
int num1 = 1;
int num2 = 2;
char ch1 = '+';

System.out.println(num1 + (char)ch1 + num2);
```

**원인 분석**  
- (char)ch1은 '+' 문자로 변환되지만 자바에서 int + char 연산은 문자 코드값을 기준으로 덧셈이 수행됨.
  따라서 '+'의 아스키 값은 43이므로 46으로 출력됨.
- 그래서 (char)로 강제 형 변환을 시도한 결과 숫자+문자+숫자 출력으로 단순 문자열 나열이 되어 1+2의 출력값을 얻음.

**해결 방안**  
- 아래와 같이 result 값을 새로 만들고 if를 통안 출력 처리를 함.
  ```java
  String result;
  if(ch1=='+') {result += (num1+num2);}
  ```

**느낀점**  
- 조건문과 문자열 조합을 활용해 유연한 출력 로직을 구현할 수 있었고 타입 간 연산 방식에 대한 이해가 중요하다는 걸 배움.
- 기본 문법을 정확히 이해하고 사용하는 것이 중요함을 다시 한 번 인식함.
</details>



<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅04(데이터 타입 선택 오류)</summary>


**문제점**  
- 사용자로부터 "sud111" 같은 문자열을 입력받으려 했지만 char ch1 = scanner.next().charAt(0);를 사용하자 첫 글자인 's'만 저장되고 나머지는 무시됨.

**오류 코드**  
```java
  char ch1;
  System.out.print("학번을 입력하세요> ");
	ch1 = scanner.next().charAt(0);
```

**원인 분석**  
- charAt(0)은 입력받은 문자열의 첫 번째 문자만 추출함.
- "sud111"을 입력해도 ch1에는 's'만 저장됨.
- 전체 문자열을 저장하려면 char가 아닌 String 타입을 사용해야 함.

**해결 방안**  
- 아래와 같이 result 값을 새로 만들고 if를 통안 출력 처리를 함.
  ```java
  char ch1; -> String ch1
  ch1 = scanner.next();
  ```

**느낀점**  
- 입력 처리 시 데이터 타입 선택의 중요성을 실감함.
- 데이터 타입에 대한 명확한 개념 정리 필요성을 느낌.
</details>


---

## ✔참고문헌
