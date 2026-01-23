import { Col, Row } from "antd"; 
import { EditOutlined, DeleteOutlined } from "@ant-design/icons";

export default function EditDeleteButtons({ post, user, onEdit, dispatch, deletePostRequest }) {
    //작성자 본인 확인
    const isAuthor =
    user?.nickname?.trim().toLowerCase() ===
    post.authorNickname?.trim().toLowerCase();
    //작성자 아니면 버튼 표시x
  if (!isAuthor) return null;

  return (
    // Col/Row로 버튼 가로/세로정렬 선택 
    <>  
        {/* 수정 버튼 */}
      <Col flex={1} style={{ textAlign: "center" }}>  
        <div
          onClick={() => onEdit(post)}               
          style={{ cursor: "pointer" }}              
        >
          <EditOutlined style={{ fontSize: "20px", color: "#555" }} /> 
          <div style={{ fontSize: "12px" }}>수정</div>  
        </div>
      </Col>
       {/* 삭제 버튼 */}
      <Col flex={1} style={{ textAlign: "center" }}>  
        <div
          onClick={() => dispatch(deletePostRequest({ postId: post.id }))}  
          style={{ cursor: "pointer" }}                                 
        >
          <DeleteOutlined style={{ fontSize: "20px", color: "red" }} />
          <div style={{ fontSize: "12px" }}>삭제</div>  
        </div>
      </Col>
    </>
  );
}
