import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function Add() {
  const navigate = useNavigate();
  // const loginId = localStorage.getItem('loginId');
  const add = () => {
    let fdata = new FormData(document.getElementById('f'));
    axios.post('http://localhost:8081/todos', fdata, { headers: { "Content-type": "application/x-www-form-urlencoded" } })
      .then(function (res) {
        if (res.status === 200) {

          alert('글작성 완료');
        }
        navigate('/todo/list');
      });
  }
  return (
    <div>
      <h2>Todo List 작성</h2>
      <form id="f">
        content:<input type="text" name="content" /><br />

      </form>
      <button onClick={add}>작성</button>
    </div>
  )
}