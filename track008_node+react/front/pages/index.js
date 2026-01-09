// pages/index.js

import {useEffect} from 'react';        // 특정 동작 실행할 때 사용(특정 동작 가져오기)
import {useRouter} from 'next/router';  // 이동하기

export default function Home(){
    const router = useRouter(); //이동하기

    useEffect(()=>{ //특정 동작 
        router.replace('/users'); //현재 경로 /users (뒤로가기 불가, 경로가 남지 않음)
    }, [router]);   //배열 처리, router 객체 변경 시 useEffect 실행

    return null;

    // return <h1>프론트엔드 프로젝트가 정상 실행되었습니다!</h1>;
}



//npm run dev