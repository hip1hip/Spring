import axios from "axios";

function TodoItem({ todo, todos, setTodos }) {
  const handleDelete = () => {
    axios.delete(`http://localhost:8081/todos/${todo.id}`)
      .then((res) => {
        if (res.status === 200) {
          //삭제된 todo 항목을 db랑 조회해서 업데이트 함. 
          const updatedTodo = todos.filter((t) => t.id !== todo.id);
          setTodos(updatedTodo); //상태 업데이트 
        }
      })
      .catch((error) => {
        console.log("Error", error);
      });
  };
  return (
    <li>
      {todo.content}
      <button type="button" onClick={handleDelete}> 삭제 </button>
    </li>
  )


}
export default TodoItem;