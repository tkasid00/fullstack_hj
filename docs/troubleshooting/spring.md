# 🛠️ Spring (MVC/MyBatis/AJAX) Troubleshooting Notes
> Spring MVC 기반 프로젝트 구현 과정에서 발생한 이슈를 원인 분석 중심으로 정리한 기록입니다.

---

## 📌 Troubleshooting List

| No | Topic | Status |
|---:|------|:------:|
| 01 | @ContextConfiguration 경로 지정 오류 | ✅ |
| 02 | Spring Bean 태그 구조 오류 (XML) | ✅ |
| 03 | multipartResolver Bean id 설정 오류 | ✅ |
| 04 | redirect 경로 지정 오류로 인한 404 (POST → GET) | ✅ |
| 05 | MyBatis INSERT 구문 파싱/매핑 오류 | ✅ |
| 06 | jQuery `data()` key 처리 오류(undefined) | ✅ |
| 07 | JSP 환경에서 JS 문자열 내부 주석으로 인한 파싱 오류 | ✅ |
| 08 | MyBatis 파라미터 타입 불일치(HashMap 매핑) | ✅ |
| 09 | 동일 파일명 업로드 덮어쓰기 문제 | ✅ |
| 10 | 다중 이미지 업로드 불가(multiple 속성 누락) | ✅ |
| 11 | MVC → AJAX 전환 시 JS 로직이 HTML 문자열로 출력됨 | ✅ |
| 12 | 템플릿 리터럴 `${}` vs JSP EL 충돌 | ✅ |

---

## 📝 Troubleshooting Details

<details id="error1">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting01 (@ContextConfiguration 경로 지정 오류)</summary>

<p><strong>[Problem]</strong><br>
단위 테스트 실행 시 스프링 설정 파일(beans.xml)을 찾지 못해 ApplicationContext 로드 실패 발생.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-java">
@ContextConfiguration(locations="classpath:config/beans.xml")

Caused by: java.io.FileNotFoundException:
class path resource [config/beans.xml] cannot be opened
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
설정 파일이 <code>src/main/resources</code> 하위 패키지 경로(<code>com/thejoa703/config/</code>)에 존재했으나,<br>
classpath 지정 시 패키지 구조를 포함하지 않아 리소스를 찾지 못함.
</p>

<p><strong>[Solution]</strong><br>
실제 리소스 경로를 포함해 지정:
</p>

<pre><code class="language-java">
@ContextConfiguration(locations="classpath:com/thejoa703/config/beans.xml")
</code></pre>

<p><strong>[Impressions]</strong><br>
classpath는 resources 기준이지만 하위 패키지 구조까지 포함해야 하므로, 실제 빌드 결과(/target/classes)를 기준으로 확인하는 습관이 필요함.
</p>
</details>

---

<details id="error2">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting02 (Spring Bean 태그 구조 오류)</summary>

<p><strong>[Problem]</strong><br>
beans.xml에서 bean 등록 후 property를 bean 외부에 작성하여 빈 파싱 오류가 발생함.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-xml">
&lt;bean id="animalFarm3" class="com.company.ioctest3.AnimalFarm3" /&gt;
&lt;property name="name" value="nana"&gt;&lt;/property&gt;
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
<code>&lt;property&gt;</code>는 특정 빈 정의 범위(<code>&lt;bean&gt;...&lt;/bean&gt;</code>) 내부에 포함되어야 하는데,<br>
bean 닫힘 태그 이후에 배치되어 매핑 대상이 없는 독립 요소로 해석됨.
</p>

<p><strong>[Solution]</strong><br>
property를 bean 내부로 이동:
</p>

<pre><code class="language-xml">
&lt;bean id="animalFarm3" class="com.company.ioctest3.AnimalFarm3"&gt;
  &lt;property name="name" value="nana"&gt;&lt;/property&gt;
  &lt;property name="ani" value="cat"&gt;&lt;/property&gt;
&lt;/bean&gt;
</code></pre>

<p><strong>[Impressions]</strong><br>
XML 기반 설정은 태그 구조 자체가 실행 로직이므로, 닫는 태그 위치 하나로도 빈 등록이 실패할 수 있음.
</p>
</details>

---

<details id="error3">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting03 (Bean id 설정 오류: multipartResolver)</summary>

<p><strong>[Problem]</strong><br>
파일 업로드 처리를 위해 CommonsMultipartResolver를 등록했으나 업로드가 동작하지 않음.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-xml">
&lt;bean id="multipart" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"&gt;
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
Spring MVC는 multipart 요청 처리를 위해 내부적으로 <code>multipartResolver</code>라는 고정 Bean id를 탐색함.<br>
id가 다르면 업로드 요청을 multipart로 파싱하지 못해 기능이 적용되지 않음.
</p>

<p><strong>[Solution]</strong><br>
Bean id를 정확히 맞춤:
</p>

<pre><code class="language-xml">
&lt;bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"&gt;
</code></pre>

<p><strong>[Impressions]</strong><br>
Spring은 특정 기능을 Bean 이름 규칙으로 자동 탐색하는 경우가 많아, id 규칙 미준수는 기능 미동작으로 바로 연결됨.
</p>
</details>

---

<details id="error4">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting04 (redirect 경로 지정 오류: POST 매핑으로 redirect 시 404)</summary>

<p><strong>[Problem]</strong><br>
POST 요청 실패 시 POST URL로 redirect를 걸어 404 Not Found가 발생함.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-java">
return "redirect:/editwithimg.users";
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
<code>redirect:</code>는 항상 새로운 GET 요청을 발생시키는데,<br>
해당 URL이 POST 전용 매핑만 존재하여 GET 요청 시 404가 발생함.
</p>

<p><strong>[Solution]</strong><br>
GET 매핑이 존재하는 수정 페이지로 redirect:
</p>

<pre><code class="language-java">
return "redirect:/edit.users?appUserId=" + dto.getAppUserId();
</code></pre>

<p><strong>[Impressions]</strong><br>
redirect는 “요청 메서드가 바뀐다(GET)”가 전제이므로, redirect 대상 URL은 반드시 GET 매핑이 존재해야 함.
</p>
</details>

---

<details id="error5">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting05 (MyBatis INSERT 구문 파싱/매핑 오류)</summary>

<p><strong>[Problem]</strong><br>
MyBatis XML에서 INSERT문을 길게 작성한 상태에서 일부 파라미터가 누락된 것처럼 인식되며 오류가 발생함.
</p>

<p><strong>[Cause Analysis]</strong><br>
XML 기반 DSL 특성상 SQL/파라미터가 과도하게 길거나 구조가 불명확하면 파싱/디버깅이 어려워지고,<br>
실제 파라미터 매핑 에러(누락처럼 보이는 현상)로 이어질 수 있음.
</p>

<p><strong>[Solution]</strong><br>
컬럼/VALUES를 줄 단위로 분리하여 구조적으로 정리함.
</p>

<p><strong>[Impressions]</strong><br>
복잡한 INSERT/UPDATE는 “가독성”이 곧 “파싱 안정성”이며 유지보수 비용을 줄이는 핵심임.
</p>
</details>

---

<details id="error6">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting06 (jQuery data() 키 처리 오류: undefined)</summary>

<p><strong>[Problem]</strong><br>
클릭한 요소의 <code>data-foodid</code> 값을 가져오려 했으나 undefined가 반환됨.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-js">
let foodid = $(this).data(foodid);  // ❌
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
<code>data()</code>는 key를 문자열로 받아야 하는데 변수처럼 전달되어 정의되지 않은 식별자로 처리됨.
</p>

<p><strong>[Solution]</strong><br>
문자열 key 사용:
</p>

<pre><code class="language-js">
let foodid = $(this).data("foodid");
</code></pre>

<p><strong>[Impressions]</strong><br>
DOM의 data-* 속성은 JS와 연결되는 계약(contract)이므로 key 문자열 관리가 중요함.
</p>
</details>

---

<details id="error7">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting07 (JS 문자열 내부 주석으로 인한 파싱 오류: JSP 환경)</summary>

<p><strong>[Problem]</strong><br>
JS에서 HTML 문자열을 조립하는 코드에 주석을 넣는 과정에서 스크립트 오류가 발생함.
</p>

<p><strong>[Cause Analysis]</strong><br>
JSP는 브라우저 전달 전에 서버에서 먼저 파싱되며,<br>
주석 내부라도 <code>${}</code> 형태가 존재하면 EL로 인식되어 충돌/오류가 발생할 수 있음.
</p>

<p><strong>[Solution]</strong><br>
JSP 내 스크립트에서 <code>${}</code>가 포함된 주석 제거 또는 <code>\${}</code>로 회피 처리.
</p>

<p><strong>[Impressions]</strong><br>
JSP + JS 혼합 환경은 문법 경계가 겹치므로 템플릿 문법 충돌을 항상 고려해야 함.
</p>
</details>

---

<details id="error8">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting08 (MyBatis 파라미터 타입 불일치: HashMap 매핑)</summary>

<p><strong>[Problem]</strong><br>
MyBatis 파라미터를 <code>HashMap&lt;String, Integer&gt;</code>로 전달 시 매핑 오류 발생.
</p>

<p><strong>[Cause Analysis]</strong><br>
MyBatis 파라미터 맵은 일반적으로 <code>HashMap&lt;String, Object&gt;</code> 형태를 전제로 하며,<br>
드라이버/타입 변환 과정에서 특정 타입 고정(Integer)이 매핑 충돌을 유발할 수 있음.
</p>

<p><strong>[Solution]</strong><br>
파라미터 타입을 표준 형태로 변경:
</p>

<pre><code class="language-java">
HashMap&lt;String, Object&gt; para = new HashMap&lt;&gt;();
</code></pre>

<p><strong>[Impressions]</strong><br>
MyBatis는 “유연성”이 강점이라 파라미터 타입도 Object 기반이 안정적임.
</p>
</details>

---

<details id="error9">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting09 (동일 파일명 업로드 덮어쓰기 문제)</summary>

<p><strong>[Problem]</strong><br>
동일한 파일명이 업로드될 때 서버 저장 과정에서 덮어쓰기/저장 실패 문제가 발생함.
</p>

<p><strong>[Cause Analysis]</strong><br>
<code>getOriginalFilename()</code>는 중복 가능성이 높아 서버 저장 파일명으로 부적절함.
</p>

<p><strong>[Solution]</strong><br>
UUID를 파일명에 결합하여 유일성 확보:
</p>

<p><strong>[Impressions]</strong><br>
업로드는 “기능 구현”보다 “운영 안정성(중복/보안/경로)”까지 포함해서 설계해야 함.
</p>
</details>

---

<details id="error10">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting10 (다중 이미지 업로드 불가: multiple 속성 누락)</summary>

<p><strong>[Problem]</strong><br>
여러 장의 이미지를 동시에 업로드할 수 없음.
</p>

<p><strong>[Cause Analysis]</strong><br>
file input에 <code>multiple</code> 속성이 없으면 브라우저가 단일 파일만 선택하도록 제한함.
</p>

<p><strong>[Solution]</strong><br>
file input에 multiple 추가:
</p>

<p><strong>[Impressions]</strong><br>
파일 업로드는 프론트(input 속성)와 백엔드(MultipartFile[] 처리)가 함께 맞아야 정상 동작함.
</p>
</details>

---

<details id="error11">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting11 (MVC → AJAX 전환: JS 코드가 HTML 문자열로 출력됨)</summary>

<p><strong>[Problem]</strong><br>
AJAX 렌더링 전환 중 JS 로직이 DOM 내부에서 실행되지 않고 HTML에 문자열로 그대로 출력됨.
</p>

<p><strong>[Cause Analysis]</strong><br>
MVC(JSP) 방식에서는 HTML 안 내용이 그대로 렌더링되므로,<br>
AJAX로 전환할 때는 반드시 JS 로직을 JS 영역에서 수행한 후 문자열을 DOM에 삽입해야 함.
</p>

<p><strong>[Solution]</strong><br>
로직(조건/반복)을 JS 영역으로 이동 후 최종 HTML만 append/html로 삽입.
</p>

<p><strong>[Impressions]</strong><br>
AJAX 렌더링은 “데이터 → JS 처리 → DOM 삽입” 구조로 설계해야 함.
</p>
</details>

---

<details id="error12">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting12 (템플릿 리터럴 ${} vs JSP EL 충돌)</summary>

<p><strong>[Problem]</strong><br>
템플릿 리터럴 내 <code>${...}</code> 문법이 JSP EL로 먼저 처리되어 실행 오류가 발생함.
</p>

<p><strong>[Cause Analysis]</strong><br>
JSP는 서버에서 EL(Expression Language)을 먼저 해석하므로,<br>
JS 템플릿 리터럴의 <code>${}</code>와 충돌 가능성이 매우 높음.
</p>

<p><strong>[Solution]</strong><br>
EL로 처리되지 않도록 escape 처리:
</p>
<pre><code class="language-jsp">
\${ratingToStar(review.rating)}
</code></pre>

<p><strong>[Impressions]</strong><br>
JSP+JS 혼합 환경에서는 서버 템플릿(EL)과 프론트 템플릿(JS)의 문법 충돌을 항상 고려해야 함.
</p>
</details>