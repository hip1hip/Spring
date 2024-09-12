import { Routes, Route } from "react-router-dom"
import Userhome from './components/todo/Userhome';
import List from './components/todo/List';
import TodoRoot from './components/todo/TodoRoot';
import Detail from './components/todo/Detail';

export default function Router() {
  return (
    <Routes>
      <Route path="/userhome" element={<Userhome />} />
      <Route path="/todo/list" element={<List />} />
      <Route path="/todo/todoroot" element={<TodoRoot />} />
      <Route path="/todo/detail/:todonum" element={<Detail />} />


    </Routes>


  )
}