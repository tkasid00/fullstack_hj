export default function UsersPage(){
    //1. 코드(자바스크립트 상태, 데이터)

    //2. 랜더링

    return (
    <div className="container mt-4">
        <h1 className="mb-3">사용자 목록</h1>
        {/* 로딩/에러 상태 표시*/}
        <div className="alert alert-info">로딩 중...</div>
        <div className="alert alert-danger">에러 메시지</div>

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
            <tr>
            <td>user1@example.com</td>
            <td>닉네임1</td>
            <td>
                <button className="btn btn-primary btn-sm me-2">닉네임 수정</button>
                <button className="btn btn-danger btn-sm">삭제</button>
            </td>
            </tr>
            <tr>
            <td>user2@example.com</td>
            <td>
                {/* 닉네임 수정 모드일 때*/}
                <input className="form-control" placeholder="새 닉네임" />
            </td>
            <td>
                <button className="btn btn-success btn-sm me-2">수정 완료</button>
                <button className="btn btn-danger btn-sm">삭제</button>
            </td>
            </tr>
        </tbody>
        </table>

        {/* 로그아웃 버튼 */}
        <div className="mt-3">
        <button className="btn btn-secondary">로그아웃</button>
        </div>
    </div>

    );
}