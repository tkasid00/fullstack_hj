/**
 * [reducers/index.js]
 * ----------------------------------
 * ✅ 루트 리듀서(rootReducer) 설정 파일
 * - 여러 개의 리듀서를 하나로 합쳐서 Redux 스토어에 전달
 * - 현재는 user 리듀서만 포함
 */

import {combineReducers} from 'redux';  //여러 개의 reducer를 합치는 redux 함수
import user from './user'; //사용자 관련 상태를 관리하는 user 리듀서 
// import post from './post'; 

const rootReducer = combineReducers({
    user, //post   여기서 여러 개 리듀서 합치기
});

export default rootReducer;