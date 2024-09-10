import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
export default function Detail() {
  const navigate = useNavigate();
  const { todonum } = useParams();//bnum: 글번호
  const [dto, setDto] = useState({ num: 0, content: '' });
  const { num, content } = dto;


  const del = () => {
    axios.delete('http://localhost:8081/todos/' + todonum)
      .then(function (res) {
        if (res.status === 200) {
          alert('삭제완료')
          navigate('/todo/list')
        }
      })
  }
  let menu = '';
  useEffect(() => {
    axios.get('http://localhost:8081/todos/' + todonum)
      .then(function (res) {
        if (res.status === 200) {
          setDto(res.data.dto);
        } else {
          alert('비정상 응답');
        }
      })
  }, []);
  return (
    <div>
      <h2>Todo list 상세</h2>
      num:{num}<br />
      content:{content}<br />
      {menu}
    </div>
  )
}