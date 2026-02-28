/**
 * store/configureStore.js
 * ------------------------------------
 * Redux Store 설정 파일
 * - Redux Toolkit의 configureStore로 스토어 생성
 * - redux-saga 연결 미들웨어
 * - next-redux-wrapper로 Next.js와 Redux 통합
 */

import { configureStore } from '@reduxjs/toolkit';   // Redux Toolkit 기본 스토어 생성 함수 객체 형식으로 가져오기
import createSagaMiddleware from 'redux-saga';      // saga 미들웨어 생성 함수
import {createWrapper} from 'next-redux-wrapper';   // Next.js와 Redux를 연결하는 wrapper 
import reducer from '../reducers';                  // 루트 리듀서(reducers/index.js)
import rootSaga from '../sagas';                    // 루트 사가(sagas/index.js)

// 스토어 생성 함수
export const makeStore = () => {
    const sagaMiddleware = createSagaMiddleware();  //saga 미들웨어 인스턴스 생성
    //Redux Toolkit으로 스토어 생성
  const store = configureStore({
    reducer,                                    //루트 리듀서 연결                                        
    middleware: (getDefaultMiddleware) =>      
      getDefaultMiddleware({
        thunk: false,                          // saga랑 쓰면 충돌남! 비활성화 필수     
        serializableCheck: false,              // 직렬화 검사 비활성화(saga에서 처리 가능)     
      }).concat(sagaMiddleware),               // saga 미들웨어 추가
    devTools: process.env.NODE_ENV !== 'production',  //개발 환경에서만 Redux Toolkit 활성화
  });
    //saga 실행(rootSaga 연결)
    store.sagaTask = sagaMiddleware.run(rootSaga);
    return store;
};

// Next.js와 Redux를 연결하는 wrapper 생성
export const wrapper = createWrapper(makeStore, {
    debug: process.env.NODE_ENV !== 'production'    //개발 환경에서 디버그 모드 활성화 
});