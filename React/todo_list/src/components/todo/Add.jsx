import axios from "axios";
import { useState } from "react";

function Add({ todos, setTodos }) {
  const [content, setContent] = useState('');

  // 입력값 변경 시 상태 업데이트
  const handleChange = (e) => {
    setContent(e.target.value);
  };

  const addTodo = () => {
    // 서버로 전송할 데이터 설정
    const newTodo = { content: content, userid: localStorage.getItem('userid') };

    axios.post('http://localhost:8081/todos', {}, { params: { ...newTodo } })
      .then(function (res) {
        if (res.status === 200) {
          console.log(newTodo);
          // 성공 시 새로운 todo를 추가


          console.log(res)
          setTodos([...todos, res.data]); // 서버 응답에서 새로운 todo 정보 사용
          setContent(''); // 입력란 초기화
        }
      });
  }
  return (

    <div>
      <h2>Todo List 작성</h2>
      <form onSubmit={(e) => e.preventDefault()}>
        리스트 추가 : <input type="text" name="content" value={content} onChange={handleChange} /> &nbsp;
        <button tyep="button" onClick={addTodo}>작성</button>
      </form>
    </div>
  )
}

export default Add;