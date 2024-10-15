import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const navigate = useNavigate();
  const [inputs, setInputs] = useState({ id: '', pwd: '' });
  const { id, pwd } = inputs;

  const onChange = (e) => {
    const { name, value } = e.target;
    setInputs({
      ...inputs,
      [name]: value
    });
  }

  const login = () => {
    if (!id || !pwd) {
      alert("아이디와 비밀번호를 입력해주세요.");
      return;
    }

    axios.post('http://localhost:8081/login', { id, pwd })
      .then(function (res) {
        if (res.status >= 200 && res.status < 300) {
          if (res.data.flag) {
            alert('로그인 성공');
            localStorage.setItem('loginId', res.data.id);
            localStorage.setItem('type', res.data.type);
            localStorage.setItem('token', res.data.token); // 저장된 토큰
            navigate('/userhome');
          } else {
            alert('로그인 실패');
          }
        } else {
          alert('비정상 응답');
        }
      }).catch((err) => {
        console.error(err.response ? err.response : err.message);
        alert("로그인에 실패했습니다.");
      });
  }

  return (
    <div>
      <h2>Login</h2>
      id: <input type="text" name="id" value={id} onChange={onChange}></input> <br />
      password: <input type="password" name="pwd" value={pwd} onChange={onChange}></input> <br />
      <button onClick={login}>로그인</button>
    </div>
  );
}
