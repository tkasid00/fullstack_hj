## 📚 day023 복습   


# ■ WEB BASIC
# ■ WEB BASIC 복습문제
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
</div>
 


 

# ■ Java 복습문제
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

Q1. 클래스와 인스턴스의 관계를 설명하시오
클래스는 객체를 만들기 위한 (①     ) 역할을 한다.
인스턴스는 클래스의 구조를 기반으로 (②     ) 되어 메모리에 생성된 실체이다.
같은 클래스라도 인스턴스는 서로 다른 (③     ) 값을 가질 수 있다.

Q2. 다음 코드의 실행 결과와 메모리 구조를 설명하시오
```java
Car myCar = new Car("Hyundai", 2023);
```
new Car(...)는 객체를 생성하고 (④     ) 영역에 저장된다.
myCar는 해당 객체의 (⑤     ) 를 참조한다.
생성자 내부에서는 전달받은 값을 (⑥     ) 한다.

Q3. 생성자에 대한 설명으로 옳은 것을 고르시오
생성자는 클래스명과 (⑦     ) 이 같아야 한다.
생성자는 객체 생성 시 자동으로 (⑧     ) 된다.
생성자는 반환값이 (⑨     )

Q4. 기본 생성자가 자동으로 생성되지 않는 경우는?
클래스에 (⑩     ) 생성자가 이미 정의되어 있을 경우
상속받은 클래스에서 부모 생성자 호출이 필요한 경우

Q5. 다음 코드에서 객체가 저장되는 메모리 영역과 메서드 실행 흐름을 설명하시오
```java
Book b1 = new Book("Java", 500);
Book b2 = new Book();
b2.setTitle("Spring");
```
Book 클래스의 인스턴스는 (⑪     ) 영역에 저장된다.
b1, b2는 각각 객체의 (⑫     ) 를 참조한다.
setTitle() 메서드는 (⑬     ) 영역에서 실행된다.

Q6. 자바 메모리 구조에서 각 영역의 역할을 설명하시오
Method Area : 클래스 정보 및 static 변수 저장
Heap Area : (⑭     ) 저장, GC가 관리
Stack Area : (⑮     ) 저장, 메서드 호출 시 사용됨

Q7. 변수의 종류와 메모리 위치를 연결하시오
클래스 변수 → (⑯     ) 영역
인스턴스 변수 → (⑰     ) 영역
지역 변수 → (⑱     ) 영역

Q8. 접근자를 넓은 범위에서 좁은 범위로 적으시오
(⑲   → ⑳   → ㉑   → ㉒  )

Q9. 다음을 private으로 설정했다. 외부에서 접근 가능하게 설정해야 하는 것
(㉓   / ㉔  ) 이다.
 


>>>>>>>>>>> Java Answer
Q1. 클래스와 인스턴스의 관계를 설명하시오
클래스는 객체를 만들기 위한 (① 설계도) 역할을 한다.
인스턴스는 클래스의 구조를 기반으로 (② 실체화) 되어 메모리에 생성된 실체이다.
같은 클래스라도 인스턴스는 서로 다른 (③ 특징) 값을 가질 수 있다.

Q2. 다음 코드의 실행 결과와 메모리 구조를 설명하시오
```java
Car myCar = new Car("Hyundai", 2023);
```
new Car(...)는 객체를 생성하고 (④ heap) 영역에 저장된다.
myCar는 해당 객체의 (⑤ 주소) 를 참조한다.
생성자 내부에서는 전달받은 값을 (⑥ 초기화) 한다.

Q3. 생성자에 대한 설명으로 옳은 것을 고르시오
생성자는 클래스명과 (⑦ 동일한 이름) 이 같아야 한다.
생성자는 객체 생성 시 자동으로 (⑧ 호출) 된다.
생성자는 반환값이 (⑨ 없다)

Q4. 기본 생성자가 자동으로 생성되지 않는 경우는?
클래스에 (⑩ 오버로딩된 생성자) 생성자가 이미 정의되어 있을 경우
상속받은 클래스에서 부모 생성자 호출이 필요한 경우

Q5. 다음 코드에서 객체가 저장되는 메모리 영역과 메서드 실행 흐름을 설명하시오
```java
Book b1 = new Book("Java", 500);
Book b2 = new Book();
b2.setTitle("Spring");
```
Book 클래스의 인스턴스는 (⑪ heap) 영역에 저장된다.
b1, b2는 각각 객체의 (⑫ 참조 주소) 를 참조한다.
setTitle() 메서드는 (⑬ stack) 영역에서 실행된다.

Q6. 자바 메모리 구조에서 각 영역의 역할을 설명하시오
Method Area : 클래스 정보 및 static 변수 저장
Heap Area : (⑭ 인스턴스 객체) 저장, GC가 관리
Stack Area : (⑮ 지역 변수 및 메서드 작업 공간) 저장, 메서드 호출 시 사용됨

Q7. 변수의 종류와 메모리 위치를 연결하시오
클래스 변수 → (⑯ method area) 영역
인스턴스 변수 → (⑰ heap area) 영역
지역 변수 → (⑱ stack area) 영역

Q8. 접근자를 넓은 범위에서 좁은 범위로 적으시오
(⑲ public → ⑳ protected → ㉑ default → ㉒ private)

Q9. 다음을 private으로 설정했다. 외부에서 접근 가능하게 설정해야 하는 것
(㉓ getter / ㉔ setter) 이다.


# ■ Web Basic 복습문제
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
> repeat24.html
```
 <div class="card-body">
    <h4>EX</h4>
    <input type="button"  value="click"         id="test1"    class="btn btn-success"   />
    <input type="button"  value="value"         id="test2"    class="btn btn-success"   />
    <input type="button"  value="innerHtml"     id="test3"    class="btn btn-success"   /> 
    <div class="result_target  my-5">JAVASCRIPT</div>
    <pre>
    브라우저가 로딩이 되면
    Q1) #test1를 클릭하면 본인이름 입력받고 입력받은 값 알림창 띄우기
    Q2) #test2를 클릭하면 #test2의 value값을 INPUT으로 수정
    Q3) #test3를 클릭하면
    1.  .result_target영역안의 문자열을 알림창으로 띄우고
    2.  .result_target영역안을 본인이름으로 수정

    </pre>
    <script>
      
    </script>
  </div>
  ```