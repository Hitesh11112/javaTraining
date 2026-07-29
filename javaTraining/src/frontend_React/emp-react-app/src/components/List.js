import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getAllEmployees, deleteEmployee } from '../service/employeeService'


export const List = ()=> {
  const [employees, setEmployees] = useState([])

  const loadEmployees = () => {
    getAllEmployees()
    .then((response) => {
      console.log(response.data)
      setEmployees(response.data)
    })
    .catch((error) => {
      console.log(error)
    })
  }

  useEffect(() => {
    loadEmployees()
  },[])

  const handleDelete = (id) => {
    deleteEmployee(id)
    .then(() => {
      loadEmployees()
    })
    .catch((error) => {
      console.log(error)
    })
  }

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">Employee List</h2>

      <div className="d-flex justify-content-center">
        <table className="table table-bordered" style={{ maxWidth: "900px" }}>
          <thead className="table-dark">
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Designation</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {employees.map((e) => (
              <tr key={e.id}>
                <td>{e.id}</td>
                <td>{e.name}</td>
                <td>{e.desg}</td>
                <td>
                  <Link to={`/update/${e.id}`} className="btn btn-warning btn-sm me-2">Update</Link>
                  <Link to={`/info/${e.id}`} className="btn btn-info btn-sm me-2">Info</Link>
                  <button className="btn btn-danger btn-sm" onClick={() => handleDelete(e.id)}>Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  )
}