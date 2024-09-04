import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
export default function List() {
  const token = localStorage.getItem('token');
  const [list, setList] = useState([]);
  useEffect(() => {
    axios.get('http://localhost:8081/board', { headers: { token: token } })
      .then(function (res) {
        if (res.status === 200) {
          setList(res.data.list);
        } else {
          alert('비정상 응답');
        }
      })
  }, []);
  return (
    <div>
      <h2>board list</h2>
      <Link to="/board/add">글작성</Link>
      <ul>
        {
          list.map((item) => (
            <li>
              {item.num}  /
              {item.title}  /
              {item.writer.id}  /
              <img src={'http://localhost:8081/read-img/' + item.img} className="simg" />
            </li>
          ))
        }
      </ul>

    </div>
  )
}