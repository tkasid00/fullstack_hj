//Passport/index.js
//로그인 : [local.js] Passport LocalStrategy로 인증 후 세션(serializeUser) 저장
//로그아웃 : Passport 세션 기반으로 사용자 조회(deserializeUser) 후 세션 종료

const passport = require('passport');
const local = require('./local');
const {findUserById} = require('../models/users');

module.exports = ()=>{
    //로그인 성공 시 사용쟈 pk를 세션에 저장 - 이메일은 구버전
    passport.serializeUser((user, done)=>{      //로그인 시 인증된 사용자 객체 정보, 세션에 저장할 값(콜백함수-어떻게 처리됨)
        done(null, user.APP_USER_ID);   //에러, 세션에 저장할 값-번호(의미없는값, 이메일x)
    });

    //세션에 사용된 사용자 id로 db에서 사용자 조회
    passport.deserializeUser( async(id, done)=>{    //id, 콜백
        try {
            const user = await findUserById(id);
            done(null, user);  //조회된 사용자 객체 req.user에 저장
        } catch (error) {
            console.error('deserializeUser Error', error);
            done(error);  //에러 발생 시 인증 실패 처리 
            
        }
    });
    local();      //LocalStrategy에 등록
}