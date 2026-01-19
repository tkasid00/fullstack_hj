import { configureStore } from '@reduxjs/toolkit';
import createSagaMiddleware from 'redux-saga';
import { createWrapper } from 'next-redux-wrapper';
import reducer from '../reducers';
import rootSaga from '../sagas';

export const makeStore = () => {
  // saga 미들웨어 생성
  const sagaMiddleware = createSagaMiddleware();
  const store = configureStore({
    reducer,  //reducer
    middleware: (getDefaultMiddleware) =>
      getDefaultMiddleware({
        thunk: false,   //saga 사용 시 충돌 위험, 사용x
        serializableCheck: false,   //에러 방지 목적 - 직렬화검사 비활성
      }).concat(sagaMiddleware),  //saga 미들웨어 연결
    devTools: process.env.NODE_ENV !== 'production',
  });

  store.sagaTask = sagaMiddleware.run(rootSaga);

  return store;
};

export const wrapper = createWrapper(makeStore, { debug: process.env.NODE_ENV !== 'production' });
