import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
export default function Detail() {
  const navigate = useNavigate();
  const { bnum } = useParams();//bnum: 글번호
  const [dto, setDto] = useState({ num: 0, writer: {}, wdata: '', title: '', content: '' });
  const { num, writer, wdate, title, content } = dto;
  //const { id, pwd, name, email, type } = writer;

  const del = () => {
    axios.delete('http://localhost:8081/boards/' + bnum)
      .then(function (res) {
        if (res.status === 200) {
          if (res.data.flag) {
            alert('삭제완료')
            navigate('/board/list')
          } else {
            alert('삭제취소');
          }
        } else {
          alert('비정상 응답 ');
        }
      })
  }
  let menu = '';
  useEffect(() => {
    axios.get('http://localhost:8081/boards/' + bnum)
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
      <h2>board detail</h2>
      num:{num}<br />
      writer:{writer.id}<br />
      wdate:{wdate}<br />
      title:{title}<br />
      content:{content}<br />
      {menu}
    </div>
  )
}