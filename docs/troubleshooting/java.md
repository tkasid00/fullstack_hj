# 🛠️ Java Troubleshooting Notes
> Java 학습/과제 구현 과정에서 발생한 문제를 원인 분석 중심으로 정리한 기록입니다.

---

## 📌 Troubleshooting List

| No | Topic | Status |
|---:|------|:------:|
| 01 | 입력 검증 로직 반복 구조 문제 (continue 흐름 제어) | ✅ |
| 02 | `nextInt()` 이후 `nextLine()` 입력 누락(버퍼 문제) | ✅ |
| 03 | 문자열 비교 오류 (`==` vs `equals`) | ✅ |
| 04 | 상태 기반 레벨 갱신 누락 (실행 타이밍 문제) | ✅ |
| 05 | 2차원 배열 인덱스 초과 및 결과 배열 계산 오류 | ✅ |
| 06 | 반환값 미할당으로 인한 로직 오류 (exec 결과값 누락) | ✅ |
| 07 | 메서드 파라미터 불일치 (필드/파라미터 설계 오류) | ✅ |
| 08 | 삼항연산자 우선순위로 인한 조건 평가 오류 | ✅ |
| 09 | List scope로 인한 데이터 미저장 (생명주기 문제) | ✅ |

---

## 📝 Troubleshooting Details

<details id="error1">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting01 (입력 검증 로직 반복 구조 문제: continue 흐름 제어)</summary>

<p><strong>[Problem]</strong><br>
2번 입력값이 유효하지 않을 경우 1번 입력부터 다시 입력받는 UX 문제가 발생함.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-java">
for(;;) {
  System.out.print("1. 정수를 하나 입력해주세요 >");
  num1 = scanner.nextInt();
  if(num1 &lt; 0 || num1 &gt; 100) { continue; }

  System.out.print("2. 정수를 하나 입력해주세요 >");
  num2 = scanner.nextInt();
  if(num2 &lt; 0 || num2 &gt; 100) { continue; }

  System.out.print("3. 연산자를 입력해주세요(+,-,*,/) >");
  op = scanner.next().charAt(0);
  if(op=='+'|| op=='-'||op=='*'||op=='/'){ continue; }

  break;
}
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
모든 입력 단계를 하나의 무한 루프에 넣고 <code>continue</code>로 흐름을 제어하여, 특정 단계가 실패하면 루프가 처음부터 재시작됨.
</p>

<p><strong>[Solution]</strong><br>
각 입력값이 유효한 경우에만 다음 단계로 진행하도록 조건을 분리하여 개선함.
</p>

<p><strong>[Impressions]</strong><br>
<code>continue</code>는 루프 구조에 따라 UX를 크게 악화시킬 수 있으므로, 입력 단계별 검증 구조를 분리하는 설계가 필요함.
</p>
</details>

---

<details id="error2">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting02 (Scanner 버퍼 문제: nextInt() 이후 nextLine() 입력 누락)</summary>

<p><strong>[Problem]</strong><br>
메뉴 선택을 <code>nextInt()</code>로 입력받은 뒤, 이후 <code>nextLine()</code> 입력이 건너뛰어지는 현상이 발생함.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-java">
a = sc.nextInt();

System.out.print("아이디 입력 : ");
id = sc.nextLine();  // 입력이 스킵됨
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
<code>nextInt()</code>는 숫자만 읽고 줄바꿈(엔터)을 버퍼에 남김.<br>
이후 <code>nextLine()</code>이 버퍼의 줄바꿈을 그대로 읽어버려 실제 입력이 수행되지 않음.
</p>

<p><strong>[Solution]</strong><br>
- <code>next()</code>로 통일하거나<br>
- <code>nextLine()</code> 호출 전 버퍼를 비우기 위해 <code>sc.nextLine()</code>을 추가함.
</p>

<p><strong>[Impressions]</strong><br>
Scanner 입력 메서드 혼용 시 버퍼 동작을 이해하지 못하면 입력 로직이 쉽게 깨짐.
</p>
</details>

---

<details id="error3">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting03 (문자열 비교 오류: == vs equals)</summary>

<p><strong>[Problem]</strong><br>
사용자가 동일한 문자열을 입력했음에도 조건문에서 일치하지 않는 것으로 판정됨.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-java">
if (apple.toUpperCase() == "APPLE") {
    System.out.println("정답입니다");
} else {
    System.out.println("정답이 아닙니다");
}
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
Java에서 <code>==</code>는 문자열 값 비교가 아니라 참조(reference) 비교를 수행함.<br>
<code>toUpperCase()</code>는 새로운 String 객체를 반환할 수 있어 참조가 달라짐.
</p>

<p><strong>[Solution]</strong><br>
문자열 값 비교는 <code>equals()</code>로 수행함.
</p>

<pre><code class="language-java">
if (apple.toUpperCase().equals("APPLE")) {
    System.out.println("정답입니다");
}
</code></pre>

<p><strong>[Impressions]</strong><br>
문자열 비교는 무조건 <code>equals</code> 계열로 수행해야 논리 오류를 예방할 수 있음.
</p>
</details>

---

<details id="error4">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting04 (레벨 갱신 누락: 상태 기반 로직 실행 타이밍 문제)</summary>

<p><strong>[Problem]</strong><br>
상태 값이 변경되어도 레벨(lv)이 갱신되지 않고 계속 1로 유지되는 문제가 발생함.
</p>

<p><strong>[Cause Analysis]</strong><br>
lv 계산 로직이 main() 시작 부분에서 1회만 실행되고, 상태 변화 이후 재평가되지 않음.
</p>

<p><strong>[Solution]</strong><br>
상태 값 변경 이후 lv 계산을 다시 수행하도록 구조를 개선하고, 조건을 상위 레벨부터 역순으로 평가하도록 수정함.
</p>

<p><strong>[Impressions]</strong><br>
상태 기반 로직은 “값 변화 이후 재평가”가 필수이며, 실행 타이밍을 잘못 잡으면 논리 오류가 발생함.
</p>
</details>

---

<details id="error5">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting05 (2차원 배열 인덱스 초과: 결과 배열 크기 확장 처리)</summary>

<p><strong>[Problem]</strong><br>
배열 크기를 확장한 result에 값을 복사하는 과정에서 인덱스 초과 예외가 발생함.
</p>

<p><strong>[Cause Analysis]</strong><br>
result 배열의 크기는 datas보다 크지만, <code>datas[i][j]</code>를 그대로 참조하여 범위를 벗어나는 순간 예외 발생.
</p>

<p><strong>[Solution]</strong><br>
데이터 복사 루프는 datas 범위까지만 수행하고,<br>
초과 영역(합계 계산 등)은 별도 루프로 처리함.
</p>

<p><strong>[Impressions]</strong><br>
2차원 배열은 행/열 길이 혼동이 잦아 범위 분리가 중요함.
</p>
</details>

---

<details id="error6">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting06 (반환값 미할당: exec() 결과값 누락)</summary>

<p><strong>[Problem]</strong><br>
exec() 메서드가 반환한 결과값을 변수에 저장하지 않아 이후 로직이 정상 동작하지 않음.
</p>

<p><strong>[Cause Analysis]</strong><br>
반환값이 필요한 흐름 제어 로직인데 호출만 하고 값을 받지 않아 기본값이 그대로 유지됨.
</p>

<p><strong>[Solution]</strong><br>
반환값을 변수에 저장하여 로직 연결을 보장함.
</p>

<p><strong>[Impressions]</strong><br>
메서드가 return을 가지는 구조라면 “호출”이 아니라 “값을 받아 흐름을 이어가는 것”이 핵심임.
</p>
</details>

---

<details id="error7">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting07 (메서드 파라미터 불일치: 필드/파라미터 설계 오류)</summary>

<p><strong>[Problem]</strong><br>
메서드는 다수의 파라미터를 요구하지만 호출부는 인자 없이 호출해 컴파일 오류가 발생함.
</p>

<p><strong>[Cause Analysis]</strong><br>
이미 클래스 필드로 존재하는 값을 불필요하게 파라미터로 중복 선언하면서 호출 구조가 깨짐.
</p>

<p><strong>[Solution]</strong><br>
필드 기반으로 동작하도록 lvup()을 인자 없는 메서드로 재설계하여 호출 일관성을 확보함.
</p>

<p><strong>[Impressions]</strong><br>
객체지향에서는 필드/메서드 역할이 분명해야 호출 구조가 단순해짐.
</p>
</details>

---

<details id="error8">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting08 (삼항연산자 우선순위 오류: 중첩 조건 평가 문제)</summary>

<p><strong>[Problem]</strong><br>
평균이 높아도 결과가 “불합격”으로 판정되는 논리 오류가 발생함.
</p>

<p><strong>[Cause Analysis]</strong><br>
삼항 연산자 중첩 시 우선순위가 직관적이지 않아 의도와 다른 방향으로 조건이 평가됨.
</p>

<p><strong>[Solution]</strong><br>
조건을 괄호로 명확히 하거나 if-else로 분리하여 평가 순서를 고정함.
</p>

<p><strong>[Impressions]</strong><br>
삼항 연산자는 짧을 때만 유효하며, 복잡 조건은 분기문으로 분리하는 것이 안전함.
</p>
</details>

---

<details id="error9">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting09 (List scope 오류: 반복문 내부 선언으로 데이터 미저장)</summary>

<p><strong>[Problem]</strong><br>
List에 데이터를 추가해도 반복 실행 시 데이터가 유지되지 않음.
</p>

<p><strong>[Cause Analysis]</strong><br>
List를 반복문 내부에서 선언하여, 루프가 재시작될 때마다 새로운 객체가 생성됨.
</p>

<p><strong>[Solution]</strong><br>
List 선언을 반복문 밖으로 이동하여 실행 동안 동일 객체를 유지함.
</p>

<p><strong>[Impressions]</strong><br>
컬렉션은 선언 위치에 따라 생명주기가 달라지며, scope는 곧 데이터 유지 여부를 결정함.
</p>
</details>  