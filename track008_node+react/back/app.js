//express - node.js 프레임워크(웹서버 쉽게 만들기)
const express = require('express'); 


//express 애플리케이션 인스턴스 생성
const app = express();

//get 메서드로 루트 경로
app.get('/', (req,res)=>{
    //클라이언트에게 hello express 문자열 응답
    res.send('hello express');
});

//port 설정 - 생략 가능

//지정 포트 실행, 실행되면 콘솔에 접근해 url 출력
app.listen(3065, ()=>{
    console.log(`✔서버 실행 중! http://localhost:3065`)
});

//실행 방법 package.json - "nodemon": "^3.0.1"(변경사항 발생 시 자동 재실행)
// npx nodemon app.js 터미널 입력


