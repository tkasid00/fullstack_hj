// npx jest store/configureStore.test.js

import  { makeStore }  from './configureStore.js'; 
import  {  LOG_IN_REQUEST, LOG_IN_SUCCESS, LOG_OUT_SUCCESS  } from '../reducers/user';



describe('store configureStore', ()=>{
    //로그인
    it('store success', ()=>{
        const store = makeStore();

        //초기 상태 확인            스토어 생성 함수 확인
        expect(store.getState().user.isLoading).toBe(false);
   
        //로그인 요청 확인 dispatcher
        store.dispatch({type:LOG_IN_REQUEST});
         expect(store.getState().user.isLoading).toBe(true);

        //로그인 성공         
        const fakeUser = {id:1, email: 'z@z', nickname:'zzz'};
        store.dispatch({type:LOG_IN_SUCCESS, data:fakeUser});
        expect(store.getState().user.me.email).toBe('z@z');

        //로그아웃 성공 
        store.dispatch({type:LOG_OUT_SUCCESS});
        expect(store.getState().user.me).toBeNull;

    });

 

///////////
});




//샘플
// //  npx  jest  store/configureStore.js
// //  npm run test
// import  { makeStore }  from './configureStore.js'; 
// import  {  LOG_IN_REQUEST, LOG_IN_SUCCESS, LOG_OUT_SUCCESS  } from '../reducers/user';
 
// describe( 'store configuration' ,  ()=>{
//     it( 'store success'   , ()=>{
//         const store =  makeStore();

//         // 초기 상태 확인
//         expect(store.getState().user.isLoading).toBe(false);

//         // 로그인 요청 액션 dispatch
//         store.dispatch({type: LOG_IN_REQUEST});
//         expect(store.getState().user.isLoading).toBe(true);

//         // 로그인 성공 액션 dispatch 
//         const fakeUser = {id:1, email:'z@z' , nickname:'zzz'};
//         store.dispatch({type: LOG_IN_SUCCESS , data: fakeUser});
//         expect(store.getState().user.me.email).toBe('z@z');
 
//         // 로그아웃 성공 액션 dispatch 
//         store.dispatch({type: LOG_OUT_SUCCESS});
//         expect(store.getState().user.me).toBeNull();
//     });  
// });


