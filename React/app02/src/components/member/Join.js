//아이디 패스워드 이름 이메일 전화번호 , 가입 버튼  얼럿하면 입력한게 뭔지만 보여주게 하기

import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function Join() {
  const navigate = useNavigate();

  const [inputs, setInputs] = useState({ id: '', pwd: '', name: '', email: '', type: '' });  //스테이트 변수 설정 
  const { id, pwd, name, email, type } = inputs;
  //function 정의 
  const onChange = (e) => {  // e = 방금 발생한 이벤트 객체 
    const { name, value } = e.target;
    setInputs({
      ...inputs,  //다른 요소는 값을 그대로 유지 
      [name]: value   //이벤트 발생한 요소만 value 변경 
    })
  }
  const join = () => {

    axios.post('http://localhost:8081/members', {}, { params: { id: id, pwd: pwd, name: name, email: email, type: type } })
      .then(function (res) {
        if (res.status === 200) {
          let txt = 'id: ' + res.data.dto.id;
          txt += '\npwd: ' + res.data.dto.pwd;
          txt += '\nname: ' + res.data.dto.name;
          txt += '\nemail: ' + res.data.dto.email;
          txt += '\ntype: ' + res.data.dto.type;
          alert('회원가입 완료. 회원정보\n' + txt);
        } else {
          alert('가입 취소');
        }
        navigate('/userhome');
      })
  }



  return (
    <div>
      <h2>회원가입 </h2>
      id: <input type="text" name="id" value={id} onChange={onChange}></input> <br />
      password: <input type="password" name="pwd" value={pwd} onChange={onChange}></input> <br />
      name: <input type="text" name="name" value={name} onChange={onChange}></input> <br />
      email: <input type="text" name="email" value={email} onChange={onChange}></input> <br />
      type: <input type="text" name="type" value={type} onChange={onChange}></input> <br />
      <button onClick={join}>회원가입</button>
    </div>
  )
}