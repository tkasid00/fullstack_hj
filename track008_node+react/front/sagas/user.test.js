// npx jest sagas/user.test.js

import {call, put} from 'redux-saga/effects';
import {
    login, signUp, loadUsers, logout, updateNickname, deleteUser,
    loginApi, signUpApi, loadUsersApi, logoutApi, updateNicknameApi, deleteUserApi
} from '../sagas/user';

import reducer, {
    initialState,
    LOG_IN_REQUEST, LOG_IN_SUCCESS, LOG_IN_FAILURE,
    LOG_OUT_REQUEST, LOG_OUT_SUCCESS, LOG_OUT_FAILURE,
    SIGN_UP_REQUEST, SIGN_UP_SUCCESS, SIGN_UP_FAILURE,
    LOAD_USERS_REQUEST, LOAD_USERS_SUCCESS, LOAD_USERS_FAILURE, 
    UPDATE_NICKNAME_REQUEST, UPDATE_NICKNAME_SUCCESS, UPDATE_NICKNAME_FAILURE,
    DELETE_USER_REQUEST, DELETE_USER_SUCCESS, DELETE_USER_FAILURE
} from '../reducers/user';

/* 구조 정리
it('테스트 이름', ()=>{
    const action = {타입, 데이터};
    const gen = 액션 이름(action);   //사가:export function* [login(action)] 참조
    
    //api 호출 call
    expect(gen.next().value).toEqual(call(Api, 데이터 호출)); // 사가 : yield [call](loginApi, action.data); 참조 

    //성공  put
    expect(gen.next({}).value).toEqual(put({type:성공메서드}));  //사가 : yield [put]({type:LOG_OUT_SUCCESS});   

    //실패 put
    const error = {response:{data:'메시지'}};
    expect(gen.throw(error).value).toEqual(put({type:실패메서드, error:'메시지'})); // 사가: yield [put]({type:LOG_OUT_FAILURE, error:err.response?.data||err.message});     
});
*/


describe('user saga', ()=>{
    //로그인
    it('login success', ()=>{
        const action ={type:LOG_IN_REQUEST, data:{email:'z@z', passowrd:'z'}};
        const gen = login(action);

        expect(gen.next().value).toEqual(call(loginApi, action.data));  //const result = yield call(loginApi, action.data);  

        //성공
        // yield put({type:LOG_IN_SUCCESS, data:user}); 
        const apiResponse = {APP_USER_ID:1, EMAIL:'z@z', NICKNAME:'zzz'}; //테스트 데이터
        expect( gen.next({data:apiResponse}).value).toEqual(
            put({
                type:LOG_IN_SUCCESS,
                data:{id:1, email:'z@z', nickname:'zzz'}
            })
        );
    });

    //로그아웃
    it('logiout success', ()=>{
        const action ={type:LOG_OUT_REQUEST};
        const gen = logout(action); //기능

        expect(gen.next().value).toEqual(call(logoutApi));   // yield call(logoutApi);
        expect(gen.next({}).value).toEqual(put({type:LOG_OUT_SUCCESS}));  //yield put({type:LOG_OUT_SUCCESS});   
        
        //실패
        const error = {response:{data:'로그아웃 실패'}};
        expect(gen.throw(error).value).toEqual(put({type:LOG_OUT_FAILURE, error:'로그아웃 실패'}));
        //  yield put({type:LOG_OUT_FAILURE, error:err.response?.data||err.message}); 

    });

    //회원가입
    it('signUp success', ()=>{
        const action ={type:SIGN_UP_REQUEST, data:{email:'z@z', passowrd:'z'}};  // . [post]: [/user/register]  - [data]
        const gen = signUp(action);

        expect(gen.next().value).toEqual(call(signUpApi, action.data));    //yield call(signUpApi, action.data);  

        //성공
        expect(gen.next({}).value).toEqual(put({type:SIGN_UP_SUCCESS}));  // yield put({type:SIGN_UP_SUCCESS}); 
        
        //실패
        const error = {response:{data:'회원가입 실패'}};
        expect(gen.throw(error).value).toEqual(put({type:SIGN_UP_FAILURE, error:'회원가입 실패'}));
        // yield put({type:SIGN_UP_FAILURE, error:err.response?.data||err.message}); 

    });


    //사용자 조회
    it('loadUsers success', ()=>{
        const action ={type:LOAD_USERS_REQUEST};  // //4. get: /user/   
        const gen = loadUsers(action);

        expect(gen.next().value).toEqual(call(loadUsersApi));      // const result = yield call(loadUsersApi);

        //성공
        const fakeUsers = [ {APP_USER_ID:1, EMAIL:'z@z', NICKNAME:'zzz'}];
        expect(gen.next({data:fakeUsers}).value).toEqual(put({type:LOAD_USERS_SUCCESS, data:[{id:1, email:'z@z', nickname:'zzz'}]}));  
        //yield put({type:LOAD_USERS_SUCCESS, data:users});
        
        //실패
        const error = {response:{data:'회원 조회 실패'}};
        expect(gen.throw(error).value).toEqual(put({type:LOAD_USERS_FAILURE, error:'회원 조회 실패'}));
        // yield put({type:LOAD_USERS_FAILURE, error:err.response?.data||err.message});  /

    });   

    //닉네임 수정
     it('updateUser success', ()=>{                             //바꿀 값 넣기
        const action ={type:UPDATE_NICKNAME_REQUEST, data:{id:1, nickname:'new'}}; //5. patch: /user/{id}/nickname  - data
        const gen = updateNickname(action);

        expect(gen.next().value).toEqual(call(updateNicknameApi, action.data));  //  yield call(updateNicknameApi, action.data); 

        //성공
        expect(gen.next({}).value).toEqual(put({type:UPDATE_NICKNAME_SUCCESS, data:{id:1, nickname:'new'}}));  
       // yield put({type:UPDATE_NICKNAME_SUCCESS, data:{id:action.data.id, nickname:action.data.nickname}}); 
        
        //실패
        const error = {response:{data:'닉네임 수정 실패'}};
        expect(gen.throw(error).value).toEqual(put({type:UPDATE_NICKNAME_FAILURE, error:'닉네임 수정 실패'}));

    });     


    //사용자 삭제
     it('deleteUser success', ()=>{                           
        const action ={type:DELETE_USER_REQUEST, data:{id:1}};  //6. delete : /user/{id} 
        const gen = deleteUser(action);

        expect(gen.next().value).toEqual(call(deleteUserApi, action.data.id));  //  yield call(deleteUserApi, action.data.id); 

        //성공
        expect(gen.next({}).value).toEqual(put({type:DELETE_USER_SUCCESS, data:{id:1}}));  
       //  yield put({type:SIGN_UP_SUCCESS, data:{id:action.data.id}}); 
        
        //실패
        const error = {response:{data:'사용자 삭제 실패'}};
        expect(gen.throw(error).value).toEqual(put({type:DELETE_USER_FAILURE, error:'사용자 삭제 실패'}));

    });     

///////////
});


