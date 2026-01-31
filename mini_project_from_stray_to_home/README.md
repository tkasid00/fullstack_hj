# 🐱 from Stray to Home (Java Console Project)
**유기묘 임시 보호 시뮬레이션 콘솔 프로젝트**

> 콘솔 환경에서 유기묘 임시 보호 과정을 시뮬레이션하는 Java 프로젝트입니다.  
> 사용자/고양이 관리, 탐험(이벤트), 상호작용 흐름을 중심으로 구성했으며  
> **구조 설계(OOP)와 사용자 흐름(UX)을 함께 고려**했습니다.

---

## 🎬 Demo Video
> 썸네일 클릭 시 시연 영상으로 이동합니다.

[![Watch the video](https://img.youtube.com/vi/3VYnhNOxX_8/hqdefault.jpg)](https://youtu.be/3VYnhNOxX_8)

---

## 📌 Project Summary
- **Type**: Java Console Application
- **Main Class**: `com.company.SH005_interface.SH_Main`
- **Key Concept**: Interface 기반 설계(다형성) + 이벤트 흐름 구성

---

## 📂 Project Structure
```text
from-stray-to-home/
 ├─ README.md
 └─ src/
    └─ com/
       └─ company/
          └─ SH005_interface/
             ├─ SH_Main.java
             └─ (etc...)
```             

---

## 🛠 Tech Stack
- **Language**: Java
- **Style**: Console Application (Text UI)
- **Design**: Interface 기반 구조 설계(다형성 활용)

---

## ✨ Key Features

### 🔁 Flow Diagram (User Journey)
```text
User Register
   ↓
Cat Register
   ↓
Interaction → Earn Points
   ↓
[ Shop | Hospital | Explore(Random Event) ]
   ↓
Ending Branch
(Adoption / Adopt Myself / Return to Shelter)
```


### ✅ 1) 사용자 등록 / 시작 흐름
- 사용자 등록 및 기본 정보 입력
- 시뮬레이션 시작을 위한 초기 세팅 진행

### ✅ 2) 고양이 등록 및 보호 관리
- 고양이 등록(기본 정보 설정)
- 보호 진행 상태를 관리하며 플레이 흐름 유지

### ✅ 3) 상호작용 기반 포인트 시스템
- 상호작용 결과에 따라 포인트 획득
- 포인트를 통해 쇼핑/병원/탐험 기능을 이용하는 구조 설계

### ✅ 4) 콘텐츠 기능 (쇼핑 / 병원 / 탐험)
- **쇼핑**: 포인트로 아이템 구매 
- **병원**: 상태 관리/회복 기능
- **탐험(랜덤 이벤트)**: 확률 기반 이벤트 및 결과 분기

### ✅ 5) 엔딩 분기(멀티 엔딩)
- 입양 보내기
- 내가 입양하기
- 보호소로 돌려보내기
- 선택/고양이 상태에 따라 엔딩 흐름 분기 처리

### ✅ 6) 콘솔 UI 구성
- 메뉴/정보를 구분선 및 블록 형태로 출력하여 가독성 강화
- 진행 단계가 명확히 보이도록 Text UI 구성
---


## ▶ Run
1) 프로젝트 clone  
2) 아래 Main 클래스 실행

- Main: `com.company.SH005_interface.SH_Main`

---

## 📌 What I Learned
- 인터페이스 기반 설계로 기능 확장/유지보수에 유리한 구조 구성
- 클래스 책임 분리 및 구조 설계의 중요성
- 조건 분기/확률 이벤트 구현 경험
- 제한적인 콘솔 환경에서 사용자 흐름을 고려한 UI 구성 방법
---

## 🛠 TODO (Next Step)
- 이벤트 시나리오 확장 및 밸런싱 개선
- 사용자/고양이 데이터 저장 및 불러오기(File I/O)

---

## 👨‍💻 Developer Note
> 콘솔 환경에서도 사용자의 진행 흐름이 명확히 보이도록 UI 구조를 설계했고  
> 확률 이벤트와 멀티 엔딩 분기를 통해 반복 플레이가 가능한 구조로 구현했습니다.