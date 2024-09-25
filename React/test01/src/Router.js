import { Routes, Route, Navigate } from "react-router-dom"
import Userhome from './components/Userhome';
import List from "./components/List";
import Add from "./components/Add";

export default function Router() {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/userhome" />} />
      <Route path="/userhome" element={<Userhome />} />
      <Route path="/add" element={<Add />} />
      <Route path="/list" element={<List />} />



    </Routes>


  )
}