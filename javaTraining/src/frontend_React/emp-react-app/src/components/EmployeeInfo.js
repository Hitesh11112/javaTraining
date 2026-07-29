import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { getEmployeeById } from '../service/employeeService'


export const EmployeeInfo = () => {
  const { id } = useParams()
  const [employee, setEmployee] = useState(null)

  useEffect(() => {
    getEmployeeById(id)
    .then((response) => {
      setEmployee(response.data)
    })
    .catch((error) => {
      console.log(error)
    })
  }, [id])

  if (!employee) {
    return (
      <div className="container mt-4">
        <h2>Employee Info</h2>
        <p>Loading...</p>
      </div>
    )
  }

  return (
    <div className="container mt-4">
      <h2>Employee Info</h2>

      <table className="table table-bordered w-50">
        <tbody>
          <tr>
            <th>Id</th>
            <td>{employee.id}</td>
          </tr>
          <tr>
            <th>Name</th>
            <td>{employee.name}</td>
          </tr>
          <tr>
            <th>Designation</th>
            <td>{employee.desg}</td>
          </tr>
        </tbody>
      </table>

      <Link to="/" className="btn btn-secondary">Back</Link>
    </div>
  )
}