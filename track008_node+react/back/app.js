/**
 * app.js
 * ---------------------------
 * Express 서버 진입점
 * - Passport 인증 및 세션/쿠키 설정
 * - Swagger UI로 API 문서 제공
 * - Helmet으로 기본 보안 강화
 * - Https 적용(선택)
 * - 에러 핸들링 추가
 */

//*************************************************************************//
//            require  = import (상단에 있어야 안터짐 주의!)                   //
//*************************************************************************//

//express - node.js 프레임워크(웹서버 쉽게 만들기)
const express = require('express'); 

//세션 관리용 미들웨어
const session = require('express-session');

//Passport 인증 모듈
const passport = require('passport');

//환경변수(.env) 사용을 위해 dotenv 불러오기 
const dotenv = require('dotenv');

//로그 기록용 미들웨어(개발 시 요청-응답 확인)
const morgan = require('morgan');

//CORS(다른 도메인에서 api 호출 허용)
const cors = require('cors');

//보안 헤더 설정 미들웨어 
const helmet = require('helmet');

//https 인증서 파일 읽기
const fs = require('fs');

//https 서버 모듈
const https = require('https');

//Swagger UI 미들웨어
const swaggerUi = require('swagger-ui-express');

//Swagger 문서 자동 생성 도구
const swaggerJsdoc = require('swagger-jsdoc');

// /user 경로에 사용자 라우터 연결
//예 const postRouter=require('./routes/post');
//const  userRouter = require('./routes/user');  //##



//*************************************************************************//
//                            환경변수                                      //
//*************************************************************************//

//require 이후 환경파일 로딩 
// .env 파일 로드(환경변수 사용 가능)
dotenv.config();

//express 애플리케이션 인스턴스 생성
const app = express();



//*************************************************************************//
//                            미들웨어(순서 주의!!)                           //
//*************************************************************************//

//1️⃣기본 미들웨어
//json 파싱 미들웨어(post 요청 body를 json으로 읽기)
app.use(express.json());

//URL-encoded 파싱 미들웨어(form 데이터 처리)
app.use(express.urlencoded({extended:true}));

//모든 도메인에 api 호출 허용
app.use(cors());

//개발 모드에서 요청 로그 출력
app.use(morgan('dev'));

// 기본 보안 헤더 적용
app.use(helmet());


//2️⃣세션 설정(쿠키 기반 세션 관리)
app.use(session({
  secret: process.env.COOKIE_SECRET,      //.env에 저장된 쿠키 암호화 키
  resave: false,                          //매 요청 시 세션 강제 저장 여부(false 권장)
  saveUninitialized: false,               //초기화되지 않은 세션 저장 여부(false 권장)
  cookie: {httpOnly:true, secure: false}  // 외부 js 접근 불가 / secure: https만 사용-연습용은 임시로 false
}));

//3️⃣Passport 초기화 및 세션 설정
app.use(passport.initialize());
app.use(passport.session());

//4️⃣Passport 설정 적용
const passportConfig = require('./passport');
passportConfig();

//5️⃣Swagger 옵션
//스웨거 옵션 최신 버전 - 홈페이지에서 확인 가능
const swaggerOptions = {
  definition: {
    openapi: '3.0.0', //ver
    info: {
      title: 'User API',  //문서 정보
      version: '1.0.0',   //문서 버전
      description: '회원가입, 로그인, 사용자 조회/수정/삭제 API 문서', //설명 
    },
  },
  apis: ['./routes/*.js'],  //스웨거 주석이 들어간 라우터 파일 경로
};

//스웨거 문서 생성
const swaggerSpecs = swaggerJsdoc(swaggerOptions);




//*************************************************************************//
//                          경로 설정 관련                                   //
//*************************************************************************//

//스웨거 ui 엔드포인트 등록
app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerSpecs));

// 1️⃣사용자 라우터 연결
//유저 경로에서 사용자 라우터 연결
const  userRouter = require('./routes/user'); 

app.use('/user', userRouter)

//get 메서드로 (/)루트 경로 요청이 오면 실행될 라우터 핸들러 등록
// app.get('/', (req,res)=>{         //클라이언트에게 hello express 문자열 응답
//     res.send('hello express');
// });


//2️⃣ 에러 핸들링 미들웨어
app.use((err, req, res, next) => {
  console.error('서버 에러:', err.stack);         
  res.status(500).json({ message: '서버 내부 오류 발생' });  
});


//port 설정 - 생략 가능

//지정 포트 실행, 실행되면 콘솔에 접근해 url 출력
//const PORT = process.env.PORT || 3065;
// app.listen(  3065 , ()=>{
//     console.log(`✅ 서버 실행중!   http://localhost:${PORT}`);
//     console.log(`✅ Swagger UI :  http://localhost:${PORT}/api-docs`);
// }); 

//3️⃣서버 실행(Https 적용)
const PORT = process.env.PORT || 3065;

//https 인증서 존재 시 hppts 서버 실행, 없을 시 https 실행
if (fs.existsSync('./cert/server.key') && fs.existsSync('./cert/server.crt')) {
  const options = {
    key: fs.readFileSync('./cert/server.key'),    
    cert: fs.readFileSync('./cert/server.crt'),  
  };
  https.createServer(options, app).listen(PORT, () => {
    console.log(`✅ HTTPS 서버 실행 중! https://localhost:${PORT}`);
    console.log(`✅ Swagger UI: https://localhost:${PORT}/api-docs`);
  });
} else {
  app.listen(PORT, () => {
    console.log(`✅ HTTP 서버 실행 중! http://localhost:${PORT}`);
    console.log(`✅ Swagger UI: http://localhost:${PORT}/api-docs`);
  });
}


//http://localhost:3065/api-docs/
//실행 방법 package.json - "nodemon": "^3.0.1"(변경사항 발생 시 자동 재실행)
// npx nodemon app.js 터미널 입력 
// ctrl + c  서버 종료

