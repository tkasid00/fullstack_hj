
## 📚 day017 복습  

  
다음의 실행결과가 나오게 클래스를 작성하시오.

■ 실행결과: 
🐶 강아지가 등장합니다!
멍멍

🎯 강아지가 시험을 봤습니다. 점수를 공개합니다!
*******

📊 평가 결과는?
당신의 평균은? B

```
public class Repeat018 {
    public static void main(String[] args) {
        System.out.println("🐶 강아지가 등장합니다!");
        dog();                      // 멍멍 출력

        System.out.println("\n🎯 강아지가 시험을 봤습니다. 점수를 공개합니다!");
        disp(7, '*');              // ******* 출력

        System.out.println("\n📊 평가 결과는?");
        System.out.println("당신의 평균은? " + stdAvg(88));  // B 출력
    }  // 90점이상이면 A ,  80점이상이면 B ,  70점이상이면 C , 아니라면  D
}
```



■ ■ ■  복습문제 DAY017 - ANSWER
■ ■ ■  복습문제 DAY017 - ANSWER
■ ■ ■  복습문제 DAY017 - ANSWER
 
```
public class Repeat018 {
    public static void main(String[] args) {
        System.out.println("🐶 강아지가 등장합니다!");
        dog();                      // 멍멍 출력

        System.out.println("\n🎯 강아지가 시험을 봤습니다. 점수를 공개합니다!");
        disp(7, '*');              // ******* 출력

        System.out.println("\n📊 평가 결과는?");
        System.out.println("당신의 평균은? " + stdAvg(88));  // B 출력
    }

    // 강아지가 짖는 메서드
    public static void dog() {
        System.out.println("멍멍");
    }

    // 별을 반복 출력하는 메서드
    public static void disp(int count, char ch) {
        for (int i = 0; i < count; i++) {
            System.out.print(ch);
        }
        System.out.println(); // 줄바꿈
    }

    // 평균 점수에 따라 학점을 리턴하는 메서드
    public static String stdAvg(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else {
            return "D";
        }
    }
}

``` 