import Hello from "./components/Hello"
import About from "./components/About"
import { Routes, Route } from "react-router-dom"
import Srcomp from "./components/Srcomp"
import DestComp from "./components/DestComp"
import Join from "./components/Join";
import Login from "./components/Login";
import Info from "./components/Info";
import List from "./components/List";
import NotFound from "./components/NotFound";





export default function Router() {
  return (
    <Routes>
      <Route path="/userhome" element={<Hello />} />
      <Route path="/about/:username" element={<About />} />
      <Route path="/src" element={<Srcomp />} />
      <Route path="/dest" element={<DestComp />} />
      <Route path="/member/join" element={<Join />} />
      <Route path="/member/login" element={<Login />} />
      <Route path="/member/info" element={<Info />} />
      <Route path="/board/list" element={<List />} />
      <Route path="*" element={<NotFound />} /> {/* 위에 정의된 외에 모든 결과는 잘못됬다고 알려줄때 * 씀  */}

    </Routes>


  )
}