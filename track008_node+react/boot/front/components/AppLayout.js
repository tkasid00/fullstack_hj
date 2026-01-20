//Component/AppLayout.js

import { Layout, Menu, Input, Row, Col, Drawer, Button, Grid } from "antd";     //컴포넌트
import { MenuOutlined, SearchOutlined } from "@ant-design/icons";   //아이콘
import Link from "next/link";   //페이지 이동 링크
import { useSelector, useDispatch } from "react-redux";     //상태 관리(useSelector-reducer 가져오기/useDispatch-이벤트 발생 시 스토어에 전달)
import axios from "../api/axios";       //커스텀 인스턴스-백단위+부트 연동+accessToken9+refreshToken
import { logout, loginSuccess } from "../reducers/authReducer";     // 액션-로그아웃, 로그인 이벤트 
import { useRouter } from "next/router";
import { useEffect, useState } from "react";    //view 상태 관리(useEffect-이벤트 처리/useState-변수 관련 상태 관리)

const { Header, Content } = Layout;     //페이지 전체 구성(Header, Content)
const { useBreakpoint } = Grid;     //반응형


function AppLayout({children, initialUser}){
    //code
    const {user} = useSelector((state)=>state.auth); //store-redux 가져오기
    const dispatch = useDispatch(); //이벤트 발생 시 interceptor, store에 전달
    const router = useRouter();     //이동-경로 바꾸기
    const screens = useBreakpoint(); //반응형 화면 
    
    const [drawerOpen, setDrawOpen ] = useState(false); //햄버거 메뉴바 false로 초기값 - 그냥 false 쓰면 안됨
    const [searchValue, setSearchValue] = useState(""); //검색변수
   
    //로그인 - 새로고침, 유저 정보                    
    useEffect(()=>{
        console.log(user);
            // 앱 구동 시 initialUser 존재, reducer에 유저가 없고 initialUser 안에 닉네임 존재 
            // -> 서버에서 초기 사용자 정보가 있고 reducer에서는 아직 유저가 없음
        if(initialUser && !user && initialUser.nickname){  
            dispatch(loginSuccess({user:initialUser})); //loginSuccess 액션 실행, 성공 시 user 업뎃
        }

    }, [initialUser, user, dispatch]);  //[]:특정값이 변경될 때 안쪽에 {} 콜백 함수 실행

    const protectedRouter = ["/mypage", "/followers", "/followings"];

    //로그인을 했다면 /auth/me(마이페이지) / login(로그인 페이지)
    useEffect(()=>{
        // initialUser 없고 user 없음
        if(!user && !initialUser && protectedRouter.includes(router.pathname) ){
            axios.get("/auth/me")
                 .then((res)=>{
                    if(res.data && res.data.nickname){
                        dispatch(loginSuccess({user:res.data}));
                    }
                 })
                 .catch(()=>{
                    dispatch(logout());
                    router.replace("/login");  //주소표시창줄 바꾸기
                 });
        }
    }, [initialUser, user, dispatch, router.pathname]);

    //로그아웃 
    const handleLogout = async()=>{
        try {
            await axios.post("/auth/logout");
            if(typeof window !== "undefined"){
                localStorage.removeItem("accessToken");
            }
            
        } catch (err) {
            console.error("로그아웃 실패 : " , err);
            dispatch(logout());
            router.replace("/login");
            
        }

    };

    //검색 실행
    const onSearch = (value)=>{
        if(value){
            router.push(`/hashtags?tag=${encodeURIComponent(value)}`);
            setSearchValue("");
        }
    }

    const menuItems =[
        ...(user && user.nickname  //로그인한 상태
            ?[
                { key: "new", label:     <Link href="/posts/new">✏️ NEW POST</Link> },
                { key: "profile", label: <Link href="/mypage">👤 MYPAGE </Link> },
                {
                    key: "logout",
                    label: (
                    <a onClick={handleLogout} style={{ cursor: "pointer" }}>
                    🔓 LOGOUT
                    </a>
                    ),
                },
            ]
            :[
                { key: "login", label: <Link href="/login">🔒Login</Link> },
                { key: "signup", label: <Link href="/signup">🆕👤Signup</Link> },               
            ]
        ),

    ];


    /////////////
    //view 
        return(<Layout>

            {/* Header */}
      <Header style={{ padding: "0 24px", height: 64, display: "flex", alignItems: "center" }}>
        <Row align="middle" justify="space-between" style={{ width: "100%" }}> 

            {/* 로고 클릭 시 홈으로 이동 */}
          <Col flex="none">
            <Link href="/" passHref legacyBehavior>
              <a style={{ color: "#fff", fontWeight: "bold", fontSize: "18px", marginLeft: "12px", textDecoration: "none" }}>
                THEJOA703
              </a>
            </Link>
          </Col> 
            
            {/* 메뉴  xs <576. sm>576 md>786, lg>992   - {} 24칸 중 몇 칸 차지*/}
          <Col flex="auto" xs={0} sm={0} md={16} lg={18} >
            <Menu
              theme="dark"
              mode="horizontal"
              items={menuItems}
              overflowedIndicator={null}  
            />
          </Col>
 
            {/* 햄버거 버튼 */}
          <Col flex="none" >
            <Button
              type="text"
              icon={<MenuOutlined style={{ color: "white", fontSize: 20 }} />}
              onClick={() => setDrawOpen(true)}
            />
          </Col>
        </Row>
      </Header>

            {/* 검색창(pc에서만 표시/중앙정렬) */}
        {screens.md && (
            <div style={{ display: "flex", justifyContent: "center", alignItems: "center", padding: "16px", background: "#fafafa", borderBottom: "1px solid #eaeaea" }}>
                <Input
                    prefix={<SearchOutlined style={{ color: "#999" }} />}
                    placeholder="해시태그 검색 (springboot)"  
                    value={searchValue}
                    onChange={(e)=> setSearchValue(e.target.value)}
                    onPressEnter={(e) => onSearch(e.target.value)}
                    style={{
                    maxWidth: 600,
                    width: "100%",
                    borderRadius: "20px",
                    background: "#fff",
                    padding: "6px 12px",
                    verticalAlign: "middle"
                    }}
                />
            </div>
        )}



            {/* Drawer(모바일 메뉴+검색창) */}
                <Drawer
                    title="MENU"
                    placement="right"
                    onClose={()=>setDrawOpen(false)}
                    open={drawerOpen}
                >
                    <Input.Search
                        placeholder="해시태그 검색"
                        enterButton="검색"
                        value={searchValue}
                        onChange={(e)=> setSearchValue(e.target.value)}
                        onSearch={(value) => {
                                setDrawOpen(false); 
                                onSearch(value);
                            }}               
                        style={{marginBottom:16}}       
                    />

                    <Menu
                    mode="vertical"
                    items={menuItems}
                    onClick={()=>setDrawOpen(false)}
                    />
                </Drawer>

            <Content style={{padding:"40px"}}>{children}</Content>

        </Layout>);
}
export default AppLayout;


// Layout: https://ant.design/components/layout
// Menu: https://ant.design/components/menu
// Input: https://ant.design/components/input
// Drawer: https://ant.design/components/drawer
// Grid(Row/Col): https://ant.design/components/grid
// Button: https://ant.design/components/button