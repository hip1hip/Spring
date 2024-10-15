
import { Link } from "react-router-dom";

export default function Hello() {
  return (
    <div>
      <Link to="/Add">학생추가</Link> <br />
      <Link to="/List">리스트</Link><br />
    </div>
  )
}