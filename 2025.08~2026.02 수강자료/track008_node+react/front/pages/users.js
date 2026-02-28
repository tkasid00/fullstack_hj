// pages/user.js
import {useDispatch, useSelector} from 'react-redux';  // 액션 발생 시 알려줌, 스토어(redux)의 상태
import {
    LOAD_USERS_REQUEST, 
    LOG_OUT_REQUEST,
    UPDATE_NICKNAME_REQUEST,
    DELETE_USER_REQUEST
} from '../reducers/user';  //액션 태그 - 서버 연동

import {useEffect, useState} from 'react';  // 상태 업뎃
import {useRouter} from 'next/router';  //경로 


export default function UsersPage(){
    //코드
    const dispatch = useDispatch();  //경로
    const router = useRouter();  //성공실패 분기
    
    //use 리듀서에서 필요한 상태 가져오기
    const {users, isLoading, error, me} = useSelector( (state) => state.user);


// //✅ 초기 상태 정의
// export const initialState = {
//     me: null,           //로그인 사용자 정보{id, emailm, nickname...}
//     users: [],          //전체 사용자 목록 배열[{id, emailm, nickname...}, {id, emailm, nickname...}...]
//     isLoading: false,   //API 요청 중인지 여부
//     error: null,        //에러 메시지
//     signUpDone: false   //회원가입 완료 여부
// };

    //닉네임 수정 상태 관리  
    //let 사용x 리액트 인식 불가 useState에 [변수, 세팅함수] 형식으로 담아서 넘겨야됨
    const [editId, setEditId] = useState(null);  
    const [newNickname, setNewNickname] = useState(''); 

    //로그인 여부 확인 및 사용자 목록 불러오기
    useEffect (()=>{
        if(!me){ router.push('/login');  //로그인 페이지로 이동     
        }else{
            dispatch({type: LOAD_USERS_REQUEST});  //로그인 시 사용자 목록 요청
        }

    }, [dispatch, me, router]);  //갱신 목록 

    //로그아웃 후 me가 null이 되면 로그인 페이지로 이동, 화면 갱신
    useEffect(()=>{
        if(me===null){
            router.push('/login');
        }
    }, [me, router]);

    //로그아웃
    const onLogout = ()=>{
        dispatch({type: LOG_OUT_REQUEST});
    };

    //사용자 삭제
    const onDeleteUser=(id)=>{
        dispatch({type:DELETE_USER_REQUEST, data:{id}});
    }

    //닉네임 수정 모드로 전환   const [editId, setEditId] = useState(null);  
    const onEdit=(id)=> setEditId(id);

    //닉네임 수정 완료

    const onUpdateNickname = (id)=>{
        dispatch({type: UPDATE_NICKNAME_REQUEST, data:{id, nickname:newNickname}});
        setEditId(null);
        setNewNickname('');
    };


    //랜더링
    return (
    <div className="container mt-4">
        <h1 className="mb-3">사용자 목록</h1>

        {/* 로딩/에러 상태 표시*/}
        {isLoading && <div className="alert alert-info">로딩 중...</div>}
        {error && <div className="alert alert-danger">에러 메시지</div>}

        {/* 사용자 목록 테이블 */}
        <table className="table table-striped table-bordered table-hover">
        <thead>
            <tr>
            <th>이메일</th>
            <th>닉네임</th>
            <th>액션</th>
            </tr>
        </thead>
        <tbody>
            {users.map((u)=>(
            <tr key={u.id}>
                <td>{u.email}</td>
                
                <td>
                    { editId===u.id 
                    ?(<input className="form-control" value={newNickname}
                        onChange={(e)=>setNewNickname(e.target.value)} placeholder='새 닉네임'/>) 
                    : (u.nickname)
                    }
                </td>
                
                <td>{ editId===u.id 
                   ? (<button className="btn btn-primary btn-sm me-2" onClick={()=>onUpdateNickname(u.id)}>수정 완료</button>)

                   : (<button className="btn btn-primary btn-sm me-2" onClick={()=>onEdit(u.id)}>닉네임 수정</button>)
                }

                    <button className="btn btn-danger btn-sm" onClick={()=>onDeleteUser(u.id)}>삭제</button>
                </td>
            </tr>

              ))  }


            {/*  닉네임 수정 모드일 때
            <tr>
                <td>user2@example.com</td>
                <td>
                    
                    <input className="form-control" placeholder="새 닉네임" />
                </td>
                <td>
                    <button className="btn btn-success btn-sm me-2">수정 완료</button>
                    <button className="btn btn-danger btn-sm">삭제</button>
                </td>
            </tr> 
            */}

        </tbody>
        </table>

        {/* 로그아웃 버튼 */}
         {/* <form className="w-50 mx-auto"  onLogout={onLogout} >
            {me &&
                <div className="mt-3">
                    <button type="submit" className="btn btn-secondary" disabled={isLoading}>로그아웃</button>
                </div>
                }
                
        </form> */}
            {me &&
                <div className="mt-3">
                    <button type="submit" className="btn btn-secondary" onClick={onLogout} >로그아웃</button>
                </div>
                }


    </div>

    );
}