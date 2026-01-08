/**
 * [reducers/user.js]
 * ----------------------------------
 * ✅ 사용자 관련 상태(user state)를 관리하는 리듀서
 * - 로그인, 로그아웃, 회원가입, 사용자 목록, 닉네임 수정, 사용자 삭제 등
 * - 각 액션 타입 정의 + 초기 상태 + reducer 함수 
 */


//✅ 액션 타입 정의(요청-성공-실패 세트)

//로그인
export const LOG_IN_REQUEST = `LOG_IN_REQUEST`;   //로그인 요청
export const LOG_IN_SUCCESS = `LOG_IN_SUCCESS`;   //로그인 성공
export const LOG_IN_FAILURE = `LOG_IN_FAILURE`;   //로그인 실패

//로그아웃
export const LOG_OUT_REQUEST = `LOG_OUT_REQUEST`;   
export const LOG_OUT_SUCCESS = `LOG_OUT_SUCCESS`;   
export const LOG_OUT_FAILURE = `LOG_OUT_FAILURE`;   

//회원가입
export const SIGN_UP_REQUEST = `SIGN_UP_REQUEST`;   
export const SIGN_UP_SUCCESS = `SIGN_UP_SUCCESS`;   
export const SIGN_UP_FAILURE = `SIGN_UP_FAILURE`;   

//회원조회
export const LOAD_USERS_REQUEST = `LOAD_USERS_REQUEST`;   
export const LOAD_USERS_SUCCESS = `LOAD_USERS_SUCCESS`;   
export const LOAD_USERS_FAILURE = `LOAD_USERS_FAILURE`;   

//닉네임수정
export const UPDATE_NICKNAME_REQUEST = `UPDATE_NICKNAME_REQUEST`;   
export const UPDATE_NICKNAME_SUCCESS = `UPDATE_NICKNAME_SUCCESS`;   
export const UPDATE_NICKNAME_FAILURE = `UPDATE_NICKNAME_FAILURE`;   

//사용자삭제
export const DELETE_USER_REQUEST = `DELETE_USER_REQUEST`;   
export const DELETE_USER_SUCCESS = `DELETE_USER_SUCCESS`;   
export const DELETE_USER_FAILURE = `DELETE_USER_FAILURE`;   



//✅ 초기 상태 정의

export const initialState = {
    me: null,           //로그인 사용자 정보{id, emailm, nickname...}
    users: [],          //전체 사용자 목록 배열[{id, emailm, nickname...}, {id, emailm, nickname...}...]
    isLoading: false,   //API 요청 중인지 여부
    error: null,        //에러 메시지
    signUpDone: false   //회원가입 완료 여부
};


//✅ reducer 함수(레시피)

const reducer = (state = initialState, action)=>{
    switch(action.type){
        //✅ 요청 액션 - 로딩 시작
        case LOG_IN_REQUEST:
        case LOG_OUT_REQUEST:
        case SIGN_UP_REQUEST:     
        case LOAD_USERS_REQUEST:
        case UPDATE_NICKNAME_REQUEST:
        case DELETE_USER_REQUEST:
            return {...state, isLoading:true, error:null};       


        //✅ 성공 액션 - 상태 업데이트
        case LOG_IN_SUCCESS:
            return {...state, isLoading:false, me: action.data};

        case LOG_OUT_SUCCESS:
            return {...state, isLoading:false, me: null};

        case SIGN_UP_SUCCESS:     
        return {...state, isLoading:false, signUpDone:true};

        case LOAD_USERS_SUCCESS:
            return {...state, isLoading:false, users: action.data};

        // case UPDATE_NICKNAME_SUCCESS:
        //     return {...state, isLoading:false, 
        //         //로그인한 사용자 닉네임 업데이트
        //         me: state.me && state.me.id === action.data.id
        //             ? {...state.me, nickname:action.data.nickname} 
        //             : state.me,
        //         //전체 사용자 목록 업데이트
        //         users: state.users.map((u)=>{
        //             u.id === action.data.id ? {...u, nickname:action.data.nickname} : u
        //         }),
        //     };

        case UPDATE_NICKNAME_SUCCESS:
            return {  
                ...state , 
                isLoading:false,  
                 // ✅  로그인 사용자 닉네임 업데이트
                me: state.me &&  state.me.id === action.data.id  
                  ? {  ...state.me,   nickname:action.data.nickname} 
                  : state.me ,
                 // ✅  전체 사용자 목록 닉네임 업데이트 
                users: state.users.map( (u)=> 
                    u.id === action.data.id ? {  ...u , nickname: action.data.nickname } : u
                ),  
            };
        

        case DELETE_USER_SUCCESS:
            return {...state, isLoading:false, 
                //삭제된 사용자 제외
                users: state.users.filter((u)=>u.id !== action.data.id), 
                //본인 계정 삭제 시 me 초기화
                me: state.me?.id === action.data.id ? null : state.me
            };


        //✅ 실패 액션 - 오류 메시지                
        case LOG_IN_FAILURE:
        case LOG_OUT_FAILURE:
        case SIGN_UP_FAILURE:     
        case LOAD_USERS_FAILURE:
        case UPDATE_NICKNAME_FAILURE:
        case DELETE_USER_FAILURE:
            return {...state, isLoading:false, error:action.error?.message||action.error};       


        //✅  기본값(필수!!) -> 상태 변경 없음
        default: return state;   

    }
};
export default reducer;
