import { Routes, Route } from "react-router-dom"
import Join from "./components/member/Join";
import Login from "./components/member/Login";
// import Info from "./components/member/Info";
import ProductRegister from "./components/product/ProductRegister"; // 상품 등록 컴포넌트 경로
import ProductList from "./components/product/ProductList"; // 상품 목록 컴포넌트 경로

import NotFound from "./components/NotFound";
import Userhome from './components/member/Userhome';

export default function Router() {
  return (
    <Routes>
      <Route path="/userhome" element={<Userhome />} />
      <Route path="/member/join" element={<Join />} />
      <Route path="/member/login" element={<Login />} />
      {/* <Route path="/member/info" element={<Info />} /> */}


      <Route path="/products/register" element={<ProductRegister />} />  {/* 상품 등록 */}
      <Route path="/products" element={<ProductList />} />  {/* 전체 상품 목록 */}
      <Route path="*" element={<NotFound />} /> {/* 위에 정의된 외에 모든 결과는 잘못됬다고 알려줄때 * 씀  */}

    </Routes>


  )
}