/** 
 * //isAuthenticated 로그인 인증 미들웨어
 * ------------------------------------------
 * 로그인 후 인증된 사용자만 접근 가능한 api 적용
 * 인증이 되지 않은 경우 401 응답 확인
 * 
*/
                       //요청, 응답, 처리할 것
function isAuthenticated(req, res, next) {
    if(req.isAuthenticated && req.isAuthenticated()){   //isAuthenticated(passport 자체 메서드) - 세션이 있으면 true 
        return next();  //인증 성공 시 다음 단계 진행 
    }
    return res.status(401).json({message:'로그인이 필요합니다'});  //실패
}

module.exports = isAuthenticated;

