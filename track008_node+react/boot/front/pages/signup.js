//pages/index/js
//1. 역할 주석
import React, { useState, useEffect } from "react";   // view 상태 관리(이벤트 처리, 변수 상태 관리)
import { useRouter } from "next/router";
import { useDispatch, useSelector } from "react-redux"; //reducer 상태 관리(reducer 가져오기, store에 전달)
import { Row, Col, Form, Input, Button, Upload, Spin, message } from "antd"; // 엔트디자인 컴포넌트
import { UploadOutlined } from "@ant-design/icons"; //엔트디자인 아이콘
import { signupRequest , resetAuthState} from "../reducers/authReducer"; //액션-회원가입, 리셋 이벤트
import axios from "../api/axios";

export default function SignupPage(){
        //code
        //2. 부품 사용 가능하게 router, dispatch
        const dispatch = useDispatch(); 
        const router = useRouter();   

        //3. useSelector 이용해서 reducer의 상태 가져오기(login, error, success)
        const {loading, error, success} = useSelector((state)=>state.auth);
        const [fileList, setFileList] = useState([]);
        const onFinish = (value)=>{
            const formData = new FormData();
            formData.append("email", value.email);
            formData.append("password", value.password);
            formData.append("nickname", value.nickname);
            formData.append("provicer", "local");
            if(fileList.length>0){
                formData.append("ufile", fileList[0].originFileObj);
            }
            dispatch(signupRequest(formData));
        }
        //회원가입 성공 시 메시지+로그인 페이지 이동
        useEffect(()=>{
            if(success){
                message.success("회원가입이 성공적으로 완료되었습니다");
                router.push("/login");
                dispatch(resetAuthState());
            }
        }, [success, router, dispatch]);

        /////////////////////////////

        //view
    return (
    <Row justify="center" style={{marginTop:40}}>
        <Col xm={24} sm={16} md={8}>
            {loading && <Spin/>}
            {error && <p style={{color:"red"}}>{error}</p>}
            {!success &&(
                <Form onFinish={onFinish} layout="vertical">
                    {/* 이메일 입력 + 중복 검사 */}
                        <Form.Item
                            label="email"
                            name="email"
                            hasFeedback
                            rules={[{ required: true, message: '이메일을 입력해 주세요' },{
                               
                                    validator: async (_, value) => { // _ : 필드 관련 정보, value : 사용자 입력값
                                        //입력값이 없으면 검사 통과
                                    if (!value) return Promise.resolve();
                                    try {
                                        // 서버에 이메일 중복 여부 확인 요청
                                    const res = await axios.get(
                                        `/auth/check-email?email=${encodeURIComponent(value)}`
                                    );

                                    // 서버 응답이 true - 이미 사용 중인 이메일
                                    if (res?.data === true) {
                                        return Promise.reject(
                                        new Error("이미 사용 중인 이메일입니다.")
                                        );
                                    }
                                    // 중복이 아니라면 검사 통과
                                    return Promise.resolve();
                                    } catch (err) {
                                        // 이메일 중복 검사 오류 
                                    console.error("이메일 중복 검사 오류:", err);
                                    // 검사 실패 처리
                                    return Promise.reject(new Error("중복 검사 실패"));
                                    }
                                },
                                                
                            }]}
                            >
                        <Input />
                        </Form.Item>

                    {/* 비밀번호 입력 */}
                        <Form.Item
                            label="비밀번호"
                            name="password"                            
                            rules={[{ required: true, message: '비밀번호를 입력하세요' }]}
                            >
                            <Input.Password />
                        </Form.Item> 

                    {/* 닉네임 입력 + 중복 검사 */}
                    <Form.Item
                        label="닉네임"
                        name="nickname"
                        hasFeedback
                        rules={[{ required: true, message: '닉네임을 입력하세요.' }, {
                            validator: async (_, value) => {
                                if (!value) return Promise.resolve();
                                try {
                                const res = await axios.get(
                                    `/auth/check-nickname?nickname=${encodeURIComponent(value)}`
                                );
                                if (res?.data === true) {
                                    return Promise.reject(
                                    new Error("이미 사용 중인 닉네임입니다.")
                                    );
                                }
                                return Promise.resolve();
                                } catch (err) {
                                console.error("닉네임 중복 검사 오류:", err);
                                return Promise.reject(new Error("중복 검사 실패"));
                                }
                            },

                        }]}
                    >
                    <Input/>
                    </Form.Item>


                    {/* 프로필 이미지 업로드 */}
                    <Form.Item name="profileImage" label="프로필 이미지">
                        <Upload
                            beforeUpload={() => false} 
                            fileList={fileList}
                            onChange={({fileList})=>setFileList()}
                            maxCount={1}  //하나만
                        >
                            <Button icon={<UploadOutlined />}>이미지 선택</Button>
                        </Upload>
                    </Form.Item>

                    <Button type ="primary" htmlType="submit" loading={loading}>회원가입</Button>
                </Form>
            )}
        </Col>
    </Row>);
}