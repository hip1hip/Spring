import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";


export default function Join() {
  const navigate = useNavigate();
  const [inputs, setInputs] = useState({ userid: '', password: '', username: '' });
  const { userid, password, username } = inputs;

  const onChange = (e) => {
    const { name, value } = e.target;
    setInputs({
      ...inputs,
      [name]: value
    });
  }

  const join = () => {
    if (!userid || !password || !username) {
      alert("모든 필드를 입력해주세요.");
      return;
    }

    axios.post('http://localhost:8081/users/join', { userid, password, username })
      .then(function (res) {
        if (res.status >= 200 && res.status < 300) {

          alert('회원가입 완료. ');
          navigate('/userhome');
        } else {
          alert('가입 취소');
        }
      }).catch((err) => {
        console.error(err.response);
        alert("회원가입에 실패했습니다.");
      });
  }


  return (
    <div>
      <h2>회원가입 </h2>
      id: <input type="text" name="userid" value={userid} onChange={onChange}></input> <br />
      password: <input type="password" name="password" value={password} onChange={onChange}></input> <br />
      username: <input type="text" name="username" value={username} onChange={onChange}></input> <br />

      <button onClick={join}>회원가입</button>
    </div>
  );
}