import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function Join() {
  const navigate = useNavigate();

  const [inputs, setInputs] = useState({ id: '', pwd: '', name: '', email: '', type: '' });
  const { id, pwd, name, email, type } = inputs;

  const onChange = (e) => {
    const { name, value } = e.target;
    setInputs({
      ...inputs,
      [name]: value
    })
  }

  const join = () => {
    if (!id || !pwd || !name || !email || !type) {
      alert("모든 필드를 입력해주세요.");
      return;
    }

    axios.post('http://localhost:8081/join', { id, pwd, name, email, type })
      .then(function (res) {
        if (res.status >= 200 && res.status < 300) {
          let txt = `id: ${res.data.dto.id}\npwd: ${res.data.dto.pwd}\nname: ${res.data.dto.name}\nemail: ${res.data.dto.email}\ntype: ${res.data.dto.type}`;
          alert('회원가입 완료. 회원정보\n' + txt);
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
      id: <input type="text" name="id" value={id} onChange={onChange}></input> <br />
      password: <input type="password" name="pwd" value={pwd} onChange={onChange}></input> <br />
      name: <input type="text" name="name" value={name} onChange={onChange}></input> <br />
      email: <input type="text" name="email" value={email} onChange={onChange}></input> <br />

      type: <input type="text" name="type" value={type} onChange={onChange}></input> <br />
      <button onClick={join}>회원가입</button>
    </div>
  );
}
