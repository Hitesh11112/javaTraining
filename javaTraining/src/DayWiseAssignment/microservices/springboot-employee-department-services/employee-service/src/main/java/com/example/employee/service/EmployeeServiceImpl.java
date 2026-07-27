package com.example.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.dto.EmployeeRequestDto;
import com.example.employee.dto.EmployeeResponseDto;
import com.example.employee.entity.Employee;
import com.example.employee.exception.DuplicateResourceException;
import com.example.employee.exception.EmployeeNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto dto) {
        validateUniqueFields(dto.email(), dto.mobile(), null);

        Employee employee = Employee.builder()
                .ename(dto.ename())
                .salary(dto.salary())
                .mobile(dto.mobile())
                .email(dto.email())
                .did(dto.did()) // <--- Pass did to entity
                .build();

        return mapToResponse(employeeDao.save(employee));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeDao.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeResponseDto getEmployeeById(Integer eid) {
        return mapToResponse(findEmployee(eid));
    }

    @Override
    public EmployeeResponseDto updateEmployee(Integer eid, EmployeeRequestDto dto) {
        Employee employee = findEmployee(eid);
        validateUniqueFields(dto.email(), dto.mobile(), eid);

        employee.setEname(dto.ename());
        employee.setSalary(dto.salary());
        employee.setMobile(dto.mobile());
        employee.setEmail(dto.email());
        employee.setDid(dto.did()); // <--- Update did on entity

        return mapToResponse(employeeDao.save(employee));
    }

    @Override
    public void deleteEmployee(Integer eid) {
        Employee employee = findEmployee(eid);
        employeeDao.delete(employee);
    }

    private Employee findEmployee(Integer eid) {
        return employeeDao.findById(eid)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found with id: " + eid));
    }

    private void validateUniqueFields(String email, String mobile, Integer eid) {
        boolean emailExists = eid == null
                ? employeeDao.existsByEmail(email)
                : employeeDao.existsByEmailAndEidNot(email, eid);

        boolean mobileExists = eid == null
                ? employeeDao.existsByMobile(mobile)
                : employeeDao.existsByMobileAndEidNot(mobile, eid);

        if (emailExists) {
            throw new DuplicateResourceException("Email already exists: " + email);
        }

        if (mobileExists) {
            throw new DuplicateResourceException("Mobile number already exists: " + mobile);
        }
    }

    private EmployeeResponseDto mapToResponse(Employee employee) {
        return new EmployeeResponseDto(
                employee.getEid(),
                employee.getEname(),
                employee.getSalary(),
                employee.getMobile(),
                employee.getEmail(),
                employee.getDid() // <--- Pass did into 6-arg record constructor!
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponseDto> findByDid(Integer did) {
        return employeeDao.findByDid(did)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
}