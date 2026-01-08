// npx jest reducers/user.test.js

import reducer, {
    initialState,
    LOG_IN_REQUEST, LOG_IN_SUCCESS, LOG_IN_FAILURE,
    LOG_OUT_REQUEST, LOG_OUT_SUCCESS, LOG_OUT_FAILURE,
    SIGN_UP_REQUEST, SIGN_UP_SUCCESS, SIGN_UP_FAILURE,
    LOAD_USERS_REQUEST, LOAD_USERS_SUCCESS, LOAD_USERS_FAILURE, 
    UPDATE_NICKNAME_REQUEST, UPDATE_NICKNAME_SUCCESS, UPDATE_NICKNAME_FAILURE,
    DELETE_USER_REQUEST, DELETE_USER_SUCCESS, DELETE_USER_FAILURE
} from './user';

describe('user reducer', ()=>{
    //로그인
    it('should handle LOG_IN_REQUEST', ()=>{
        const state = reducer(initialState, {type:LOG_IN_REQUEST});
        expect(state.isLoading).toBe(true);
    });

    it('should handle LOG_IN_SUCCESS', ()=>{
        const fakeUser={id:1, email:'1@1', nickname:'first'};
        const state = reducer(initialState, {type:LOG_IN_SUCCESS, data:fakeUser});   //state(=initialState), action{type, data}
        expect(state.me).toBe(fakeUser);
    });

    it('should handle LOG_IN_FAILURE', ()=>{
            //state=리턴값
            //return {...state, isLoading:false, error:action.error?.message||action.error};      
        const state = reducer(initialState, {type:LOG_IN_FAILURE, error:'로그인 실패'});
        expect(state.error).toBe('로그인 실패');
        expect(state.isLoading).toBe(false);
    });


    
    //로그아웃
    it('should handle LOG_OUT_REQUEST', ()=>{
        const state = reducer(initialState, {type:LOG_OUT_REQUEST});
        expect(state.isLoading).toBe(true);
    });

    it('should handle LOG_OUT_SUCCESS', ()=>{
        // return {...state, isLoading:false, me: null};
        const state = reducer(initialState, {type:LOG_OUT_SUCCESS});  
//      expect(state.me).toBe(null);
        expect(state.me).toBeNull();
        expect(state.isLoading).toBe(false);  //생략 가능
    });

    it('should handle LOG_OUT_FAILURE', ()=>{
            //return {...state, isLoading:false, error:action.error?.message||action.error};      
        const state = reducer(initialState, {type:LOG_OUT_FAILURE, error:'로그아웃 실패'});   //[action.error] action값 존재
        expect(state.error).toBe('로그아웃 실패');
        expect(state.isLoading).toBe(false);
    });



    //가입
    it('should handle SIGN_UP_REQUEST', ()=>{
        const state = reducer(initialState, {type:SIGN_UP_REQUEST});
        expect(state.isLoading).toBe(true);
    });

    it('should handle SIGN_UP_SUCCESS', ()=>{
        const state = reducer(initialState, {type:SIGN_UP_SUCCESS});   
        expect(state.signUpDone).toBe(true);
        expect(state.isLoading).toBe(false);
        // return {...state, isLoading:false, signUpDone:true};
    });

    it('should handle SIGN_UP_FAILURE', ()=>{
            //state=리턴값
            //return {...state, isLoading:false, error:action.error?.message||action.error};      
        const state = reducer(initialState, {type:SIGN_UP_FAILURE, error:'회원가입 실패'});
        expect(state.error).toBe('회원가입 실패');
        expect(state.isLoading).toBe(false);
    });


    //성공만 체크
    //LOAD_USERS_SUCCESS
    // return {...state, isLoading:false, users: action.data};
    it('should handle LOAD_USERS_SUCCESS', ()=>{
        const fakeUsers=[{id:1, email:'1@1', nickname:'first'}];
        const state = reducer(initialState, {type:LOAD_USERS_SUCCESS, data:fakeUsers});
        expect(state.users).toEqual(fakeUsers);         //****
        expect(state.isLoading).toBe(false);
    });


    //UPDATE_NICKNAME_SUCCESS
    it('should handle UPDATE_NICKNAME_SUCCESS', ()=>{
        const prevState={
            ...initialState,
            me:{id:1, nickname:'old'},
            users:[{id:1, nickname:'old'}]
        };
        const state = reducer(prevState, {type:UPDATE_NICKNAME_SUCCESS, data:{id:1, nickname:'new'}});
        expect(state.me.nickname).toBe('new');
        expect(state.users[0].nickname).toBe('new');
      
    });

            //     return {...state, isLoading:false, 
            //   값1 [me]: state.me && state.me.id === action.data.id
            //         ? {...state.me, nickname:action.data.nickname} 
            //         : state.me,
            //   값2 [users]: state.users.map((u)=>{
            //         u.id === action.data.id ? {...u, nickname:action.data.nickname} : u
            //     }),
            // };

    //DELETE_USER_SUCCESS
    it('should handle DELETE_USER_SUCCESS', ()=>{
        const prevState={
            ...initialState,
            me:{id:1},
            users:[{id:1}, {id:2}]
        };
        const state = reducer(prevState, {type:DELETE_USER_SUCCESS, data:{id:1}});
        expect(state.users).toEqual([{id:2}]);
        expect(state.me).toBeNull;

    });

                // return {...state, isLoading:false, 
                // [users]: state.users.filter((u)=>u.id !== action.data.id), 
                // [me]: state.me?.id === action.data.id ? null : state.me


});


