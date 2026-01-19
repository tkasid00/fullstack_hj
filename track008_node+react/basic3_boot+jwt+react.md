### 1. [front] react+nextantd

0. back - 준비
1. front 폴더 만들기 / 프로젝트 만들기 / 세팅
```js
cd front
nmp init
```
2. 프로그램 설치
```js
package.json 프로젝트에 넣기
npm install
```
3. 구조 세팅 
```
front/
├── .next/                  # ✅ Next.js 빌드 결과물 (자동 생성, 배포 시 사용)
├── components/             # ✅ 재사용 가능한 UI 컴포넌트 폴더
│   └── Layout.js           # 페이지 공통 레이아웃 컴포넌트
├── node_modules/           # ✅ 설치된 npm 패키지들
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   └── index.js            # 메인 페이지
├── reducers/               # ✅ Redux 리듀서 폴더
│   ├── index.js            # 루트 리듀서 (combineReducers)
│   ├── user.js             # 사용자 관련 리듀서
│   └── user.test.js        # 리듀서 테스트 코드
├── sagas/                  # ✅ Redux-Saga 폴더
│   ├── index.js            # 루트 사가
│   ├── user.js             # 사용자 관련 사가
│   └── user.test.js        # 사가 테스트 코드
├── store/                  # ✅ Redux 스토어 설정 폴더
│   ├── configureStore.js   # Redux 스토어 설정
│   └── configureStore.test.js # 스토어 테스트 코드
├── styles/                 # ✅ CSS 스타일 폴더
│   └── globals.css         # 글로벌 스타일
├── .babelrc                # Babel 설정 파일
├── .eslintrc               # ESLint 설정 파일
├── package-lock.json       # npm 의존성 잠금 파일
├── package.json            # 프로젝트 메타 정보 및 의존성
└── setupTests.js           # 테스트 환경 설정 파일
```
