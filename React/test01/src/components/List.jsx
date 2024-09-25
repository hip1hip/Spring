import axios from "axios";
import { useEffect, useState } from "react";
// import { Link } from "react-router-dom";

function List() {
  const [list, setList] = useState([]);
  useEffect(() => {
    axios.get('http://172.16.3.235:8082/users')
      .then((res) => {
        if (res.status === 200) {
          setList(res.data.list);
        } else {
          alert('비정상 응답');
        }
      })
  }, []);
  return (
    <div>
      <h2>학생 리스트</h2>
      <ul>
        {
          list.map((item) => (
            <li>
              {item.name}  /
              {item.score}  /
            </li>
          ))
        }
      </ul>

    </div>
  );
}

export default List;
