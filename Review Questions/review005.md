## 📚 day005복습  
Q1. 복습문제 - 다음 TEST에 해당하는 CSS 코드를 작성하시오.
<div>TEST</div>
✅ <div> 카드
1) 배경색 흰색 →    #fff
2) 너비 250px
3) 페이지 가운데 정렬 →   0 auto 
4) 모서리 둥글게 →   20px
5) 그림자 효과 →  0 4px 12px rgba(0,0,0,0.1)
6) 텍스트 가운데 정렬 →   center
7) 안쪽 여백 20px

Q2. 복습문제 - 다음에 해당하는 프로그리맹을 작성하시오.
연습문제2)
패키지명 : com.company.java002_ex
클래스명 : DataTypeEx002
출력내용 :  Scanner이용해서 나이 입력받고 출력하시오.
    나이는 입력하시오 > _입력받기
    내 나이는  ** 살 입니다.





## 📚 day005복습   - Answer
Q1. 복습문제 
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


Q2. 복습문제 - 다음에 해당하는 프로그리맹을 작성하시오.
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