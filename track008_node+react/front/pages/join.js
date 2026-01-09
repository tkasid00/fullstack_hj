import {useDispatch, useSelector} from 'react-redux';  // 액션 발생, redux store에서 사용자 상태 가져오기
import {useState, useEffect} from  'react'; // 특정 이벤트 - 상태 처리
import {useRouter} from 'next/router';      
import {SIGN_UP_REQUEST} from '../reducers/user'; //회원가입 액션



// //✅ 초기 상태 정의
// export const initialState = {
//     me: null,           //로그인 사용자 정보{id, emailm, nickname...}
//     users: [],          //전체 사용자 목록 배열[{id, emailm, nickname...}, {id, emailm, nickname...}...]
//     isLoading: false,   //API 요청 중인지 여부
//     error: null,        //에러 메시지
//     signUpDone: false   //회원가입 완료 여부
// };

export default function JoinPage(){
    //1. 코드
    const dispatch = useDispatch();
    const router = useRouter();
    const {me, isLoading, error, signUpDone} = useSelector((state)=>state.user);  //user 상태 조회

    //입력값 상태 관리
    const [email, setEmail] = useState('');  //email 변수-세팅 함수 
    const [password, setPassword] = useState(''); 
    const [nickname, setNickname] = useState(''); 

    //회원가입 요청 액션 dispatch
    const onSubmit = (e)=>{
        e.preventDefault();  

        if(!email.trim()){
            console.log('이메일이 빈칸입니다');
            alert('이메일을 입력해 주세요');
            return;
        }
        if(!password.trim()){
            console.log('비밀번호가 빈칸입니다');
            alert('비밀번호를 입력해 주세요');
            return;
        }
        if(!nickname.trim()){
            console.log('닉네임이 빈칸입니다');
            alert('닉네임을 입력해 주세요');
            return;
        }


        dispatch({type:SIGN_UP_REQUEST, data: {email, password, nickname}});

        console.log('1...', signUpDone);

    };

    //로그인 상태면 회원가입 패이지 대신 사용자 목록으로 이동 
     useEffect(()=>{
        if(me) router.push('/users');   //me가 존재할 시 경로 이동
                                        //replace 주소표시창줄 바꿈, 히스토리x / push 히스토리에 추가
    }, [me, router]);   //me와 router 갱신   

    //회원가입 성공 시 로그인 페이지로 이동 
    // useEffect(()=>{
    //     console.log('2...', signUpDone);
    //     if(signUpDone) router.push('/login');   //replace 주소표시창줄 바꿈, 히스토리x / push 히스토리에 추가
    // }, [me, router]); 
    
    
        useEffect( ()=>{ if(signUpDone) router.push('/login');   } , [signUpDone, router]);   

    //2. 랜더링
    return ( //div 하나로 묶기
    <div className="container mt-4">
        <h2 className="mb-3">회원가입</h2>

        {/* 회원가입 폼 */}
        <form className="w-50 mx-auto"  onSubmit={onSubmit} >
        {/* 이메일 입력 */}
        <div className="mb-3">
            <input type="email" className="form-control" placeholder="이메일"
            value={email}   onChange={(e)=>setEmail(e.target.value) }/> 
        </div>

        {/* 비밀번호 입력 */}
        <div className="mb-3">
            <input type="password" className="form-control" placeholder="비밀번호" 
             value={password}   onChange={(e)=>setPassword(e.target.value) }/> 
        </div>

        {/* 닉네임 입력 */}
        <div className="mb-3">
            <input type="text" className="form-control" placeholder="닉네임" 
             value={nickname}   onChange={(e)=>setNickname(e.target.value) }/> 
        </div>

        {/* 회원가입 버튼 */}
        <button type="submit" className="btn btn-primary w-100"    disabled={isLoading}>   
        회원가입 </button>
        </form> 

        {/* 에러 메시지 */}
        {error && <div className="alert alert-danger mt-3">{error}</div>}
  </div>


    );
}

