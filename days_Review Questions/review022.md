## 📚 day022 복습  

# ■ Java 복습문제
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Q1. static 키워드의 특징을 설명하고 빈칸을 채우시오. 
static은 클래스에 (①       )되어 공유된다. 
객체 생성 없이 (②       ) 이름으로 접근 가능하다. 
메모리 영역은 (③       ) area에 저장된다.

Q2. final 키워드의 역할을 설명하고 빈칸을 채우시오. 
final로 선언된 변수는 (④       )할 수 없다. 
final 메서드는 (⑤       )할 수 없다. 
final 클래스는 (⑥       )될 수 없다.

Q3. modifier(접근제어자)의 종류와 역할을 설명하고 빈칸을 채우시오. 
public은 (⑦       ) 접근 가능하다. 
private은 (⑧       ) 내에서만 접근 가능하다. 
protected는 (⑨       ) 및 상속 관계에서 접근 가능하다.

Q4. static과 instance의 차이를 설명하고 빈칸을 채우시오. 
static은 클래스에 (⑩       )되고, instance는 객체에 (⑪       )된다. 
static 변수는 모든 객체가 (⑫       )하고, instance 변수는 객체마다 (⑬       )된다.

Q5. 다음 코드에서 static, final, modifier 관련 빈칸을 채우시오.
```java
class Car {
    static String brand = "Hyundai";
    final int wheels = 4;
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public void show() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + this.model);
        System.out.println("Wheels: " + wheels);
    }
}
```
brand는 모든 객체가 (⑭       )하는 클래스 변수이다. 
wheels는 (⑮       )할 수 없는 상수이다. 
model은 외부에서 직접 접근할 수 없도록 (⑯       ) 제어자가 붙어 있다. 
Car 클래스의 생성자는 객체 생성 시 (⑰       )를 초기화한다. 
show() 메서드는 객체의 (⑱       )를 출력한다.




>>>>>>>>>>> Java Answer
✅ 복습문제 (빈칸 채우기 주관식)

Q1. static 키워드의 특징을 설명하고 빈칸을 채우시오. 
static은 클래스에 (① 선언)되어 공유된다. 
객체 생성 없이 (② 클래스) 이름으로 접근 가능하다. 
메모리 영역은 (③ method) area에 저장된다.

Q2. final 키워드의 역할을 설명하고 빈칸을 채우시오. 
final로 선언된 변수는 (④ 재할당)할 수 없다. 
final 메서드는 (⑤ 오버라이딩)할 수 없다. 
final 클래스는 (⑥ 상속)될 수 없다.

Q3. modifier(접근제어자)의 종류와 역할을 설명하고 빈칸을 채우시오. 
public은 (⑦ 모든 클래스) 접근 가능하다. 
private은 (⑧ 클래스 내부) 내에서만 접근 가능하다. 
protected는 (⑨ 같은 패키지) 및 상속 관계에서 접근 가능하다.

Q4. static과 instance의 차이를 설명하고 빈칸을 채우시오. 
static은 클래스에 (⑩ 선언)되고, 
instance는 객체에 (⑪ 포함)된다. 
static 변수는 모든 객체가 (⑫ 공유)하고, 
instance 변수는 객체마다 (⑬ 다르게 설정)된다.

Q5. 다음 코드에서 static, final, modifier 관련 빈칸을 채우시오.
```java
class Car {
    static String brand = "Hyundai";  //   클래스변수 - method area - new X - 생성자 X
    final int wheels = 4;   // 상수 - method area - 변경 x
    private String model;  

    public Car(String model) {
        this.model = model;
    }

    public void show() {  // 인스턴스변수
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + this.model);
        System.out.println("Wheels: " + wheels);
    }
}
```

brand는 모든 객체가 (⑭ 공유)하는 클래스 변수이다. 
wheels는 (⑮ 변경)할 수 없는 상수이다. 
model은 외부에서 직접 접근할 수 없도록 (⑯ private) 제어자가 붙어 있다. 
Car 클래스의 생성자는 객체 생성 시 (⑰ model)을 초기화한다. 
show() 메서드는 객체의 (⑱ 상태)를 출력한다.





# ■ Web Basic 복습문제
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 
  <div class="card-body">
       <pre class="alert alert-warning">
          0. 스크립트는 어디서든 동작 가능
          1. 아이디가 fontSizeBtn인 버튼을 선택
          2. 클릭 시 1~5 사이 숫자 입력받음
          3. 입력한 숫자에 따라 h3 제목 글자 크기 변경
      </pre>
      <input type="button" value="Change Font Size" 
            id="fontSizeBtn" class="btn btn-warning" />
      <script>
        window.addEventListener("load" , function(){  //0. 스크립트는 어디서든 동작 가능
           document.getElementById("fontSizeBtn").onclick = function(){  //  1. 아이디가 fontSizeBtn인 버튼을 선택
              document.getElementById("ex1").style.fontSize = prompt("fontSize선택(1~5)") + "em";
           };
        });
        // 이벤트대상 fontSizeBtn    이벤트 click    = 이벤트핸들러
        // documenet.getElementById("ex1").style.fontSize=  1 + "em";
      </script>  
  </div> 
 