
## 📚 day018 복습  



>>>>>>> JAVA

다음의 실행결과가 나오게 클래스를 작성하시오.
### ■ 클래스명: Repeat019
### ■ 실행결과:
```
🤖 탐사 로봇이 기동합니다!
부우웅...

🪐 행성 스캔 중...
##### (5개의 '#' 출력)

📡 신호 강도 분석 결과:
신호 등급: C

🔋 배터리 충전 중...
충전 완료: 80%
```


### ■ 요구사항:

```java
public class Repeat019 {
    public static void main(String[] args) {
        System.out.println("🤖 탐사 로봇이 기동합니다!");
        start();                    // "부우웅..." 출력

        System.out.println("\n🪐 행성 스캔 중...");
        scan(5, '#');              // ##### 출력

        System.out.println("\n📡 신호 강도 분석 결과:");
        System.out.println("신호 등급: " + signalGrade(65));  // C 출력

        System.out.println("\n🔋 배터리 충전 중...");
        System.out.println("충전 완료: " + charge(40, 40) + "%");  // 80 출력
    }

    // start(): "부우웅..." 출력
    // scan(int n, char ch): ch 문자를 n번 반복 출력
    // signalGrade(int strength): strength 값에 따라 A/B/C/D 등급 반환
    // charge(int current, int added): 현재 배터리와 추가 충전량을 받아 총 퍼센트 반환
}
```
 
>>>>>>>>>  WEB BASIC 
0. 스크립트가 document어느위치에서든지 동작가능하게
1. 아이디가 addEventEx인것을  getElementById 이용해 선택
2. 클릭시 prompt이용해서 당신이 좋아하는 1~5사이의 숫자 물어보고
3. alert이용해서 알림창띄우기  

<input type="button"  value="addEventEx-1~5 Like"  
        title="버튼5"  id="addEventEx"  class="btn btn-success" />



■ ■ ■  복습문제 DAY018 - ANSWER
■ ■ ■  복습문제 DAY018 - ANSWER
■ ■ ■  복습문제 DAY018 - ANSWER
 

>>>>>>> JAVA-ANSWER

```
public class Repeat019 {
    public static void main(String[] args) {
        System.out.println("🤖 탐사 로봇이 기동합니다!");
        start();  // "부우웅..." 출력

        System.out.println("\n🪐 행성 스캔 중...");
        scan(5, '#');  // ##### 출력

        System.out.println("\n📡 신호 강도 분석 결과:");
        System.out.println("신호 등급: " + signalGrade(65));  // C 출력

        System.out.println("\n🔋 배터리 충전 중...");
        System.out.println("충전 완료: " + charge(40, 40) + "%");  // 80 출력
    }

    // 로봇 기동
    public static void start() {
        System.out.println("부우웅...");
    }

    // 행성 스캔 결과 출력
    public static void scan(int n, char ch) {
        for (int i = 0; i < n; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    // 신호 강도에 따른 등급 반환
    public static String signalGrade(int strength) {
        if (strength >= 90) {
            return "A";
        } else if (strength >= 80) {
            return "B";
        } else if (strength >= 70) {
            return "C";
        } else {
            return "D";
        }
    }

    // 배터리 충전 계산
    public static int charge(int current, int added) {
        return current + added;
    }
}

```  



>>>>>>>>>  WEB BASIC-ANSWER 

```js
     window.addEventListener("load" , function(){ 
        document.getElementById("addEventEx").onclick=function(){
          let like = prompt("좋아하는 숫자1~5" , "1~5");
          alert("좋아하는 숫자는 " + like + "입니다.");
        }; 
     });   
```