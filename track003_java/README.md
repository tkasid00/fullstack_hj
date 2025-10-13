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
</details>




<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅09(반복문 출력 누적 오류)</summary>

**[문제점]**  
- 원하는 결과값 18이 출력되지 않고 반복적으로 중간값들이 출력됨.


**[오류 코드]**  
```java
for(int i=1; i<=10; i++) {
    if(i%3==0){
        hap += i;
    }
    System.out.print(hap);
}
```

**[원인 분석]**  
- System.out.print(hap);가 반복문 안에 위치해 있어  hap의 값이 누적될 때마다 즉시 출력됨.
- 결과적으로 hap의 중간값들이 계속 출력되어 최종값만 확인할 수 없음.


**[해결 방안]**  
- - System.out.print(hap);를 반복문 밖으로 이동시켜 누적이 끝난 후 최종값만 출력되도록 수정.

  ```java
  for(int i=1; i<=10; i++) {
    if(i%3==0){
        hap += i;
    }
  }
  System.out.print(hap);
  ```

**[느낀점]**  
- 출력문 위치 하나로 결과가 완전히 달라질 수 있다는 걸 깨달음.
- 반복문 안/밖의 차이를 명확히 이해하는 것이 중요함.
- 디버깅할 때는 출력 위치와 흐름을 꼼꼼히 체크해야 함.
</details>



<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅10(자바 배열 출력 오류)</summary>

**[문제점]**  
- 배열 계산 중 정수값이 아닌 주소값이 출력되는 문제 발생

**[오류 코드]**  
  ```java
  System.out.print(arr + "\t");
  ```

**[원인 분석]**  
- System.out.print(arr + "\t");는 배열 arr 전체를 문자열로 변환하려고 시도함.
- 자바에서 배열을 직접 출력하면 char[]@해시코드 형태의 문자열이 출력됨.
- 자바에서 배열을 출력할 때는 Arrays.toString() 또는 반복문을 사용해야 함.
- char[]는 System.out.println()에서 자동으로 문자열처럼 출력되기도 하지만 + 연산자와 함께 쓰면 주소값처럼 나타남.


**[해결 방안]**  
- 반복문으로 직접 출력함.
  ```java
  for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i] + "\t");
  }
  ```

**[느낀점]**  
- 자바에서 배열을 출력할 때는 배열의 구조와 toString()의 동작 방식을 이해하는 것이 중요하다는 걸 배움.
- 단순한 출력이라도 데이터 타입에 따라 다르게 처리해야 한다는 점에서 프로그래밍은 세심함이 필요함.
</details>



<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅11(배열 인덱스 초과 오류)</summary>

**[문제점]**  
- 다음과 같은 오류 메시지 발생
```java
 Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
	at com.company.java007_ex.ArrayEx008.main(ArrayEx008.java:17)
```

**[오류 코드]**
```java
int i = 0;

for(i = 0; i < name.length; i++) {
    aver[i] = (int) ((kor[i] + eng[i] + mat[i]) / 3.0);
}

System.out.println(aver[i]);
```

**[오류 메시지 분석]**  
- ArrayIndexOutOfBoundsException: 배열의 유효한 인덱스 범위를 벗어난 접근이 발생했을 때 나타나는 예외.
- Index 5 out of bounds for length 5: aver[5]를 접근하려 했지만 aver 배열의 인덱스는 0~4까지만 존재.
- 오류 발생 위치는 main 메서드의 17번째 줄.


**[원인 분석]**  
- i는 for 루프 외부에서 선언되어 루프 종료 후에도 값이 유지.
- 루프가 종료되면 i == 5가 되며, System.out.println(aver[i]);에서 aver[5]를 접근하게 됨.
- aver 배열의 크기는 5이며 인덱스는 0부터 시작하기 때문에 5는 범위를 초과함.


**[해결 방안]**  
- 1) 다음과 같이 인덱스 조정함 : 단순 오류 메시지 제거 시 사용
  ```java
  for (i = 0; i < name.length; i++) {
    aver[i] = (int) ((kor[i] + eng[i] + mat[i]) / 3.0);
  }
  System.out.println(aver[i - 1]);
  ```
- 2) 루프 안에서 출력 : 현재 코드에서 원하는 결과값을 내기 위해서는 이 방법이 더 정확함
```java
for (int i = 0; i < name.length; i++) {
    aver[i] = (int) ((kor[i] + eng[i] + mat[i]) / 3.0);
    System.out.println(aver[i]); 
}
```
**[느낀점]**  
- 변수의 범위와 루프 종료 후 상태를 잘 이해하는 것이 중요함.
- 자바는 컴파일 시 오류를 잡아주지 못하는 런타임 예외가 많음.
- 배열을 다룰 때는 항상 인덱스 범위를 명확히 인식하고 있어야 함.
</details>



<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅12(배열 초기화 오류)</summary>

**[문제점]**  
- 다음 오류 메시지 출력
 ```java
 Exception in thread "main" java.lang.NullPointerException
	at ArrayExUpgrade1.main(ArrayExUpgrade1.java:7)
 ```

**[오류 코드]**  
```java
        char [] answer = {'A', 'C', 'B', 'D', 'A'}; 
        char [] correct = null; 
        Scanner sc = new Scanner(System.in); 
        for(int i=0; i<answer.length; i++) { 
            System.out.print("입력 > "); 
            correct[i] = sc.next().charAt(0); 
        } 
```

**[원인 분석]**  
- correct 배열을 선언했지만 메모리 공간을 할당하지 않았음.
- null 상태에서는 어떤 인덱스 접근도 불가능하며 접근 시 NullPointerException이 발생.

**[해결 방안]**  
- 배열 크기 지정하여 초기화 함.
  ```java
  char[] correct = new char[5];
  ```

**[느낀점]**  
- 자바에서 배열은 명시적으로 메모리 할당을 해줘야 함.
- null 상태의 객체나 배열을 접근하면 런타임 예외가 발생하므로 초기화 여부 확인 필요.
- 코드 작성 시 배열의 크기와 초기화 시점을 명확히 하는 습관이 중요함.
</details>



<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅13(레벨 갱신 누락 오류)</summary>

**[문제점]**  
- 캐릭터의 상태(happy, reliance, healthy, clean)에 따라 레벨(lv)이 올라가야 하는데 모든 조건을 만족해도 lv값이 항상 1로 설정되는 현상이 발생함.

**[오류 코드]**  
```java

  int lv = 0; //메인 부분에 위치

  if(happy < 10 && reliance < 10 && healthy < 20 && clean < 10) {
    lv = 1;
  } else if(lv == 1 && happy >= 10 && happy < 30 && reliance >= 10 && reliance < 30 && healthy >= 10 && healthy < 30 && clean >= 10 && clean < 30) {
    lv = 2;
  } else if(happy >= 30 && happy < 50 && reliance >= 30 && reliance < 50 && healthy >= 30 && healthy < 50 && clean >= 30 && clean < 50) {
    lv = 3;
  } else if(happy >= 50 && reliance >= 50 && healthy >= 50 && clean >= 50) {
    lv = 4;
  }
```

**[원인 분석]**  
- lv를 계산하는 조건문이 main() 시작 부분에만 있고 이후 happy, reliance 등의 값이 변경되어도 다시 계산되지 않아 다른 수식에서 수치 변경이 발생해도 lv는 갱신되지 않음.
- 또한 어느 한 수치가 다른 레벨값에 먼저 도달할 경우 레벨 조건 기준을 벗어나 제대로 계산이 되지 않는 문제 발생.

**[해결 방안]**  
- 아래와 같이 역순으로 계산하도록 수정하고 수치 변동 구간 이후 재계산이 이루어지도록 계산식을 다시 삽입함.

  ```java
      if (lv < 5) {
	    if (happy >= 50 && reliance >= 50 && healthy >= 50 && clean >= 50) {lv = 4;} 
	    else if (happy >= 30 && reliance >= 30 && healthy >= 30 && clean >= 30) {lv = 3;}
	    else if (happy >= 10 && reliance >= 10 && healthy >= 10 && clean >= 10) {lv = 2;}
	    else {lv = 1;}
	  }
      }
  ```

**[느낀점]**  
- 단순한 조건문 오류가 아니라 상태 변화 이후에도 값을 갱신하지 않는 구조적 문제였다는 것을 배움.
- 프로그램의 흐름과 변수의 생명주기를 이해하는 것이 얼마나 중요한지 체감함.
- 앞으로는 조건문 작성 시 논리 흐름과 실행 타이밍을 더 신중하게 고려해야겠다고 느꼈음.
- 이 경험을 통해 상태 기반 로직은 항상 변화 이후에 다시 평가되어야 한다는 원칙을 명확히 인식하게 됨.

</details>



<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅14(인덱스 크기 초과 오류)</summary>

**[문제점]**  
- 배열의 크기를 초과하여 인덱스에 접근하면서 ArrayIndexOutOfBoundsException 예외가 발생함.
**[오류 코드]**  
```java
int[][] datas = {  {  10, 10, 10 ,10}, 
            {  20, 20, 20 ,20}, 
            {  30, 30, 30 ,30},  
}; 
int[][] result = new int[datas.length+1][datas[0].length+1];

for(int i =0; i<result.length;i++) {
    for (int j=0; j<result[i].length; j++) {
        result[i][j] = datas[i][j];
        System.out.print(result[i][j]);
    }
}

```

**[원인 분석]**  
- result 배열은 datas 배열보다 크기가 1씩 더 크도록 선언되었지만 datas[i][j]를 그대로 참조하고 있어 i 또는 j가 datas의 범위를 벗어날 때 예외가 발생함. 
- result.length는 4, datas.length는 3이므로 i=3일 때 datas[3][j]를 참조하려고 하면서 오류가 발생함.

**[해결 방안]**  
- 다음과 같이 for 구문을 나눠 배열이 겹치는 부분과 초과하는 부분의 계산을 별도로 처리함.
  ```java
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				result[i][j] = datas[i][j];
			}

		} 
		for (int i = 0; i < result.length - 1; i++) {
			for (int j = 0; j < result[i].length - 1; j++) {
				result[i][result.length] += result[i][j];
				result[3][j] += result[i][j];
				result[3][result.length] += result[i][j];
			}
  ```

**[느낀점]**  
- 배열을 다룰 때는 항상 인덱스 범위를 정확히 파악하고 있어야 한다는 걸 다시 한 번 느낌. 
- 특히 2차원 배열은 행과 열의 크기를 혼동하기 쉬우므로 디버깅 시 배열의 구조를 시각적으로 그려보는 것도 도움이 됨. 
</details>


<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅15(exec() 결과값 미할당 오류)</summary>
**문제점**  
- controller[0].exec(users, 0);를 호출했으나 반환값을 변수 find에 저장하지 않음.
- find를 참조하는 부분에서 값이 제대로 전달되지 않아 로직이 꼬이고 오류 발생.

**[오류 코드]**  
  ```java
  controller[0].exec(users, 0);   // 반환값을 받지 않음
  if(find == -1) {
      System.out.println("유저 정보를 확인해 주세요");
  }
  controller[num].exec(users, find);  // find 값이 유효하지 않음

  ```

**[원인 분석]**  
- exec() 메서드가 int 값을 반환하도록 정의되어 있지만 반환값을 무시하고 단순 호출만 하여 find 변수는 초기 상태 그대로 남음.
- 로그인 여부나 이후 흐름 제어에 필요한 find값이 전달될 수 없음.

**[해결 방안]**  
- 반환값을 find에 저장하도록 수정.
  ```java
  find = controller[0].exec(users, 0);  // 반환값 저장
  if(find == -1) {
      System.out.println("유저 정보를 확인해 주세요");
  }
  controller[num].exec(users, find);    // 정상적으로 find 전달
  ```

**[느낀점]**  
- 메서드가 반환값을 가지는지, 단순 실행인지 항상 확인해야 함.
- 반환값을 저장하지 않으면 메서드 로직이 연결되지 않고 일회성에 불과한 것을 깨달음.
- void와 return 타입 메서드 구분을 더 명확히 인식해야 한다고 느낌.
</details>


<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅15(exec() 결과값 미할당 오류)</summary>
**문제점**  
- controller[0].exec(users, 0);를 호출했으나 반환값을 변수 find에 저장하지 않음.
- find를 참조하는 부분에서 값이 제대로 전달되지 않아 로직이 꼬이고 오류 발생.

**[오류 코드]**  
  ```java
  controller[0].exec(users, 0);   // 반환값을 받지 않음
  if(find == -1) {
      System.out.println("유저 정보를 확인해 주세요");
  }
  controller[num].exec(users, find);  // find 값이 유효하지 않음

  ```

**[원인 분석]**  
- exec() 메서드가 int 값을 반환하도록 정의되어 있지만 반환값을 무시하고 단순 호출만 하여 find 변수는 초기 상태 그대로 남음.
- 로그인 여부나 이후 흐름 제어에 필요한 find값이 전달될 수 없음.

**[해결 방안]**  
- 반환값을 find에 저장하도록 수정.
  ```java
  find = controller[0].exec(users, 0);  // 반환값 저장
  if(find == -1) {
      System.out.println("유저 정보를 확인해 주세요");
  }
  controller[num].exec(users, find);    // 정상적으로 find 전달
  ```

**[느낀점]**  
- 메서드가 반환값을 가지는지, 단순 실행인지 항상 확인해야 함.
- 반환값을 저장하지 않으면 메서드 로직이 연결되지 않고 일회성에 불과한 것을 깨달음.
- void와 return 타입 메서드 구분을 더 명확히 인식해야 한다고 느낌.
</details>


<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅16(메서드 파라미터 불일치 오류)</summary>

**[문제점]**  
- lvup() 메서드를 정의할 때 파라미터 6개 (int i, int happy, int reliance, int healthy, int clean, int lv)를 받도록 작성.
- 그러나 다른 메서드(addHappy, addHealthy, addReliance, addClean)에서는 인자 없이 lvup();만 호출하여 메서드 호출 시 인자가 부족하다는 컴파일 오류 발생.

**[오류 코드]**  
```java
// 정의
void lvup(int i, int happy, int reliance, int healthy, int clean, int lv) {
    if (lv < 5) {
        if (happy >= 50 && reliance >= 50 && healthy >= 50 && clean >= 50) {
            lv = 4;
        } else if (happy >= 30 && reliance >= 30 && healthy >= 30 && clean >= 30) {
            lv = 3;
        } else if (happy >= 10 && reliance >= 10 && healthy >= 10 && clean >= 10) {
            lv = 2;
        } else {
            lv = 1;
        }
    }
}

// 호출
void addHappy(int add) {
    happy += add;
    lvup();   // 인자 부족으로 오류 발생
}


```

**[원인 분석]**  
- 메서드 선언부에서는 6개의 매개변수를 요구하지만, 호출부에서는 매개변수를 전달하지 않음.
- happy, reliance, healthy, clean, lv는 이미 클래스 필드(멤버 변수)로 존재하기 때문에 매개변수로 다시 받을 필요가 없음.

**[해결 방안]**  
- lvup()을 인자 없는 메서드로 정의하고 내부에서 필드 값을 직접 사용하도록 수정.
  ```java
  void lvup() {
      if (lv < 5) {
          if (happy >= 50 && reliance >= 50 && healthy >= 50 && clean >= 50) {
              lv = 4;
          } else if (happy >= 30 && reliance >= 30 && healthy >= 30 && clean >= 30) {
              lv = 3;
          } else if (happy >= 10 && reliance >= 10 && healthy >= 10 && clean >= 10) {
              lv = 2;
          } else {
              lv = 1;
          }
      }
  }

  void addHappy(int add) {
      happy += add;
      lvup();   
  }

  ```

**[느낀점]**  
- 멤버 변수가 이미 클래스 안에 있다면 굳이 매개변수로 중복 전달할 필요가 없음을 깨달음.
- 메서드 정의 시 실제로 필요한 인자만 선언해야 호출 시 혼동이 줄어듦.
- 객체 지향에서 필드와 메서드 관계를 더 명확히 이해할 필요성을 느낌. 
</details>



<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅17(빈 배열 조건문 처리 방식 오류)</summary>

**[문제점]**  
- 로그인 기능에서 보호자 등록 여부를 판별할 때 if(users.size()==0) 조건을 사용.
- 조건 분기 처리 중 메시지가 섞여 출력되는 현상이 발생함.

**[오류 코드]**  
```java
if(users.size()==0) {
    System.out.println("보호자 등록이 필요합니다");
} else {
    for(int i=0; i<users.size(); i++) {
        if(tempid.equals(users.get(i).getId()) && 
           temppass.equals(users.get(i).getPass())) {
            System.out.println("보호자 정보가 일치합니다");
            find = i;
            break;
        } else {
            System.out.println("ID와 비밀번호를 확인해 주세요\n신규 보호자 등록은 1번에서 가능합니다");
            break;
        }
    }
}


```

**[원인 분석]**  
- size()==0은 단순히 숫자를 비교하는 방식이라 배열의 상태를 직관적으로 드러내지 못함.
- 이로 인해 조건문 구조가 복잡할 때 등록 없음과 불일치 메시지가 혼합되는 혼선이 발생.

**[해결 방안]**  
- 판별 기준으로 isEmpty()를 대신 사용함.
- isEmpty()는 List, Map, Set 등의 컬렉션에서 비어 있는 상태를 표현하기 위한 표준 메서드로 코드 의도를 명확하게 보여주며 로직 분리를 확실히 해줌.
  ```java
-	if(users.isEmpty()) {System.out.println("보호자 등록이 필요합니다"); 

**[느낀점]**  
- isEmpty()는 단순히 배열의 크기가 0인지 확인하는 코드보다 훨씬 의도를 명확히 드러냄.
- 가독성 향상은 단순한 미관 문제가 아니라 로직 충돌(혼선)을 예방하는 실질적 수단임을 깨달음.
- 조건문 설계 시 상태 판단 로직은 먼저 반복 로직은 나중이라는 순서를 지키는 것이 중요함.
</details>



<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅18(삼항연산자 우선순위 오류)</summary>

**[문제점]**  
- 평균 60점 이상이면 “합격”, 60점 미만이면 “불합격” 과목 중 하나라도 40점 미만이면 “과락”으로 처리하려고 했으나 평균이 100점인 학생조차 “불합격”으로 표기되는 오류 발생.

**[오류 코드]**  
```java
  public void process_pass(Score std) {
      std.setPass(
          std.getAvg() >= 60
              ? "합격"
              : std.getKor() < 40 ? "과락"
              : std.getEng() < 40 ? "과락"
              : std.getMath() < 40 ? "과락"
              : "불합격"
      );
  }


```

**[원인 분석]**  
- 삼항 연산자는 오른쪽 결합(right-associative)이라 여러 개를 연속으로 쓰면 조건이 의도와 다르게 중첩 평가됨.
- 위 코드에서는 std.getAvg() >= 60이 참일 때도 뒤쪽의 과락 조건이 함께 평가되어 "불합격"으로 덮어씌워짐.
- 내부 중첩 삼항 구조 때문에 첫 조건을 만족해도 이후 조건이 계속 검사되는 논리 오류 발생.

**[해결 방안]**  
- 삼항 연산자 안에 괄호를 사용해 조건의 우선순위를 명시적으로 제어.
```java
public void process_pass(Score std) {
    std.setPass(
        std.getAvg() >= 60
            ? (std.getKor() < 40 || std.getEng() < 40 || std.getMath() < 40
                ? "과락" 
                : "합격")
            : "불합격"
    );
}

```

**[느낀점]**  
- 삼항 연산자를 연속으로 쓸 때는 연산자 우선순위가 직관적이지 않다는 걸 실감함.
- 복잡한 조건은 괄호로 명시하거나 if-else로 분리해 가독성을 높이는 게 안전함.
- 논리 흐름이 꼬이는 이유가 문법 오류가 아닌 연산 평가 순서 때문이라는 점을 명확히 인식하게 됨.

</details>

<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅19(List 스코프 오류로 인한 데이터 미저장 문제)</summary>

**[문제점]**  
- List<IceCreamDTO> ice = new ArrayList<>();를 switch문 안쪽에 선언한 상태에서 아이스크림을 추가했으나 while문이 반복될 때마다 리스트가 새로 생성되어 이전에 추가한 데이터가 모두 사라짐.

**[오류 코드]**  
```java
while(true) {
    List<IceCreamDTO> ice = new ArrayList<>();  // ❌ while문 안에 선언됨

    switch(num) {
        case 1:
            System.out.print("아이스크림 이름: ");
            String newname = scanner.next();
            System.out.print("가격: ");
            int newprice = scanner.nextInt();
            ice.add(new IceCreamDTO(newname, newprice)); // 매번 새로운 리스트에 추가됨
            System.out.println("추가 완료!");
            break;
    }
}



```

**[원인 분석]**  
- 리스트를 while문 내부에서 선언하면 반복할 때마다 새로운 객체가 생성됨.
- 기존 리스트(ice)는 반복이 끝나자마자 GC(가비지 컬렉션) 대상으로 사라짐.
- 리스트의 생명주기가 반복문 단위로 한정되어 있어 데이터가 유지되지 않음.

**[해결 방안]**  
- 리스트 선언을 while문 밖으로 이동시켜 프로그램 실행 중 하나의 리스트 인스턴스를 유지하도록 수정.
```java
List<IceCreamDTO> ice = new ArrayList<>();  // ✅ while문 밖으로 이동

while(true) {
    switch(num) {
        case 1:
            System.out.print("아이스크림 이름: ");
            String newname = scanner.next();
            System.out.print("가격: ");
            int newprice = scanner.nextInt();
            ice.add(new IceCreamDTO(newname, newprice));  // ✅ 기존 리스트에 계속 추가됨
            System.out.println("추가 완료!");
            break;
    }
}

```

**[느낀점]**  
- 변수를 어디에 선언하느냐에 따라 데이터의 생명주기가 완전히 달라진다는 걸 체감함.
- 특히 List, Map 같은 컬렉션은 한 번만 생성하고 반복문 밖에서 유지해야 의미가 있음.
- 객체의 범위(scope)와 생명주기(lifecycle)를 제대로 이해하는 것이 자바 로직의 기본임을 다시 인식함.
</details>
---

## ✔참고문헌
