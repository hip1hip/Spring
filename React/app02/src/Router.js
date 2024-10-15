import { Routes, Route } from "react-router-dom"
import Join from "./components/member/Join";
import Login from "./components/member/Login";
import Info from "./components/member/Info";
import List from "./components/board/List";
import Add from "./components/board/Add";
import Detail from "./components/board/Detail";
import NotFound from "./components/NotFound";
import Userhome from './components/member/Userhome';

export default function Router() {
  return (
    <Routes>
      <Route path="/userhome" element={<Userhome />} />
      <Route path="/member/join" element={<Join />} />
      <Route path="/member/login" element={<Login />} />
      <Route path="/member/info" element={<Info />} />
      <Route path="/board/list" element={<List />} />
      <Route path="/board/add" element={<Add />} />
      <Route path="/board/detail/:bnum" element={<Detail />} />
      <Route path="*" element={<NotFound />} /> {/* 위에 정의된 외에 모든 결과는 잘못됬다고 알려줄때 * 씀  */}

    </Routes>


  )
}