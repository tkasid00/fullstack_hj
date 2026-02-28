
## 📚 day006복습  
Q1. 복습문제 - GITHUB
복습문제1) FORK 와 팀원을 초대했을때의 차이점은?

복습문제2) 팀원들을 EMAIL로 초대해서 작성시 다음부분을 코드 채우시오. 
1-1. 팀원 -  팀장이 만든 상자를 내컴퓨터로 가져오기 - 폴더명은  portfolio

1-2. 팀원 - 브랜치 만들어서 파일한개 올리기

1-3. 팀원 - pr하는방법은?
 

Q2. 복습문제 - WEB 
- 다음 TEST에 해당하는 CSS 코드를 작성하시오.
<div>TEST</div>
✅ <div> 카드
1) 배경색 흰색 →    #fff
2) 너비 250px
3) 페이지 가운데 정렬 →   0 auto 
4) 모서리 둥글게 →   20px
5) 그림자 효과 →  0 4px 12px rgba(0,0,0,0.1)
6) 텍스트 가운데 정렬 →   center
7) 안쪽 여백 20px


Q3. 복습문제 - JAVA
복습문제1) 
1) 자료형의 구분
- 기본형 : [ ① ] 저장
- 참조형 : [ ② ] 저장 ( String ) 

2) 기본자료형 
- 논리형 - [ ③ ]  true/false
- 정수형 - [ ④  ](1byte) -[ ⑤  ](2byte) - [  ⑥ ](4byte) ★  - [ ⑦  ](8byte)  
                                                       long l = 4L;
- 실수형 - float(4byte)      - double(8byte) ★
          float f= 3.14f;     double d = 3.14;
 

복습문제2)  다음에 해당하는 프로그리밍을 작성하시오.
패키지명 : com.company.java002_ex
클래스명 : DataTypeEx002
출력내용 :  Scanner이용해서 나이 입력받고 출력하시오.
    좋아하는 수(정수)   입력하시오 > _입력받기
    좋아하는 숫자는 ** 입니다.


## 📚 day006복습  - Answer

Q1. 복습문제 - GITHUB
복습문제1) FORK 와 팀원을 초대했을때의 차이점은?
```
FORK: 원본 저장소를 복사해서 내 계정으로 가져오는 방식. 독립적으로 작업 가능하며, 
원본 저장소에는 직접 수정 권한이 없음.

팀원 초대: 팀장이 저장소에 직접 초대하면, 해당 저장소에 직접 커밋, 브랜치 생성, PR 등을 할 수 있는 권한을 부여받음.
```

복습문제2) 팀원들을 EMAIL로 초대해서 작성시 다음부분을 코드 채우시오. 
1-1. 팀원 -  팀장이 만든 상자를 내컴퓨터로 가져오기 - 폴더명은  portfolio
```
git clone  https://github.com/sally03915/fullstack_20250825  portfolio 
```
1-2. 팀원 - 브랜치 만들어서 파일한개 올리기
```
cd  portfolio 
git checkout -b   dev-소문자이름
dev-소문자이름.md      파일만들기 - teacher폴더안
git add dev-소문자이름.md
git commit -m "first dev-소문자이름"
git push origin  dev-소문자이름
```
1-3. 팀원 - pr하는방법은?
```
1. 팀장 깃허브주소
2. Compard & pull  request 클릭
3. 제목과 메시지 작성 - 작업마무리완료입니다. 제안
```
 

Q2. 복습문제 - WEB 
- 다음 TEST에 해당하는 CSS 코드를 작성하시오.
<div>TEST</div>
✅ <div> 카드
1) 배경색 흰색 →    #fff
2) 너비 250px
3) 페이지 가운데 정렬 →   0 auto 
4) 모서리 둥글게 →   20px
5) 그림자 효과 →  0 4px 12px rgba(0,0,0,0.1)
6) 텍스트 가운데 정렬 →   center
7) 안쪽 여백 20px

<div style="
  background-color: #fff;
  width: 250px;
  margin: 0 auto;
  margin-bottom: 20px;
  border-radius: 20px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
  text-align: center;
  padding: 20px;
">
  TEST
</div>


Q3. 복습문제 - JAVA
자료형의 구분
기본형 : [ ① 값 ] 저장
참조형 : [ ② 주소 ] 저장 (예: String)

기본자료형
논리형 - [ ③ boolean ]
정수형
[ ④ byte ] (1byte)
[ ⑤ short ] (2byte)
[ ⑥ int ] (4byte) ★
[ ⑦ long ] (8byte)
```


복습문제2)  다음에 해당하는 프로그리밍을 작성하시오.
패키지명 : com.company.java002_ex
클래스명 : DataTypeEx002
출력내용 :  Scanner이용해서 나이 입력받고 출력하시오.
    좋아하는 수(정수)   입력하시오 > _입력받기
    좋아하는 숫자는 ** 입니다.

```java
package com.company.java002_ex;
import java.util.Scanner;

public class DataTypeEx002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("나이를 입력하시오 > ");
        int age = scanner.nextInt();
 
        System.out.println("내 나이는 " + age + " 입니다.");
    }
}
```