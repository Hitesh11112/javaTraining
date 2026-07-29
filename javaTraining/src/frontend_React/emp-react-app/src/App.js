import './App.css';
import { Routes, Route, Link } from 'react-router-dom';
import { List } from './components/List';
import { AddEmployee } from './components/AddEmployee';
import { UpdateEmployee } from './components/UpdateEmployee.js';
import { EmployeeInfo } from './components/EmployeeInfo';

function App() {
  return (
    <>
      <nav className="navbar navbar-expand-lg navbar-light bg-primary">
        <div className="container-fluid">
          <Link className="navbar-brand text-light" to="/">Employee Management Application</Link>
          <ul className="navbar-nav ms-auto mb-2 mb-lg-0">
            <li className="nav-item">
              <Link className="btn btn-light" to="/add">Add Employee</Link>
            </li>
          </ul>
        </div>
      </nav>

      <div className="container">
        <Routes>
          <Route path="/" element={<List />} />
          <Route path="/add" element={<AddEmployee />} />
          <Route path="/update/:id" element={<UpdateEmployee />} />
          <Route path="/info/:id" element={<EmployeeInfo />} />
        </Routes>
      </div>
    </>
  );
}

export default App;