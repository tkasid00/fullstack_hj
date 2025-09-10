# 🚀 박현주 | 실전 프로젝트 중심 풀스택 포트폴리오

> 코드를 넘어 흐름을 설계하는 개발자.  
**기획 → 구현 → 배포**, 전 과정을 주도한 실전형 풀스택 포트폴리오

***문제 해결 중심 사고**와 **협업 경험**으로  
실무에 가까운 프로젝트를 직접 구현했습니다.*

<br/>
<br/>

---
## 💡Contact & Links
<img src="./img/friends/me.gif"
    alt="프로필" width="100"/>

|||
|-|-|
|**NAME**|박현주|
|**EMAIL**|tkasid00@gmail.com|
|**GITHUB**|https://github.com/tkasid00/fullstack_hj|


---
## ✨Golds
- HTML/CSS 기본 구조와 태그의 역할을 정확히 이해하고 실습을 통한 웹페이지 구현 역량 강화
- 다양한 레이아웃과 스타일링 기법을 적용하여 사용자 친화적인 UI/UX 설계 경험
- 이미지, 링크, 폰트 등 웹 요소의 활용과 오류 해결을 통한 실전 문제 해결 능력 향상
- 웹 표준과 접근성을 고려한 코드 작성 습관 및 유지보수 역량 강화
---
## ✔기술 스택 기반 CS 역량
---
## 😱트러블슈팅(Web_basic 발생)

<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅01(이미지 경로 오류)</summary>

    
**[문제점]**  
 이미지가 화면에 표시되지 않음.

**[오류 코드/상황]**  
```html
<p> <img src="C:\HYUNJU\five.png"
         style="width:10%"
         alt="프로필 사진"/></p>
```

**[원인 분석]**  
- 이미지 경로를 절대 경로(내 컴퓨터의 경로)로 작성하여 웹 브라우저가 해당 파일을 찾지 못함.
- 웹페이지는 서버 또는 프로젝트 폴더 기준의 상대 경로만 인식함.

**[해결 방안]**  
- 이미지를 프로젝트 폴더(워크스페이스) 안에 복사한 후 상대 경로로 작성하여 정상적으로 표시되도록 수정함.

**[느낀점]**  
- HTML에서 이미지는 반드시 프로젝트 폴더 내에 위치시키고 상대 경로로 연결해야 함을 알게 됨.
- 경로 설정 실수로 인해 이미지가 깨질 수 있으므로 항상 폴더 구조와 경로를 꼼꼼히 확인해야 함.
</details>


<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅02(태그 중첩 오류)</summary>


**[문제점]**  
- HTML에서 `<h3>` 태그가 `<p>` 태그 안에 중첩되어 사용됨.

**[오류 코드/상황]**  
```html
<p><h3>팔로워:3,200명</h3></p>
```

**[원인 분석]**  
- `<p>`(문단) 태그는 블록 레벨 요소이며 다른 블록 레벨 태그(`<h3>`, `<div>`, 등)를 내부에 중첩하면 HTML 구조상 올바르지 않음.
- 일부 브라우저에서는 자동으로 태그를 분리하거나 무시하지만 표준에 맞지 않아 예기치 않은 렌더링 문제가 발생할 수 있음.

**[해결 방안]**  
- `<h3>` 태그를 `<p>` 태그 밖에서 단독으로 사용하거나,  
  단순 텍스트라면 `<p>`만 사용하고, 강조가 필요하면 `<h3>`만 사용함.

**[느낀점]**  
- HTML 태그의 올바른 중첩과 구조를 지키는 것이 웹페이지의 안정적인 렌더링과 유지보수에 중요함을 알게 됨.
- 태그 사용 시 문서 구조와 의미를 고려하여 작성해야 함.

</details>



<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅03(a 태그 문법 오류)</summary>

**[문제점]**  
- 깃허브 링크가 정상적으로 표시되지 않음.

**[오류 코드/상황]**  
```html
<P><a href="https://github.com/tkasid00/fullstack_hj"
  target="_blank"
  title="깃허브 바로가기"
  깃허브 보기> </a></P>
```

**[원인 분석]**  
- `<a>` 태그의 `title` 속성 뒤에 링크 텍스트와 닫는 꺾쇠(`>`)가 혼합되어 있어 문법 오류가 발생함.
- 링크 텍스트는 `<a>` 태그의 시작과 끝 사이에 위치해야 하며 속성값은 큰따옴표로 정확히 닫아야 함.

**[해결 방안]**  
- `<a>` 태그의 속성을 올바르게 작성하고, 링크 텍스트를 태그 내부에 위치시킴.
```html
<p>
  <a href="https://github.com/tkasid00/fullstack_hj"
     target="_blank"
     title="깃허브 바로가기">
     깃허브 보기
  </a>
</p>
```

**[느낀점]**  
- HTML 태그의 문법을 정확히 지키는 것이 웹페이지의 정상적인 동작과 유지보수에 중요함을 다시 한 번 인식함.
- 속성값과 태그 구조를 꼼꼼히 확인하는 습관이 필요함.
</details>


<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅04(CSS 선택자 미적용)</summary>

**[문제점]**  
- .container .mission이라는 CSS 선택자가 적용되지 않음.

**[오류 코드/상황]**  
- 해당 html : 
```bash
<div class="container mission">
  <p>📦 이 박스는 margin과 padding을 통해 우주 공간을 확보했어요!</p>
</div>
```
- 적용한 css
```bash
.container .mission {
  margin: 30px; padding: 20px;
  background-color: #2980b9;
  border-radius: 10px;}
```

**[원인 분석]**  
- .container .mission은 .container라는 클래스의 요소 내부에 있는 .mission 클래스의 자식 요소를 의미하지만 실제 HTML 구조에서는 하나의 요소가 .container와 .mission 두 클래스를 동시에 가지고 있음.

**[해결 방안]**  
- .container.mission으로 붙여서 적용

**[느낀점]**  
- CSS 선택자에서 띄어쓰기 유무에 따른 의미 차이를 알게 됨.
- CSS를 작성할 때 선택자 구조와 HTML 요소 간의 관계를 먼저 명확히 분석한 후 스타일을 적용해야됨을 깨달음.
</details>


<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅05(배경 색상 충돌 오류)</summary>


**[문제점]**  
-.item 클래스의 background-image(그라데이션)와 .i1 클래스의 background-color(단색 배경)이 충돌하여 i1 배경색이 의도한 대로 적용되지 않고 그라데이션이 덮어져서 보임.

**[오류 코드/상황]**  
- 해당 html : 
```bash
.item {
  background-image: linear-gradient(135deg, #584545, #fff);
  color: #201919;
  padding: 5px;
  }

.i1 {
  background-color: #e6cdcd;
  }

```

**[원인 분석]**  
- CSS에서 background-image와 background-color가 함께 있을 때 background-image가 background-color 위에 그려짐.
- .i1 클래스에서 background-color만 지정하면 그라데이션을 덮지 못함.

**[해결 방안]**  
- 1) i1에 background-image: none;을 추가해서 그라데이션을 제거하고 단색 배경만 적용하기
```bash 
.i1 {
  background-image: none;
  background-color: #e6cdcd;
 }
```
- 2) .item에 background-image를 없애고 필요한 요소에만 개별적으로 그라데이션을 적용하도록 분리.

**[느낀점]**  
- CSS 배경 속성은 여러 값이 겹칠 때 우선순위를 잘 이해해야 함.
- background-color와 background-image는 동시에 쓰면 이미지가 위에 그려져 컬러가 보이지 않는 상황이 발생함을 깨달음.
- 작은 스타일 문제도 의도한 UI에 큰 영향을 미치니, 스타일 충돌을 항상 주의해야 할것.
</details>


<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅06(애니메이션 미작동 문제)</summary>


**[문제점]**  
- 페이지에 떠오르는 bubble 애니메이션(rise)을 적용했으나 물방울이 화면에 보이지 않거나 애니메이션이 실행되지 않음.

**[오류 코드/상황]**  
```html
.bubble {
  position: fixed;
  bottom: -100px;
  animation: rise 8s infinite ease-in;
  z-index: 0; /* ❗ 낮은 우선순위 */
}
```

**[원인 분석]**  
- 페이지 내 다른 요소들이 z-index 우선순위상 위에 있어서 .bubble 요소가 화면 뒤에 가려짐.  
- CSS에서 z-index는 요소의 쌓임 순서를 결정하는데, .bubble에 설정된 z-index: 0은 가장 낮은 값에 가까워서 position: relative 또는 absolute, fixed를 가진 다른 요소들보다 뒤로 밀림.
- 그림자와 position: relative, z-index 기본값 등을 가지고 있는 카드 요소(.card)가 존재해 .bubble을 가려버림.

**[해결 방안]**  
- .bubble의 z-index 값을 0에서 10으로 높여 시각적으로 위에 오도록 조정:

**[느낀점]**  
- CSS에서 position이 설정된 요소는 z-index가 기본적으로 0이 되며 다른 요소들과의 겹침 순서에 영향을 미치는 것을 알았음.
- 애니메이션이 보이지 않는 경우 단순히 keyframes만 보는 게 아니라 레이어 순서도 꼭 함께 점검해야 함.
- 특히 fixed 요소는 전체 화면 기준으로 움직이므로 다른 요소들과의 z-index 충돌 가능성을 항상 염두에 둬야 함.
- 디버깅 시 개발자 도구(F12)로 요소가 겹쳐 보이지 않는 건 아닌지 직접 확인하는 습관이 중요함.
</details>


---

## ✔참고문헌
