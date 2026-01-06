//
/* routes-user.js
--------------------------
사용자 관련 API 라우터

주소 경로(/user/register?  x)
post : /user/register(requestBody)
post : /user/login(requestBody)
post : /user/logout
get : /user/
patch : /user/{id}/nickname         **전체 갱신은 put
    ※비교 /user/nickname?id=1
delete : /user/{id}

*/


const express = require('express');
const passport = require('passport');
const isAuthenticated=require('../middlewares/isAuthenticated'); //미들웨어
const {    
    createUser,
    getAllUsers,
    updateUserNickname,
    deleteUser} = require('../models/users');


const router = express.Router();

//C
//회원가입
/**
 * @swagger
 * /user/register:
 *   post:
 *     summary: 회원가입
 *     description: 신규 사용자 등록
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               email: { type: string }
 *               password: { type: string }
 *               nickname: { type: string }
 *               mobile: { type: string }
 *               mbtiTypeId: { type: integer }
 *               ufile: { type: string }
 *     responses:
 *       200:
 *         description: 회원가입 완료
 */
router.post('/register', async(req, res)=>{
    try {
        const {email, password, nickname, mobile, mbtiTypeId, ufile} = req.body;
        await createUser(email, password, nickname, mobile, mbtiTypeId, ufile);
        res.status(201).json({message:'회원가입 성공'});   //200 - 단순 메서드 성공(공용), 201 - create 성공

    } catch (err) {
        console.error('Register Error', err);
        res.status(500).json({message:'회원가입 실패'});
    }
});


//R
//로그인
/**
 * @swagger
 * /user/login:
 *   post:
 *     summary: 로그인(테스트용)
 *     description: Passport LocalStrategy 이메일/비밀번호 인증 후 세션 저장
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               email: { type: string }
 *               password: { type: string }
 *     responses:
 *       200:
 *         description: 로그인 성공
 *       401:
 *         description: 로그인 실패
 */
// router.post('/login', async(req, res, next)=>{
//     const {email, password} = req.body;  //RestController
//     //실제 검증은 models/users.js의 verifyUser 사용 가능
//     res.json({message:'로그인 테스트 성공 : ', email, password});
// });
router.post('/login', async(req, res, next)=>{
    //실행 -> passport.local.js, LocalStrategy 호출
   passport.authenticate('local', (err, user, info)=>{ //(인증 과정발생 에러, 성공 시 반환된 사용자 객체, 실패 시 메시지 객체) 
        if(err) return next(err);
        if(!user) return res.status(401).json({message:info?.message||'로그인 실패'});

        req.login(user, (loginErr)=>{   // passport가 제공하는 함수 - 인증된 사용자 객체를 세션에 저장하는 과정
                //내부적으로 serializeUser 호출 시 세션에 저장, 이후 deserializeUser 실행하여 req.user 사용자 객체 복원
            if(loginErr) return next(loginErr);
           
            const {PASSWORD, ...safeUser} = user; //db에서 가져온 사용자 객체에서 password 필드 제거(비밀번호 제거 후 새로운 객체 생성)
               // { 제거할 속성, 나머지 속성들} = 새로운 객체;
               
            return res.status(200).json({message:'로그인 성공', user: safeUser});   // 사용자정보반환
        });
    })(req, res, next);
        //const {email , password} = req.body;
        //// 실제 검증은 models/users.js의 verfiyUser 사용가능
        //res.json({message:'로그인 테스트 성공' , email, password});
});








//로그아웃
/**
 * @swagger
 * /user/logout:
 *   post:
 *     summary: 로그아웃(테스트용)
 *     description: Passport 세션 기반으로 세션 종료
 *     responses:
 *       200:
 *         description: 로그아웃 성공
 */

// router.post('/logout', async(req, res)=>{
//     res.json({message:'로그아웃 성공(테스트용)'});
// });

router.post('/logout', isAuthenticated, (req, res)=>{  // isAuthenticated 로그인한 유저만 다음 진행
    req.logout((err)=>{ //Passport가 제공하는 함수, 현재 로그인된 사용자 정보를 세션에서 제거
        if(err) return res.status(500).json({message:'로그아웃 실패'});

        req.session.destroy(()=>{   //세션 제거
            res.clearCookie('connect.sid'); //브라우저에 저장된 세션쿠키 삭제, 쿠키가 없으면 브라우저가 세션 식별x
            res.json({message:'로그아웃 성공'});

        });
    });
});



//전체 사용자 조회
/**
 * @swagger
 * /user/:
 *   get:
 *     summary: 전체 사용자 조회
 *     description: 로그인된 사용자만 모든 사용자의 목록 조회
 *     responses:
 *       200:
 *         description: 사용자 목록 반환
 *       401:
 *         description: 인증 필요
 */
router.get('/', isAuthenticated, async(req, res)=>{
    try {
        const users =  await getAllUsers();
        res.json(users);

    } catch (err) {
        console.error('getAllUsers Error', err);
        res.status(500).json({message:'사용자 조회 실패'});
    }
});

//U
//닉네임 수정
/**
 * @swagger
 * /user/{id}/nickname:
 *   patch:
 *     summary: 닉네임 수정
 *     description: 특정 사용자의 닉네임을 수정합니다. (로그인 필요)
 *     parameters:
 *       - in: path
 *         name: id
 *         required: true
 *         schema: { type: integer }
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               nickname: { type: string }
 *     responses:
 *       200:
 *         description: 닉네임 수정 완료
 *       401:
 *         description: 인증 필요
 */
router.patch('/:id/nickname' , isAuthenticated, async(req, res)=>{
    try{ 
        const {nickname} = req.body;
        await  updateUserNickname( req.params.id  , nickname);
        res.json({message : '닉네임 수정 완료'});
    }catch(err){
        console.error('UpdateUserNickname Error' , err);
        res.status(500).json({message:'닉네임 수정 실패'});
    }
});

//D
//사용자 삭제

// 2 - 4 - 6 들여쓰기 
/**
 * @swagger
 * /user/{id}:
 *   delete:
 *     summary: 사용자 삭제
 *     description: 특정 사용자를 삭제합니다. (로그인 필요)
 *     parameters:
 *       - in: path
 *         name: id
 *         required: true
 *         schema: { type: integer }
 *     responses:
 *       200:
 *         description: 사용자 삭제 완료
 *       401:
 *        description: 인증 필요
 */

router.delete('/:id', isAuthenticated, async(req, res)=>{
    try {
        const {nickname} = req.body;
        await deleteUser(req.params.id);
        res.json({message:'사용자 삭제 완료'});
    } catch (err) {
        console.error('deleteUser Error', err);
        res.status(500).json({message:'사용자 삭제 실패'});
    }
});


//*** 이거 빼먹으면 안됨!!! *****
module.exports = router;
