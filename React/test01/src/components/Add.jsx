import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Add() {
  const navigate = useNavigate();
  const [inputs, setInputs] = useState({ name: '', score: '' });
  const { name, score } = inputs;

  const onChange = (e) => {
    const { name, value } = e.target;
    setInputs({
      ...inputs,
      [name]: value
    });
  }


  const addUser = () => {
    // 서버로 전송할 데이터 설정
    // const newTod = { content: content, userid: localStorage.getItem('userid') };

    axios.post('http://172.16.3.235:8082/users', { name, score }, {
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(function (res) {
        console.log(res);
        if (res.status === 200) {

          alert('작성완료 ');
          navigate('/list');
        }
      }).catch((err) => {
        console.error(err);
        alert("작성에 실패했습니다.");
      });
  }


  return (

    <div>
      <h2>학생 추가 페이지 </h2>
      {/* <form onSubmit={(e) => e.preventDefault()}> */}
      학생 이름: <input type="text" name="name" value={name} onChange={onChange} /> <br />
      학생 점수: <input type="text" name="score" value={score} onChange={onChange} /> <br />
      <button type="button" onClick={addUser}>완료</button>
      {/* </form> */}
    </div>
  )
}

export default Add;