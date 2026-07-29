import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { addEmployee } from '../service/employeeService'


export const AddEmployee = () => {
  const [id, setId] = useState("")
  const [name, setName] = useState("")
  const [desg, setDesg] = useState("")
  
  const navigate = useNavigate()

  const handleAdd = () => {
    if (!id || !name || !desg) return
    addEmployee({ id, name, desg })
    .then(() => {
      navigate("/")
    })
    .catch((error) => {
      console.log(error)
    })
  }

  return (
    <div className="container mt-4">
      <h2>Add Employee</h2>

      <div className="mb-3">
        <label className="form-label">Id</label>
        <input
          type="text"
          className="form-control"
          name="empId"
          autoComplete="off"
          data-lpignore="true"
          data-1p-ignore
          value={id}
          onChange={(e) => setId(e.target.value)}
        />
      </div>

      <div className="mb-3">
        <label className="form-label">Name</label>
        <input
          type="text"
          className="form-control"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
      </div>

      <div className="mb-3">
        <label className="form-label">Designation</label>
        <input
          type="text"
          className="form-control"
          value={desg}
          onChange={(e) => setDesg(e.target.value)}
        />
      </div>

      <button className="btn btn-primary me-2" onClick={handleAdd}>Add</button>
      <Link to="/" className="btn btn-secondary">Back</Link>
    </div>
  )
}