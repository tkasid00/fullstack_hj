// <rootDir>/setupTest.js

import '@testing-library/jest-dom';
import {cleanup} from '@testing-library/react';

//테스트 시 캐시 삭제
afterEach(()=>{
    cleanup();
});