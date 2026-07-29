package com.example.employee.dao;

import java.util.List;
import java.util.Optional;

import com.example.employee.entity.Employee;

public interface EmployeeDao {
    Employee save(Employee employee);
    List<Employee> findAll();
    Optional<Employee> findById(Integer eid);
    void delete(Employee employee);
    boolean existsByEmail(String email);
    boolean existsByMobile(String mobile);
    boolean existsByEmailAndEidNot(String email, Integer eid);
    boolean existsByMobileAndEidNot(String mobile, Integer eid);
    
    List<Employee> findByDid(Integer did);
}
