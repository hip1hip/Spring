import { Link, BrowserRouter } from "react-router-dom"
import Router from './Router';
import './App.css';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Link to="/userhome">메인 홈으로 </Link> |
        <Link to="/add">학생추가 </Link> |
        <Link to="/list">리스트 </Link> |
        <hr />

        <Router />
      </BrowserRouter>
    </div>
  );
}

export default App;