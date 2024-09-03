import './App.css';
import { BrowserRouter, Link } from 'react-router-dom';
import Router from './Router';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Link to="/userhome">user home</Link> |


        <hr />
        <Router />
      </BrowserRouter>
    </div>
  );
}

export default App;
