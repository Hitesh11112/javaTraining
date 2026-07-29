package com.example.department.service;

import java.util.List;

import com.example.department.dto.DepartmentRequestDto;
import com.example.department.dto.DepartmentResponseDto;
import com.example.department.entity.Department;

public interface DepartmentService {
    DepartmentResponseDto createDepartment(DepartmentRequestDto requestDto);
    List<DepartmentResponseDto> getAllDepartments();
    DepartmentResponseDto getDepartmentById(Integer did);
    DepartmentResponseDto updateDepartment(Integer did, DepartmentRequestDto requestDto);
    void deleteDepartment(Integer did);
    
    Department getDepartmentWithEmployees(Integer did);
}
