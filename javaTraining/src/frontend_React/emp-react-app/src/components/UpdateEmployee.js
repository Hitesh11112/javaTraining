import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { getEmployeeById, updateEmployee } from '../service/employeeService'


export const UpdateEmployee = () => {
  const { id } = useParams()
  const [name, setName] = useState("")
  const [desg, setDesg] = useState("")
  const navigate = useNavigate()

  useEffect(() => {
    getEmployeeById(id)
    .then((response) => {
      setName(response.data.name)
      setDesg(response.data.desg)
    })
    .catch((error) => {
      console.log(error)
    })
  }, [id])

  const handleUpdate = () => {
    if (!name || !desg) return
    updateEmployee(id, { id, name, desg })
    .then(() => {
      navigate("/")
    })
    .catch((error) => {
      console.log(error)
    })
  }

  return (
    <div className="container mt-4">
      <h2>Update Employee</h2>

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
          disabled
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

      <button className="btn btn-primary me-2" onClick={handleUpdate}>Update</button>
      <Link to="/" className="btn btn-secondary">Back</Link>
    </div>
  )
}