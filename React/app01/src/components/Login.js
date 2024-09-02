import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const navigate = useNavigate();
  const [inputs, setInputs] = useState({ id: '', pwd: '' });  //스테이트 변수 설정 
  const { id, pwd } = inputs;
  //function 정의 
  const onChange = (e) => {  // e = 방금 발생한 이벤트 객체 
    const { name, value } = e.target;
    setInputs({
      ...inputs,  //다른 요소는 값을 그대로 유지 
      [name]: value   //이벤트 발생한 요소만 value 변경 
    })
  }

  const login = () => {
    axios.get('http://localhost:8081/members/login', { params: { id: id, pwd: pwd } })
      .then(function (res) {
        if (res.status === 200) {
          if (res.data.flag) {
            alert('로그인 성공');
            localStorage.setItem('loginId', res.data.loginId);
            localStorage.setItem('type', res.data.type);
            navigate('/userhome');
          } else {
            alert('로그인 실패');
          }
        } else {
          alert('비정상 응답');
        }
      })

  }


  return (
    <div>
      <h2>Login</h2>
      id: <input type="text" name="id" value={id} onChange={onChange}></input> <br />
      password: <input type="password" name="pwd" value={pwd} onChange={onChange}></input> <br />
      <button onClick={login}>로그인 </button>
    </div>
  )
}