
import { Link } from "react-router-dom";

export default function Hello() {
  return (
    <div>
      <Link to="/todo/TodoRoot">Todo List</Link> <br />
      <Link to="/user/Login">로그인</Link><br />
      <Link to="/user/join">회원가입</Link>
    </div>
  )
}