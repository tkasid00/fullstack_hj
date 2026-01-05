##1. node+react

###1. node.js
- javascript 런타임 환경
- 비동기 이벤트 기반 


#### (1) 설치
https://nodejs.org/ko/download

1. 다운로드
2. 설치
3. 설치 확인(cmd)
 - node -v / npm -v

 * 파워쉘 오류

 1) vs code
 ```bash
    PS D:\Hyunju\workspace\fullstack_hj\track008_node+react> node -v
    node : 'node' 용어가 cmdlet, 함수, 스크립트 파일 또는 실행할 수 있는 프로그램 이름으로 인식되지 않습니다. 이름이 정확한지 확인하고 경로가 포함된 경우 경로가 올바른지 검증한 다음 다시 시도하십시오.
    위치 줄:1 문자:1
    + node -v
    + ~~~~
        + CategoryInfo          : ObjectNotFound: (node:String) [], CommandNotFoundException
        + FullyQualifiedErrorId : CommandNotFoundException
 ```
 2) powershell 

 1. node -v 오류일 경우 재설치

 2. npm -v 오류일 경우
 ```js
    PS C:\Users\tj-bu-703-17> npm -v
    npm : 이 시스템에서 스크립트를 실행할 수 없으므로 C:\Program Files\nodejs\npm.ps1 파일을 로드할 수 없습니다. 자세한 내
    용은 about_Execution_Policies(https://go.microsoft.com/fwlink/?LinkID=135170)를 참조하십시오.
    위치 줄:1 문자:1
    + npm -v
    + ~~~
        + CategoryInfo          : 보안 오류: (:) [], PSSecurityException
        + FullyQualifiedErrorId : UnauthorizedAccess
```    
    - 관리자 권한 파워쉘 실행 : Set-ExecutionPolicy  RemoteSigned -> Y -> Get-ExecutionPolicy ->결과:RemoteSigned -> vs code 재시작

        *RemoteSigned :  로컬에서 만든 스크립트 실행 가능 



#### (2) 프로젝트 만들기
```js
npm init
```

[실습]
[프로젝트]
ㄴback      # node
ㄴfront     # react
```js
mkdir back
cd back
npm init 
```
■ 구조 확인
back/
├── config/
│   └── db.js                      # 오라클 DB 설정
├── middlewares/
│   └── isAuthenticated.js         # 로그인 여부->인증 미들웨어
├── models/                        # 사용자 DB 모델 및 쿼리 함수
│   └── users.js               
├── passport/
│   ├── index.js                   # Password 초기화
│   └── local.js                   # Local 전략 설정
├── routes/                        # 사용자 관련 api 라우터
│   └── user.js              
├── node_modules/                  # npm 패키지 
├── .env                           # 환경변수
├── app.js                         # 서버 진입점
├── package.json                   # ✅프로젝트 설정 및 스크립트
├── package-lock.json              # 패키지 버전 고정
├── test1_model_testUsers.js       # 테스트 스크립트

- 사용할 모듈 설정이 들어간 package.json  넣은 후 npm install
```js
npm install (개별 설치할 패키지)
```



#### (3) 서버 진입점(`app.js `)
1. app.js 작성
2. 실행 : npx nodemon app.js




### 2. 개발
### 1. model 
```js
>DESC APPUSER
이름           널?       유형            
------------ -------- ------------- 
APP_USER_ID  NOT NULL NUMBER        
EMAIL        NOT NULL VARCHAR2(255) 
PASSWORD     NOT NULL VARCHAR2(255) 
NICKNAME              VARCHAR2(100) 
MOBILE                VARCHAR2(20)  
MBTI_TYPE_ID          NUMBER        
UFILE                 VARCHAR2(255) 
CREATED_AT            DATE          


CREATE TABLE APPUSER(
APP_USER_ID NUMBER NOT NULL ,
EMAIL  VARCHAR2(255) NOT NULL UNIQUE,
PASSWORD VARCHAR2(255) NOT NULL,
NICKNAME VARCHAR2(100),
MOBILE VARCHAR2(20),
MBTI_TYPE_ID NUMBER,
UFILE VARCHAR2(255), 
CREATED_AT            DATE  DEFAULT SYSDATE
);

CREATE SEQUENCE APPUSER_SEQ
START WITH 1 INCREMENT BY 1
NOCACHE;

``` 