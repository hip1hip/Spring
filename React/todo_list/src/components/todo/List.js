import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
export default function List() {
  const [list, setList] = useState([]);
  useEffect(() => {
    axios.get('http://localhost:8081/todos')
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
      <h2>Todo list</h2>
      <Link to="/todo/add">Todo List 추가</Link>
      <ul>
        {
          list.map((item) => {
            return (
              <ui>
                {item.num}  -
                <Link to={"/todo/detail/" + item.num}>{item.content}</Link>  /
                <br />
              </ui>
            )
          })
        }
      </ul>

    </div>
  )
}