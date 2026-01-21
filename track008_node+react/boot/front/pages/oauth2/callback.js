//pages/oauth2/callback.js
import { useEffect } from "react"; //상태 확인 - view
import { useRouter } from "next/router"; //이동
import { useDispatch } from "react-redux"; //store 상태
import { loginSuccess } from "../../reducers/authReducer";  //액션

export default function OAuth2CallbackPage(){
    const router = useRouter();
    const dispatch = useDispatch();
    useEffect(()=>{
        if(!router.isReady) return;

    const {accessToken}=router.query;  //accessToken 처리
        if(accessToken){
            try{
            localStorage.setItem("accessToken", accessToken);  //토큰 저장
            fetchUser(accessToken);
        }catch(err){
            console.error("OAuth2 callback error : " , err);
        }
    }
    }, [router.isReady, router.query]);

const fetchUser= async(accessToken)=>{
    try {
        //기본 주소
      const res = await fetch("http://localhost:8484/auth/me", {
        headers: { Authorization: `Bearer ${accessToken}` },
        credentials: "include",   // refreshToken도 쿠키와 함께 전송
      });
      if (res.ok) { //auth/me가 통과가 됐다면 
        const user = await res.json();
        dispatch(loginSuccess({ user, accessToken }));  //로그인 성공
        router.push("/mypage"); 
      } else {
        router.push("/login");
      }
    } catch (err) {
      console.error("User fetch error:", err);
      router.push("/login");
    }
}

    return <p>소셜 로그인 처리 중입니다</p>
}