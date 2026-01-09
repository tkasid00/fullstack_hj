// pages/_app.js 
import 'bootstrap/dist/css/bootstrap.min.css';  //부트스트랩
import Layout from '../components/Layout';      //공용 레이아웃 컴포너늩
import '../styles/globals.css';                 //글로벌css
import {wrapper} from '../store/configureStore'; //redux store 연결

function MyApp({Component, pageProps}){ 
            //현재 랜더링할 컴포넌트, 해당 페이지에 전달되는 초기 props 
    return (
        <div>
            <Layout>
                {/*각 페이지 컴포넌트*/}
                <Component {...pageProps}/>
            </Layout>
        </div>
    );
}
// next-redix-wrapper로 Redux store 연결
export default wrapper.withRedux(MyApp);