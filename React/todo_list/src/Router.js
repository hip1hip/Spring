import { Routes, Route, Navigate } from "react-router-dom"
import Userhome from './components/user/Userhome';
import TodoRoot from './components/todo/TodoRoot';
import Login from "./components/user/Login";
import Join from "./components/user/Join";

export default function Router() {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/userhome" />} />
      <Route path="/userhome" element={<Userhome />} />
      <Route path="/todo/todoroot" element={<TodoRoot />} />
      <Route path="/user/login" element={<Login />} />
      <Route path="/user/join" element={<Join />} />


    </Routes>


  )
}