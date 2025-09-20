## 📚 day012 복습  

■ ■ ■  복습문제 DAY012
■ ■ ■  복습문제 DAY012
■ ■ ■  복습문제 DAY012
1. JAVA 복습문제
■. 다음에 해당하는 Q1~Q2조건식을  , Q3 은 for에 해당하는 구문을 적어주세요~!

Q1. 만약 num1이 0~100 사이라면 
Q2. 연산자는 +,  - ,*, /  넷중에 하나라도 포함되면 true   
Q3. for를 이용하여 1,2,3 출력


■ if버젼으로 다음을 작성하시오  [eclipse]
1. a를 입력받으면 apple, b를 입력받으면 banana, c를 입력받으면 coconut  그 이외에는 a,b,c가 아니다 

■ switch버젼으로 다음을 작성하시오  [eclipse]
1. a를 입력받으면 apple, b를 입력받으면 banana, c를 입력받으면 coconut  그 이외에는 a,b,c가 아니다

■ 무한반복으로 다음을 작성하시오  [eclipse]
1을 입력받을때까지 사용자에게 무한반복으로 입력을 받아주세요~!



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


 



■ ■ ■  복습문제 DAY012 - ANSWER
■ ■ ■  복습문제 DAY012 - ANSWER
■ ■ ■  복습문제 DAY012 - ANSWER


>>>>>>>>>>>>>>>> 
1. JAVA 복습문제 - Answer
■. 다음에 해당하는 조건식을 적어주세요~!

Q1. 만약 num1이 0~100 사이라면
if(0<=num1 && num1<=100) {break; }

Q2. 연산자는 +,  - ,*, /  넷중에 하나라도 포함되면 true  
if(op=='+' || op =='-' || op=='*' || op=='/')  

Q3. for를 이용하여 1,2,3 출력
for( int i=1;  i<=3; i++ ){ System.out.print(i ); }



■ if버젼으로 다음을 작성하시오  [eclipse]
1. a를 입력받으면 apple, b를 입력받으면 banana, c를 입력받으면 coconut  그 이외에는 a,b,c가 아니다 
```
import java.util.Scanner;

public class Repeat013_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("문자를 입력하세요 (a, b, c): ");
        char input = scanner.next().charAt(0);

        if (input == 'a') {
            System.out.println("apple");
        } else if (input == 'b') {
            System.out.println("banana");
        } else if (input == 'c') {
            System.out.println("coconut");
        } else {
            System.out.println("a, b, c가 아니다");
        } 
    }
}
```


■ switch버젼으로 다음을 작성하시오  [eclipse]
1. a를 입력받으면 apple, b를 입력받으면 banana, c를 입력받으면 coconut  그 이외에는 a,b,c가 아니다
``` 
import java.util.Scanner;

public class Repeat013_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("문자를 입력하세요 (a, b, c): ");
        char input = scanner.next().charAt(0);

        switch (input) {
            case 'a':
                System.out.println("apple");
                break;
            case 'b':
                System.out.println("banana");
                break;
            case 'c':
                System.out.println("coconut");
                break;
            default:
                System.out.println("a, b, c가 아니다");
        }
    }
}
``` 



■ 무한반복으로 다음을 작성하시오  [eclipse]
1을 입력받을때까지 사용자에게 무한반복으로 입력을 받아주세요~!
```
public class Repeat013_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;

        for(;;) {
            System.out.print("숫자를 입력하세요 (1을 입력하면 종료): ");
            input = scanner.nextInt();

            if (input == 1) {
                System.out.println("종료합니다!");
                break;
            }
        }
 
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