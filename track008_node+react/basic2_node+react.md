## 📁 프로젝트 구조

```
front/
├── .next/                  # ✅ Next.js 빌드 결과물 (자동 생성, 배포 시 사용)
├── components/             # ✅ 재사용 가능한 UI 컴포넌트 폴더
│   └── Layout.js           # 페이지 공통 레이아웃 컴포넌트
├── node_modules/           # ✅ 설치된 npm 패키지들
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   ├── index.js            # 메인 페이지
│   ├── login.js            # 로그인 페이지
│   ├── signup.js           # 회원가입 페이지
│   └── users.js            # 사용자 목록 또는 정보 페이지 
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

## 1. 프로젝트 초기화 
### 1. 프로젝트 만들기 
```js
npm init 
```

[실습]
```js
mkdir front 
cd front 
npm init 
```

### 2. 프로그램 설치
```js
npm install
```
[실습]
```js
package.json 프로젝트 폴더에 넣기
npm install 설치
```

### 3. 서버 진입점
```
front/
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더
│   ├── index.js            # 메인 페이지
```

```
npm run dev  서버 실행
```


### 4. 구조 안내, 개발
1. 프로젝트 생성 `package.json`, `node_modules`, `pages`
2. 앱 진입점 `pages/index.js`, `pages/_app.js`
3. 스타일 적용 `styles/globals.css ` 가 `_app.js`에서 import됨
4. 실행 확인 `npm run dev` 

```
front/
├── .next/                  # ✅ Next.js 빌드 결과물 (자동 생성, 배포 시 사용)
├── components/             # ✅ 재사용 가능한 UI 컴포넌트 폴더
│   └── Layout.js           # 페이지 공통 레이아웃 컴포넌트
├── node_modules/           # ✅ 설치된 npm 패키지들
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   ├── index.js            # 메인 페이지
│   ├── login.js            # 로그인 페이지
│   ├── signup.js           # 회원가입 페이지
│   └── users.js            # 사용자 목록 또는 정보 페이지 
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


1. 각 구조 만들기(폴더 생성)
2. 각 설정파일 
```
front/
├── .babelrc                # Babel 설정 파일       -> 브라우저가 이해할 수 있게 JSX를 일반 JS로 변환 (async, await, optional, chaining 등의 최신 문법)
├── .eslintrc               # ESLint 설정 파일      -> 일관된 코드 스타일 유지(들여쓰기, 세미콜론, 따옴표 등 팀 규칙)
└── setupTests.js           # 테스트 환경 설정 파일   -> 테스트 환경 설정 파일 초기화 
```


3. css
```
front/
├── styles/                 # ✅ CSS 스타일 폴더
│   └── globals.css         # 글로벌 스타일
```

4. page
```
front/
├── components/             # ✅ 재사용 가능한 UI 컴포넌트 폴더
│   └── Layout.js           # 페이지 공통 레이아웃 컴포넌트
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   ├── index.js            # 메인 페이지
```

1. components/Layout.js
2. pages/_app.js
3. pages/index.js

1) login.js 호출 -> _app.js -> `<Layout>` 렌더링
2) `<Layout>` 안에서 Navbar, Footer 랜더링
3) Component가 `Children`으로 들어가서 본문 영역에 표시


### 5. 개발(reducer - saga - view)
1. reducer(주방 레시피대로 상태 바꾸기 - 치킨의 상태: 조리 시작, 조리 중, 조리 완료)
2. saga(배달기사 - 서버에 다녀오기)
3. store(치킨집 - 모든 상태를 모아두는 중앙 창고:주방의 상태/배달여부)

1) `view` 손님이 주문 `/users/login.js` -> store에 액션 전달(치킨집)
                                       -> 액션을 saga/reducer로 전달  
2) 배달기사가 서버에 다녀옴 (saga)              성공/실패
3) 주방 레시피대로 상태 바꾸기 (reducer)        결과에 따라 상태(state) 변경
4) 치킨집(store) 업데이트                       
5) `view` 화면 반영 -> 상태 감지 후 화면에 그림 그리기


```
사용자 액션(버튼 클릭, 로그인 요청 등)
            ↓
    [View 컴포넌트(부품)]
    ______________________
    - dispatch({type:LOG_IN_REQUEST, data:{id, password}})
    - 화면에서 액션 발생
            ↓
         [store]
    ______________________
    - 중앙 창고(Redux Store)
    - 모든 상태(state) 저장, 취합
    - 액션을 reducer/saga로 전달
            ↓
          [saga]
    ______________________
    - 비동기 작업 담당(API)
    - ex/ axios.post('/user/login')
    - 성공 : LOG_IN_SUCCESS
    - 실패 : LOG_IN_FAILURE
            ↓
        [reducer]
    ______________________
    - 상태(state) 변경 규칙서
    - LOG_IN_SUCCESS -> me 업데이트
    - LOG_IN_FAILURE -> error 저장
            ↓
         [store]
    ______________________
    - 변경된 상태를 중앙 창고에 반영
            ↓
        [View 리랜더링]
    ______________________
    - useSelector로 상태 읽기

```




1. [reducers] - user.js     ※ post.js, hashtag.js...
2. [reducers] - index.js
3. [reducers] - user.test.js


### 6. 개발(reducer - saga - view) (2) 서버 연결 - saga
```
front/
├── sagas/                  # ✅ Redux-Saga 폴더
│   ├── index.js            # 루트 사가
│   ├── user.js             # 사용자 관련 사가
│   └── user.test.js        # 사가 테스트 코드
```
1. sagas/index.js
2. sagas/user.js
3. sagas/user.test.js

--
1. 제너레이터 함수(중간정산)
```js
function* g1(){
    let i = 0;
    while(true){
        yield i++;

    }
}
const gen1 = g1();  //제너레이터 객체 생성
console.log(gen1.next().value);  //next로 호출(사용) 
```
- *표시 : 반복작업(제너레이터)
- yield로 멈추고 next로 실행하고 (수동 무한반복)


```js
function* g2(){
    console.log("first");
    yield 1;  // 첫 번째 반환

    console.log("second");
    yield 2;  // 두 번째 반환

    console.log("third");
    yield 3;  // 세 번째 반환
}
const gen2 = g2();
console.log(gen2.next()); //console.log("first"); 처리 후  yield 1;에서 정지    ->{value: 1, done: false} 함수 자체가 끝난 건 아님 반환점에서 일시정지!
console.log(gen2.next()); //onsole.log("second"); 처리 후  yield 2;에서 정지
console.log(gen2.next()); //console.log("third"); 처리 후  yield 3;에서 정지
console.log(gen2.next()); //{value: undefined, done: true} 반복문 아닐 시 종료

```


2. 사가 기본 함수
1) all - 여러 saga를 동시에 실행
2) fork - [비동기]로 saga 실행
3) call - API 호출하고 결과 기다림(blocking) > [동기](1가지 작업만, 멀티x)
4) put - redux 액션을 dispatch
5) take Latest - 특정 액션을 눌렀을 때 감지하고 가장 마지막 액션만 처리

##


## 
1. post : /user/register - data
 *               email: { type: string }
 *               password: { type: string }
 *               nickname: { type: string }
 *               mobile: { type: string }
 *               mbtiTypeId: { type: integer }
 *               ufile: { type: string }

2. post : /user/login - data
 *               email: { type: string }
 *               password: { type: string }

3. post : /user/logout

4. get : /user

5. patch : /user/{id}/nickname
 *               nickname: { type: string }

6. delete : /user/{id}



### 7. 개발(reducer - saga - view) (3) store
```
front/
├── store/                  # ✅ Redux 스토어 설정 폴더
│   ├── configureStore.js   # Redux 스토어 설정
│   └── configureStore.test.js # 스토어 테스트 코드

```

1. store/configureStore.js
2. store/configureStore.test.js


### 8. view
```
front/
├── pages/                  # ✅ Next.js 라우팅 기반 페이지 폴더
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   ├── index.js            # 메인 페이지
│   ├── login.js            # 로그인 페이지
│   ├── signup.js           # 회원가입 페이지
│   └── users.js            # 사용자 목록 또는 정보 페이지 
```

1. `useSelector` - Redux store에서 사용자 상태 가져오기
2. `useEffect` - 로그인 여부 확인 및 사용자 목록 불러오기 
3. `dispatch` - 액션 발생(로그인, 사용자 삭제 등)
 
