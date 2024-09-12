
import { Link } from "react-router-dom";

export default function Hello() {
  return (
    <div>
      <Link to="/todo/TodoRoot">Todo List</Link> <br />
      {/* <Link to="/Todo/login">로그인</Link> */}
    </div>
  )
}