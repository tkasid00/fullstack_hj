## 📚 day010 복습  


■ 복습문제 (1)
1. 자바 우선순위를 적으시오.


■ 복습문제 (2)
2. 다음코드에서 오류나는 부분을 찾아 해결하시오.
char ch = 'A';
ch = ch+32;


■ 복습문제 (3)
3. 다음 조건식을 작성하시오.
char형 변수 ch가 영문자(대문자 또는 소문자) 일때   true인 조건식    

■ 복습문제 (4)  eclipse
클래스명 :  Repeat011
출력내용 :  계산기

1. 정수를 하나 입력해주세요 > 10
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > +
10+3=13 


>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

■ 복습문제 (1)
1. 자바 우선순위를 적으시오.
()   값( ++ , -- , + , - )  비교(>,<, == ) 조건(&& ||)   대입(=)

■ 복습문제 (2)
2. 다음코드에서 오류나는 부분을 찾아 해결하시오.
char ch = 'A';
ch = ch+32;

> 해결
ch = (char) ch+32;

■ 복습문제 (3)
3. 다음 조건식을 작성하시오.
char형 변수 ch가 영문자(대문자 또는 소문자) 일때   true인 조건식   
if(  ch >= 'A' && ch <='Z'   ||  ch >= 'a' && ch <='z'    )  

■ 복습문제 (4)  eclipse
클래스명 :  Repeat011
출력내용 :  계산기

1. 정수를 하나 입력해주세요 > 10
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > +
10+3=13 

```
package com.company.java004_ex;
import java.util.Scanner;

public class IfEx007_1 {
	public static void main(String[] args) {
		//변수
		int num1, num2; String result ="";
		char op;
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("1. 정수를 하나 입력해주세요 >");
		num1 = scanner.nextInt();
		System.out.print("2. 정수를 하나 입력해주세요 >");
		num2 = scanner.nextInt();
		System.out.print("3. 연산자를 입력해주세요(+,-,*,/) >");
		op = scanner.next().charAt(0);
		//처리    출력  숫자   연산자  숫자    = 
		
		result = "" + num1 + op + num2 + "=";  
 
		if(op == '+') {  result += (num1+num2);  }
		else if(op == '-') {  result += (num1-num2);  }
		else if(op == '*') {  result += (num1*num2);  }
		else if(op == '/') {  result += String.format("%.2f"  , (double)num1/num2);  }
		 
		     
		//출력
		System.out.println(result);
	}
}
```