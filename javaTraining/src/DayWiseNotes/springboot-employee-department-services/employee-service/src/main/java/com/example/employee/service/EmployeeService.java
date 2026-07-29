package com.example.employee.service;

import java.util.List;

import com.example.employee.dto.EmployeeRequestDto;
import com.example.employee.dto.EmployeeResponseDto;

public interface EmployeeService {
    EmployeeResponseDto createEmployee(EmployeeRequestDto requestDto);
    List<EmployeeResponseDto> getAllEmployees();
    EmployeeResponseDto getEmployeeById(Integer eid);
    EmployeeResponseDto updateEmployee(Integer eid, EmployeeRequestDto requestDto);
    void deleteEmployee(Integer eid);
    

    List<EmployeeResponseDto> findByDid(Integer did);
}
