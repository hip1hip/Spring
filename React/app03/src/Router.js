import { Routes, Route } from "react-router-dom"
import Userhome from "./components/member/Userhome"
import Login from "./components/member/Login"
import Info from "./components/member/Info"
import List from "./components/board/List"
import Add from "./components/board/Add"
import Join from "./components/member/Join"

export default function Router() {
  return (
    <Routes>
      <Route path="/userhome" element={<Userhome />} />
      <Route path="/member/login" element={<Login />} />
      <Route path="/member/info" element={<Info />} />
      <Route path="/member/join" element={<Join />} />
      <Route path="/board/list" element={<List />} />
      <Route path="/board/add" element={<Add />} />
    </Routes>
  )
}