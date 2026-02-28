/** 
 * saga/index.js
 * -------------------------------
 * ✅ 루트 사가(rootSaga) 설정 파일
 * - 모든 개별 saga(userSaga 등)을 합쳐서 실행
 * - redux-Saga의 all, fork 등을 사용해 병렬 실행
 */

import { all, fork } from 'redux-saga/effects';  //여러 saga를 동시에 실행하기 위한 함수
import userSaga from './user';  // 사용자 관련 saga 

export default function* rootSaga() {
    yield all([
        fork(userSaga), // fork(userPost) 등 연결하여 병렬 실행 가능 [배열 형태 주의]
    ]);
    
}