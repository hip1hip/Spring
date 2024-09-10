import { Routes, Route } from "react-router-dom"
import Userhome from './components/todo/Userhome';
import Add from './components/todo/Add';
import List from './components/todo/List';
import Detail from './components/todo/Detail';

export default function Router() {
  return (
    <Routes>
      <Route path="/userhome" element={<Userhome />} />
      <Route path="/todo/list" element={<List />} />
      <Route path="/todo/add" element={<Add />} />
      <Route path="/todo/detail/:todonum" element={<Detail />} />


    </Routes>


  )
}