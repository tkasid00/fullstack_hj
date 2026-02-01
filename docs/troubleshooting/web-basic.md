# 🛠️ Web Basic Troubleshooting Notes
> HTML/CSS/JavaScript 학습 과정에서 발생한 문제를 원인 분석 중심으로 정리한 기록입니다.

---

## 📌 Troubleshooting List

| No | Topic | Status |
|---:|------|:------:|
| 01 | 이미지 경로 오류 (절대경로 사용) | ✅ |
| 02 | CSS 선택자 미적용 (띄어쓰기 선택자) | ✅ |
| 03 | 배경 속성 충돌 (background-image vs background-color) | ✅ |
| 04 | 애니메이션 미작동 (z-index 레이어 문제) | ✅ |
| 05 | 회전 각도 누락/누적 회전 오류 (transform + 연산식 처리) | ✅ |
| 06 | 파일 경로 인식 오류 (`pathspec did not match`) | ✅ |

---

## 📝 Troubleshooting Details

<details id="error1">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting01 (이미지 경로 오류: 절대 경로 사용)</summary>

<p><strong>[Problem]</strong><br>
이미지가 화면에 표시되지 않음.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-html">
&lt;p&gt;
  &lt;img src="C:\HYUNJU\five.png"
       style="width:10%"
       alt="프로필 사진"/&gt;
&lt;/p&gt;
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
이미지 경로를 PC 절대 경로로 작성하여 브라우저가 해당 파일을 찾지 못함.<br>
웹페이지는 서버/프로젝트 기준으로 접근 가능한 상대 경로 리소스만 정상적으로 표시됨.
</p>

<p><strong>[Solution]</strong><br>
이미지를 프로젝트 폴더(워크스페이스) 내부로 이동 후, 상대 경로로 수정하여 표시되도록 처리함.
</p>

<p><strong>[Impressions]</strong><br>
정적 리소스는 프로젝트 폴더 기준으로 관리해야 하며, 경로 설계가 화면 출력의 핵심임을 학습함.
</p>
</details>

---

<details id="error2">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting02 (CSS 선택자 미적용: 띄어쓰기 의미 차이)</summary>

<p><strong>[Problem]</strong><br>
CSS 선택자가 의도대로 적용되지 않음.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-html">
&lt;div class="container mission"&gt;
  &lt;p&gt;📦 이 박스는 margin과 padding을 통해 우주 공간을 확보했어요!&lt;/p&gt;
&lt;/div&gt;
</code></pre>

<pre><code class="language-css">
.container .mission {
  margin: 30px;
  padding: 20px;
  background-color: #2980b9;
  border-radius: 10px;
}
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
<code>.container .mission</code>은 <code>.container</code> 내부의 자식 요소 <code>.mission</code>을 의미하지만,<br>
실제 HTML은 하나의 요소가 <code>container</code>와 <code>mission</code> 클래스를 동시에 보유하고 있어 선택자가 불일치함.
</p>

<p><strong>[Solution]</strong><br>
동일 요소의 복수 클래스 선택자로 변경:
</p>

<pre><code class="language-css">
.container.mission {
  margin: 30px;
  padding: 20px;
  background-color: #2980b9;
  border-radius: 10px;
}
</code></pre>

<p><strong>[Impressions]</strong><br>
CSS 선택자의 띄어쓰기 유무는 의미가 완전히 달라지므로, 구조를 먼저 확인하고 선택자를 작성해야 함.
</p>
</details>

---

<details id="error3">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting03 (배경 속성 충돌: background-image vs background-color)</summary>

<p><strong>[Problem]</strong><br>
요소에 지정한 단색 배경색이 의도대로 보이지 않고 그라데이션이 덮어씌워져 출력됨.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-css">
.item {
  background-image: linear-gradient(135deg, #584545, #fff);
  color: #201919;
  padding: 5px;
}

.i1 {
  background-color: #e6cdcd;
}
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
CSS에서 <code>background-image</code>는 <code>background-color</code> 위에 렌더링되므로,<br>
<code>.i1</code>에서 <code>background-color</code>만 지정하면 그라데이션을 덮지 못함.
</p>

<p><strong>[Solution]</strong><br>
그라데이션 제거 후 단색 배경 적용:
</p>

<pre><code class="language-css">
.i1 {
  background-image: none;
  background-color: #e6cdcd;
}
</code></pre>

<p><strong>[Impressions]</strong><br>
배경 관련 속성은 우선순위/겹침 규칙을 이해하고 설계해야 UI가 안정적으로 유지됨.
</p>
</details>

---

<details id="error4">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting04 (애니메이션 미작동: z-index 레이어 문제)</summary>

<p><strong>[Problem]</strong><br>
bubble 애니메이션을 적용했으나 요소가 보이지 않거나 애니메이션이 실행되지 않는 것처럼 보임.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-css">
.bubble {
  position: fixed;
  bottom: -100px;
  animation: rise 8s infinite ease-in;
  z-index: 0;
}
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
다른 UI 요소들이 더 높은 z-index를 가지고 있어 bubble 요소가 뒤로 가려짐.
</p>

<p><strong>[Solution]</strong><br>
bubble 요소의 <code>z-index</code>를 충분히 높여 레이어 상단으로 배치함.
</p>

<p><strong>[Impressions]</strong><br>
애니메이션이 “안 보일 때”는 keyframes보다 먼저 레이어 순서(z-index)를 점검해야 함.
</p>
</details>

---

<details id="error5">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting05 (회전 각도 누락/누적 회전 오류: transform 연산식 처리)</summary>

<p><strong>[Problem]</strong><br>
클릭 이벤트마다 회전이 누적되지 않거나, 각도 연산이 정상 수행되지 않음.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-js">
// 1회 회전만 되는 코드
target2.style.transform = "rotate(45deg)";

// 문자열 결합으로 오류 발생
let cnt = 0;
target2.style.transform = "rotate(" + "--cnt*45" + "deg)";
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
- 고정값 <code>45deg</code>만 적용하면 누적 회전 불가<br>
- 연산식이 문자열로 처리되어 숫자 계산이 수행되지 않음
</p>

<p><strong>[Solution]</strong><br>
연산식을 괄호로 묶어 실제 계산 결과를 문자열로 조합:
</p>

<pre><code class="language-js">
let cnt = 0;
target2.style.transform = "rotate(" + (--cnt * 45) + "deg)";
</code></pre>

<p><strong>[Impressions]</strong><br>
DOM 스타일 제어는 문자열 결합이 전제이므로, “연산값”과 “문자열”의 구분이 핵심임.
</p>
</details>

---

<details id="error6">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting06 (파일 경로 인식 오류: pathspec did not match)</summary>

<p><strong>[Problem]</strong><br>
특정 파일을 이전 커밋 상태로 되돌리기 위해 <code>git restore</code>를 수행했으나, 파일 경로를 인식하지 못하는 오류 발생.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-bash">
git restore --source=HEAD~1 day034.md
error: pathspec 'day034.md' did not match any file(s) known to git
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
파일이 하위 폴더 내부에 존재했으며, Git은 경로/대소문자/공백을 엄격하게 구분하여 경로 불일치로 오류가 발생함.
</p>

<p><strong>[Solution]</strong><br>
파일의 전체 경로를 포함해 restore 수행:
</p>

<pre><code class="language-bash">
git restore --source=HEAD~1 "days_Class Notes/day034.md"
</code></pre>

<p><strong>[Impressions]</strong><br>
파일 조작 Git 명령은 실행 전 <code>git status</code>, <code>git ls-files</code>로 경로 확인이 우선되어야 함.
</p>
</details>