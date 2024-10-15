import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";

export default function Hello() {
  const navigate = useNavigate();
  let loginId = localStorage.getItem('loginId');
  let userType = localStorage.getItem('type'); // Get the user type from localStorage
  let menu = '';

  const logout = () => {
    localStorage.removeItem('loginId');
    localStorage.removeItem('type');
    navigate('/userhome');
  }

  if (loginId === null) {
    // If not logged in, show join and login options
    menu = (
      <div>
        <Link to="/member/join">회원가입</Link> <br />
        <Link to="/member/login">로그인</Link>
      </div>
    );
  } else {
    // If logged in, display different menus based on user type
    if (userType === '구매자') {
      menu = (
        <div>
          <p>구매자 메뉴입니다.</p>
          <button onClick={logout}> 로그아웃 </button>|
          <Link to="/member/info">내정보 확인 </Link>|
          <Link to="/buyer/orders">내 주문 목록 </Link>|
          <Link to="/products/list">상품 목록</Link>
        </div>
      );
    } else if (userType === '판매자') {
      menu = (
        <div>
          <p>판매자 메뉴입니다.</p>
          <button onClick={logout}> 로그아웃 </button>|
          <Link to="/member/info">내정보 확인 </Link>|
          <Link to="/products">내 상품 목록 </Link>|
          <Link to="/products/register">상품 등록</Link>
        </div>
      );
    }
  }

  return (
    <div>
      <h2>User Home</h2>
      {menu}
    </div>
  );
}