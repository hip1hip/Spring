import axios from "axios";
import { useEffect } from "react";
import TodoItem from "./TodoItem";


function TodoList({ todos, setTodos }) {

  useEffect(() => {
    // 페이지 로드 시 DB에서 todos를 불러오기
    axios.get('http://localhost:8081/todos')
      .then((res) => {
        if (res.status === 200) {
          setTodos(res.data.list); // DB에서 불러온 데이터를 todos에 저장
        }
      })
      .catch((error) => {
        console.error("Error fetching todos:", error);
      });
  }, []); // 빈 배열을 전달하여 컴포넌트가 처음 렌더링될 때만 호출
  return (
    <div>
      <h2>Todo 목록</h2>
      <ul>
        {todos.map((todo) => (
          <TodoItem ket={todo.id} todo={todo} todos={todos} setTodos={setTodos} />
        ))}
      </ul>
    </div>
  );
}


export default TodoList;
