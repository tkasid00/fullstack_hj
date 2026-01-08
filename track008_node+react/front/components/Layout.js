// components/Layout.js
import Link from 'next/link';

export default function Layout({ children }) {
  return (
    <div>
      {/* 헤더 */}
      <div className="p-5 bg-primary text-white text-center">
        <h1>공용 레이아웃 헤더</h1>
      </div>

      {/* 내비게이션바 */}
      <nav className="navbar navbar-expand-sm bg-dark navbar-dark">
        <div className="container-fluid">
          <ul className="navbar-nav">
            {/* 홈링크 */}
            <li className="nav-item">
              <Link href="/users" className="nav-link active">
                HOME
              </Link>
            </li>
            <li className="nav-item">
              <Link href="/login" className="nav-link active">
                로그인
              </Link>
            </li>
            <li className="nav-item">
              <Link href="/join" className="nav-link active">
                회원가입
              </Link>
            </li>
          </ul>
        </div>
      </nav>

      {/* 본문 */}
      <main className="container mt-4">{children}</main>

      {/* 푸터 */}
      <footer className="mt-5 p-4 bg-dark text-white text-center">
        <p>Footer</p>
      </footer>
    </div>
  );
}
