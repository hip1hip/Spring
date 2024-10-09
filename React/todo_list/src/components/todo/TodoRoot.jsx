import React, { useState } from "react";
import Add from "./Add";
import TodoList from "./TodoList";

const TodoRoot = () => {
  const [todos, setTodos] = useState([]);
  return (
    <div>
      <Add todos={todos} setTodos={setTodos} />
      <TodoList todos={todos} setTodos={setTodos} />
    </div>
  );
};
export default TodoRoot;