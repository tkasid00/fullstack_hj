# 🛠️ Oracle Troubleshooting Notes
> Oracle SQL 작성 및 데이터 처리 과정에서 발생한 오류를 원인 분석 중심으로 정리한 기록입니다.

---

## 📌 Troubleshooting List

| No | Topic | Status |
|---:|------|:------:|
| 01 | NVL 함수 데이터 타입 불일치 (NUMBER ↔ VARCHAR2) | ✅ |
| 02 | TO_NUMBER 변환 오류 (format model 누락) | ✅ |
| 03 | SUM 함수와 ALL 키워드 혼용 구문 오류 | ✅ |

---

## 📝 Troubleshooting Details

<details id="error1">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting01 (NVL 함수 데이터 타입 불일치)</summary>

<p><strong>[Problem]</strong><br>
NUMBER 타입 컬럼에 대해 NVL 기본값을 문자열로 지정하면서 오류가 발생함.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-sql">
SELECT NVL(COMM, '입력 안됨') FROM EMP;
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
Oracle의 <code>NVL(expr1, expr2)</code>은 두 인자의 데이터 타입이 동일해야 함.<br>
COMM은 NUMBER, '입력 안됨'은 VARCHAR2이므로 자동 변환이 불가하여 datatype mismatch / invalid number 오류가 발생함.
</p>

<p><strong>[Solution]</strong><br>
숫자 컬럼을 문자열로 변환한 뒤 NVL 적용:
</p>
<pre><code class="language-sql">
SELECT NVL(TO_CHAR(COMM), '입력 안됨') FROM EMP;
</code></pre>

<p><strong>[Impressions]</strong><br>
NVL은 단순 null 치환 함수처럼 보여도 타입 일치가 필수이므로, 컬럼 타입을 먼저 확인하는 습관이 필요함.
</p>
</details>

---

<details id="error2">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting02 (TO_NUMBER 변환 오류: 포맷 지정 누락)</summary>

<p><strong>[Problem]</strong><br>
쉼표가 포함된 숫자 문자열을 <code>TO_NUMBER</code>로 변환하는 과정에서 변환 오류가 발생함.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-sql">
TO_NUMBER('1,500') - TO_NUMBER('1,300')
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
<code>'1,500'</code>처럼 쉼표가 포함된 문자열은 기본 숫자 형태로 인식되지 않음.<br>
Oracle 변환 함수는 format model을 엄격하게 적용하므로 서식이 포함된 문자열은 포맷을 지정해야 변환 가능함.
</p>

<p><strong>[Solution]</strong><br>
format model을 포함하여 변환:
</p>
<pre><code class="language-sql">
TO_NUMBER('1,500', '999,999') - TO_NUMBER('1,300', '999,999')
</code></pre>

<p><strong>[Impressions]</strong><br>
TO_NUMBER/TO_CHAR는 단순 캐스팅이 아니라 “서식 기반 변환”이므로, 포맷이 섞이면 반드시 format model을 명시해야 함.
</p>
</details>

---

<details id="error3">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting03 (SUM 함수와 ALL 키워드 혼용 구문 오류)</summary>

<p><strong>[Problem]</strong><br>
집계 함수에서 ALL을 잘못된 위치로 사용하여 구문 오류가 발생함.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-sql">
SELECT SUM(ALL(SAL)) FROM EMP;
-- ORA-00907: missing right parenthesis
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
SUM/AVG/COUNT 집계 함수는 기본 옵션이 ALL이라 <code>SUM(SAL)</code> 자체가 ALL과 동일한 의미임.<br>
또한 Oracle 문법에서 ALL/DISTINCT는 괄호 안에 함수처럼 넣는 방식(<code>ALL(...)</code>)이 아니라, 인자에 직접 적용되는 키워드임.
</p>

<p><strong>[Solution]</strong><br>
기본 형태로 작성:
</p>
<pre><code class="language-sql">
SELECT SUM(SAL) FROM EMP;
</code></pre>

<p><strong>[Impressions]</strong><br>
SQL은 괄호/키워드 위치가 조금만 어긋나도 즉시 ORA 오류가 발생하므로, 함수 문법 구조 자체를 정확히 숙지해야 함.
</p>
</details>