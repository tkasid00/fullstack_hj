import {useDispatch, useSelector} from 'react-redux';  // 액션 발생, redux store에서 사용자 상태 가져오기
import {useState, useEffect} from  'react'; // 특정 이벤트 - 상태 처리
import {useRouter} from 'next/router';      
import {LOG_IN_REQUEST} from '../reducers/user'; //로그인 액션

//✅ 초기 상태 정의 -reducers/user.js
// export const initialState = {
//     me: null,           //로그인 사용자 정보{id, emailm, nickname...}
//     users: [],          //전체 사용자 목록 배열[{id, emailm, nickname...}, {id, emailm, nickname...}...]
//     isLoading: false,   //API 요청 중인지 여부
//     error: null,        //에러 메시지
//     signUpDone: false   //회원가입 완료 여부
// };

export default function LoginPage(){

    const dispatch = useDispatch();
    const router = useRouter();
    const {me, isLoading, error} = useSelector((state)=>state.user);  //user 상태 조회

    //입력값 상태 관리
    const [email, setEmail] = useState('');  //email 변수-세팅 함수 
    const [password, setPassword] = useState(''); 
    
    //로그인 요청 액션 dispatch
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

        dispatch({type:LOG_IN_REQUEST, data:{email, password}});

    };

    //로그인 성공 시 사용자 목록 페이지로 이동 
    useEffect(()=>{
        if(me) router.push('/users');   //replace 주소표시창줄 바꿈, 히스토리x / push 히스토리에 추가
    }, [me, router]);  

    //2. 랜더링



    return (
  <div className="container mt-4">
    <h2 className="mb-3">로그인</h2>

    {/*로그인 폼*/}
    <form onSubmit={onSubmit} className="w-50 mx-auto">
      {/* 이메일 입력 */}
      <div className="mb-3">
        <input type="email" className="form-control" placeholder="이메일" 
         value={email}   onChange={(e)=>{setEmail(e.target.value); console.log('email>', e.target.value);} }/>
      </div>

      {/* 비밀번호 입력 */}
      <div className="mb-3">
        <input type="password" className="form-control" placeholder="비밀번호" 
        value={password} onChange={(e)=>{setPassword(e.target.value); console.log('password>', e.target.value);} }/>
      </div>

      {/* 로그인 버튼 */}
      <button type="submit" className="btn btn-primary w-100">
        로그인
      </button>
    </form>

    {/* 에러 메시지 */}
    {error && <div className="alert alert-danger mt-3">{error}</div>}
  </div>


    );
}


// 1. `useSelector` - Redux store에서 사용자 상태 가져오기
// 2. `useEffect` - 로그인 여부 확인 및 사용자 목록 불러오기 
// 3. `dispatch` - 액션 발생(로그인, 사용자 삭제 등)
 