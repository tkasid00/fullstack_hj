## 📚 day011 복습  


PART001) JAVA
복습문제1) 다음을 if로 작성하시오.
클래스명 :  Repeat012_1
출력내용 : 숫자한개를 입력받아    
	만약 1을 입력했다면   one ,	
	만약 2을 입력했다면   two ,
	만약 3을 입력했다면   three ,
	1,2,3이 아니라면  1,2,3이 아니다를 출력하는 프로그램을 작성하시오.


복습문제2) 다음을  switch로 작성하시오.
클래스명 :  Repeat012_2
출력내용 : 숫자한개를 입력받아    
	만약 1을 입력했다면   one ,	
	만약 2을 입력했다면   two ,
	만약 3을 입력했다면   three ,
	1,2,3이 아니라면  1,2,3이 아니다를 출력하는 프로그램을 작성하시오.


복습문제3) 다음을 for로 작성하시오.
클래스명 :  Repeat012_3
출력내용 : 
q1  for문을 이용해서 다음과 같이 출력하시오 :   1 2 3 4 5 
q2  for문을 이용해서 다음과 같이 출력하시오 :   5 4 3 2 1 
q3  for문을 이용해서 다음과 같이 출력하시오 :   JAVA1   JAVA2  JAVA3  




>>>> CSS
CSS 다음 빈칸에 알맞은 코드를 채우시오.
Q1. block요소를 inline으로,    width X , 줄바꿈 X
ul.d1  li{    ①   }

Q2. block요소를 inline-block으로,  width O , 줄바꿈 X
ul.d2  li{ ②   width:100px;}

Q3. inline을 block 요소로,  링크영역확대
a.github{  ③    width:100px; margin:auto; }

Q4. 왼쪽, 오른쪽으로 배치시     (  ④    )     사용해야하며 float끊을때는 (   ⑤    ) 
div.left{  width:20%;    ⑥ }   왼쪽배치
div.right{ width:20%;  ⑦  }  오른쪽배치
div.clear{ ⑧ }    float끊기

Q5. .space를 기준으로  .astronaut 오른쪽상단(10px 10px) 가  배치
<div class="space">
   <div class="astronaut"></div>
</div>
.space{  ⑨  }
.astronaut { ⑩   }    오른쪽상단(10px 10px)

Q6. 화면고정위치 브라우저에 고정( 오른쪽0 , 아래쪽:10%)
.satellite{  ⑪   }    브라우저에 고정( 오른쪽0 , 아래쪽:10%)





■ ■ ■  복습문제 DAY011 - ANSWER
■ ■ ■  복습문제 DAY011 - ANSWER
■ ■ ■  복습문제 DAY011 - ANSWER

>>>> JAVA

복습문제1) 다음을 if로 작성하시오.
클래스명 :  Repeat012_1
출력내용 : 숫자한개를 입력받아    
	만약 1을 입력했다면   one ,	
	만약 2을 입력했다면   two ,
	만약 3을 입력했다면   three ,
	1,2,3이 아니라면  1,2,3이 아니다를 출력하는 프로그램을 작성하시오.

```
package com.company.java004;
import java.util.Scanner;

public class Repeat012_1 {
	public static void main(String [] args) {
		// 변수
		int  a=0;
		Scanner scanner = new Scanner(System.in);
		// 입력
		System.out.print("숫자 한개 입력 > ");
		a = scanner.nextInt();
		// 처리+출력 (1)  if (조건식이 복잡하고 여러개일때  && >= )
		     if( a == 1) {  System.out.println("1이다");}  //else 부분 안봄
		else if( a == 2) {  System.out.println("2이다");}
		else if( a == 3) {  System.out.println("3이다");}
 
	}
}
```



복습문제2) 다음을  switch로 작성하시오.
클래스명 :  Repeat012_2
출력내용 : 숫자한개를 입력받아    
	만약 1을 입력했다면   one ,	
	만약 2을 입력했다면   two ,
	만약 3을 입력했다면   three ,
	1,2,3이 아니라면  1,2,3이 아니다를 출력하는 프로그램을 작성하시오.

```
package com.company.java004;
import java.util.Scanner;

public class Repeat012_1 {
	public static void main(String [] args) {
		// 변수
		int  a=0;
		Scanner scanner = new Scanner(System.in);
		// 입력
		System.out.print("숫자 한개 입력 > ");
		a = scanner.nextInt();
		// 처리+출력 (2)  switch case  break (처리대상 1,2,3)
		     switch(a) {  // 처리대상 
		     case 1 : /* a==1 */System.out.println("1이다"); break;
		     case 2 : /* a==2 */System.out.println("2이다"); break; 
		     case 3 : /* a==3 */System.out.println("3이다"); break;
	     }  
	}
}
```




복습문제3) 다음을 for로 작성하시오.
클래스명 :  Repeat012_3
출력내용 :  
q1  for문을 이용해서 다음과 같이 출력하시오 :   1 2 3 4 5 
q2  for문을 이용해서 다음과 같이 출력하시오 :   5 4 3 2 1 
q3  for문을 이용해서 다음과 같이 출력하시오 :   JAVA1   JAVA2  JAVA3  

```
package com.company.java004;
import java.util.Scanner;

public class Repeat012_3 {
	public static void main(String [] args) {
 		System.out.println("\nq1 : 1 2 3 4 5 ");
		for(int i=1; i<=5; i++) {  System.out.print(i+ "\t"); }
		

		System.out.println("\nq2 : 5 4 3 2 1  ");
		for(int i=5; i>=1; i--) {  System.out.print(i+ "\t"); }
		

		System.out.println("\nq3 : JAVA1   JAVA2  JAVA3   "); 
		for(int i=1; i<=3; i++){System.out.print(" JAVA" + i );  }  //{}  {변수}  for()
	}
}
```



>>>> CSS
CSS 다음 빈칸에 알맞은 코드를 채우시오.
Q1. block요소를 inline으로,    width X , 줄바꿈 X
ul.d1  li{ display:inline; }

Q2. block요소를 inline-block으로,  width O , 줄바꿈 X
ul.d2  li{ display:inline-block;  width:100px;}

Q3. inline을 block 요소로,  링크영역확대
a.github{  display:block;  width:100px; margin:auto; }

Q4. 왼쪽, 오른쪽으로 배치시  (float) 사용해야하며 float끊을때는 (clear:both) 
div.left{  width:20%;  float:left; }
div.right{ width:20%;  float:right;}
div.clear{ clear:both; }

Q5. .space를 기준으로  .astronaut 오른쪽상단(10px 10px) 가  배치
<div class="space">
   <div class="astronaut"></div>
</div>
.space{  position:relative;  }
.astronaut { position:absolute;  top:10px; right:10px; }

Q6. 화면고정위치 브라우저에 고정( 오른쪽0 , 아래쪽:10%)
.satellite{   position:fixed;  right:0; bottom:10%;}