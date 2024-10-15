import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";

export default function Userhome() {
  const navigate = useNavigate();
  let loginId = localStorage.getItem('loginId');  // localStorage 로칼에서 저장소 / 창 하나끼리 묶임 , 탭따로 쓰고 싶으면 세션스토리지 써야함 
  let menu = '';

  const logout = () => {
    localStorage.removeItem('loginId');
    localStorage.removeItem('type');
    navigate('/userhome');
  }

  if (loginId === null) {
    menu = <div>
      <Link to="/member/join">회원가입</Link> <br />
      {/* 누르면 라우터  "/member/join 로 넘어감 */}
      <Link to="/member/login">로그인</Link>
    </div>
  } else {
    menu = <div>
      <button onClick={logout}> 로그아웃 </button> |
      <Link to="/member/info">내정보 확인 </Link>  |
      <Link to="/board/list">글목록  </Link> |

    </div>

  }


  return (
    <div>
      <h2>user home</h2>
      {menu}

    </div>
  )
}