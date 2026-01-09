/**
 * sagas/user.js
 * --------------------------
 * 사용자 관련 [비동기] 작업을 처리하는 saga
 * - 로그인, 로그아웃, 회원가입, 전체 사용자 조회, 닉네임 수정, 사용자 삭제 등
 * - axios로 API를 호출->성공/실패에 따라 reducer로 액션 전달
 */

//여러 saga를 동시에 실행하기 위한 함수
import { all, fork, call, put, takeLatest} from 'redux-saga/effects'; 

//http 요청 라이브러리
import axios from 'axios';

//액션 타입 불러오기
import reducer, {
    initialState,
    LOG_IN_REQUEST, LOG_IN_SUCCESS, LOG_IN_FAILURE,
    LOG_OUT_REQUEST, LOG_OUT_SUCCESS, LOG_OUT_FAILURE,
    SIGN_UP_REQUEST, SIGN_UP_SUCCESS, SIGN_UP_FAILURE,
    LOAD_USERS_REQUEST, LOAD_USERS_SUCCESS, LOAD_USERS_FAILURE, 
    UPDATE_NICKNAME_REQUEST, UPDATE_NICKNAME_SUCCESS, UPDATE_NICKNAME_FAILURE,
    DELETE_USER_REQUEST, DELETE_USER_SUCCESS, DELETE_USER_FAILURE
} from '../reducers/user';

//anxios 클라이언트 기본 설정
const client = axios.create({
    baseURL: 'http://localhost:3065', //API 서버 주소  
    withCredentials: true, // 쿠키/세션 인증 포함
    
});

//-------------------로그인-----------------------
//로그인 api 호출
//post : /user/login - data
export function loginApi(data){
    return client.post('/user/login', data); 
}

export function* login(action){
    try {                                       // data{email, passowrd}
        const result = yield call(loginApi, action.data);  //api 호출 - (비동기->call)  
        const user = {
            id: result.data.APP_USER_ID,
            email: result.data.EMAIL,
            nickname : result.data.NICKNAME
        } 
    
        yield put({type:LOG_IN_SUCCESS, data:user});   //성공 액션 dipatch 
//          return {...state, isLoading:false, me: action.data};
    
    } catch (err) {
        yield put({type:LOG_IN_FAILURE, error:err.response?.data||err.message});  //실패 액션
        //          return {...state, isLoading:false, error:action.error?.message||action.error};       
    }
}
//1. 액션 발생 시 signUp 호출 - 여러 번 요청이 와도 마지막 요청만 처리
//  return {...state, isLoading:true, error:null};  
function* watchLogin(){
    yield takeLatest(LOG_IN_REQUEST, login);
}



//------------------로그아웃----------------------
//로그아웃 api 호출
//3. post: /user/logout  (data x)

export function logoutApi(){
    return client.post('/user/logout'); 
}
export function* logout(action){
    try {                                      
        yield call(logoutApi);
        yield put({type:LOG_OUT_SUCCESS});   
 //          return {...state, isLoading:false, me: null};
    } catch (err) {
        yield put({type:LOG_OUT_FAILURE, error:err.response?.data||err.message});  //실패 액션
        //          return {...state, isLoading:false, error:action.error?.message||action.error};       
    }
}
//1. 액션 발생 시 signUp 호출 - 여러 번 요청이 와도 마지막 요청만 처리
//  return {...state, isLoading:true, error:null};  
function* watchLogout(){
    yield takeLatest(LOG_OUT_REQUEST, logout);
}


//------------------회원가입----------------------
// 1. [post]: [/user/register]  - [data]

//회원가입 api 호출(한번만)-http://localhost:3065/user/register      
export function signUpApi(data){
    return client.post('/user/register', data);
}

export function* signUp(action){
    try {
        yield call(signUpApi, action.data);  //api 호출 - 결과물
        yield put({type:SIGN_UP_SUCCESS});   //성공 액션 dipatch 
//           return {...state, isLoading:false, signUpDone:true};
    
    } catch (err) {
        yield put({type:SIGN_UP_FAILURE, error:err.response?.data||err.message});  //실패 액션
        //          return {...state, isLoading:false, error:action.error?.message||action.error};       
    }
}
//1. 액션 발생 시 signUp 호출 - 여러 번 요청이 와도 마지막 요청만 처리
//  return {...state, isLoading:true, error:null};  
function* watchSignUp(){
    yield takeLatest(SIGN_UP_REQUEST, signUp);
}


//---------------전체 사용자 조회------------------
//4. get: /user/   
export function loadUsersApi(){
    return client.get('/user/'); 
}

export function* loadUsers(){
    try {                                    
        const result = yield call(loadUsersApi);  //api 호출  
        const users = result.data.map((u)=>({
            id: u.APP_USER_ID,
            email: u.EMAIL,
            nickname : u.NICKNAME
        } ));
    
        yield put({type:LOAD_USERS_SUCCESS, data:users});   //성공 액션 dipatch 
//          return {...state, isLoading:false, me: action.data};
    
    } catch (err) {
        yield put({type:LOAD_USERS_FAILURE, error:err.response?.data||err.message});  //실패 액션
        //          return {...state, isLoading:false, error:action.error?.message||action.error};       
    }
}
function* watchLoadUsers(){
    yield takeLatest(LOAD_USERS_REQUEST, loadUsers);
}



//-----------------닉네임 수정--------------------
//5. patch: /user/{id}/nickname  - data
export function updateNicknameApi(data){
    return client.patch(`/user/${data.id}/nickname`, {nickname:data.nickname});
}

export function* updateNickname(action){
    try {
        yield call(updateNicknameApi, action.data); 
        yield put({type:UPDATE_NICKNAME_SUCCESS, data:{id:action.data.id, nickname:action.data.nickname}}); 
                //   ? {  ...state.me,   nickname:action.data.nickname}
                // users: state.users.map( (u)=> 
                //     u.id === action.data.id ? {  ...u , nickname: action.data.nickname } : u
    
    } catch (err) {
        yield put({type:UPDATE_NICKNAME_FAILURE, error:err.response?.data||err.message});  //실패 액션
        //          return {...state, isLoading:false, error:action.error?.message||action.error};       
    }
}
//1. 액션 발생 시 signUp 호출 - 여러 번 요청이 와도 마지막 요청만 처리
//  return {...state, isLoading:true, error:null};  
function* watchUpdateNickname(){
    yield takeLatest(UPDATE_NICKNAME_REQUEST, updateNickname);
}




//-----------------사용자 삭제--------------------
//6. delete : /user/{id} 
export function deleteUserApi(id){
    return client.delete(`/user/${id}`);
}

export function* deleteUser(action){
    try {
        yield call(deleteUserApi, action.data.id); 
        yield put({type:DELETE_USER_SUCCESS, data:{id:action.data.id}}); 
            //     users: state.users.filter((u)=>u.id !== action.data.id), 
            //     me: state.me?.id === action.data.id ? null : state.me
            // };
    
    } catch (err) {
        yield put({type:DELETE_USER_FAILURE, error:err.response?.data||err.message});  //실패 액션
        //          return {...state, isLoading:false, error:action.error?.message||action.error};       
    }
}
//1. 액션 발생 시 signUp 호출 - 여러 번 요청이 와도 마지막 요청만 처리
//  return {...state, isLoading:true, error:null};  
function* watchDeleteUser(){
    yield takeLatest(DELETE_USER_REQUEST, deleteUser);
}




export default function* userSaga(){
    yield all([
        fork(watchSignUp), //회원가입 saga 실행
        fork(watchLogin), 
        fork(watchLogout), 
        fork(watchLoadUsers), 
        fork(watchUpdateNickname),         
        fork(watchDeleteUser)        
    ]);

}

