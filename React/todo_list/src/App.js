import { Link, BrowserRouter } from "react-router-dom"
import Router from './Router';
import './App.css';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Link to="/userhome">메인 홈으로 </Link> |
        <Link to="/todo/TodoRoot">TodoList  </Link> |
        <hr />
        <Router />
      </BrowserRouter>
    </div>
  );
}

export default App;