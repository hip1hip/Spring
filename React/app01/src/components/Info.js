import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Info() {
  const loginId = localStorage.getItem('loginId');
  const [dto, setDto] = useState({});
  const { id, pwd, name, email, type } = dto;
  //컴포넌트가 랜더링 할때마다 실행되는 함수 
  // 맨 처음 한번만 실행하려면 두 번째 파람을 빈 배열로 
  useEffect(() => {   //익명함수 
    axios.get('http://localhost:8081/members/' + loginId)
      .then(function (res) {
        if (res.status === 200) {
          setDto(res.data.dto);
        } else {
          alert("비정상 응답");
        }
      })
  }, []);
  return (
    <div>
      <h2> 내정보 확인 </h2>
      id : {id} <br />
      pwd : {pwd} <br />
      name : {name} <br />
      email : {email} <br />
      type : {type} <br />


    </div>
  )
}