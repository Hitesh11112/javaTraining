import axios from "axios"

const baseurl="http://localhost:8081/api/employees"

export const getAllEmployees=()=>{
    return axios.get(baseurl)
}

export const addEmployee=(employee)=>{
    return axios.post(baseurl, employee)
}

export const deleteEmployee=(id)=>{
    return axios.delete(`${baseurl}/${id}`)
}

export const getEmployeeById=(id)=>{
    return axios.get(`${baseurl}/${id}`)
}

export const updateEmployee=(id, employee)=>{
    return axios.put(`${baseurl}/${id}`, employee)
}