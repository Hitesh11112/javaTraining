package com.example.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.EmployeeRequestDto;
import com.example.employee.dto.EmployeeResponseDto;
import com.example.employee.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(
            @Valid @RequestBody EmployeeRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{eid}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(
            @PathVariable Integer eid) {
        return ResponseEntity.ok(employeeService.getEmployeeById(eid));
    }

    @PutMapping("/{eid}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(
            @PathVariable Integer eid,
            @Valid @RequestBody EmployeeRequestDto requestDto) {
        return ResponseEntity.ok(employeeService.updateEmployee(eid, requestDto));
    }

    @DeleteMapping("/{eid}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer eid) {
        employeeService.deleteEmployee(eid);
        return ResponseEntity.noContent().build();
    }
    
//    @GetMapping("/department/{did}")
//    public ResponseEntity<List<EmployeeResponseDto>> findByDid(@PathVariable Integer did) {
//    	List<EmployeeResponseDto> employeeDtos = employeeService.findByDid(did);
//    	return ResponseEntity.ok(employeeDtos);
//    }
    
//    @GetMapping("/department/{did}")
//    public ResponseEntity<Map<String, Object>> findByDid(
//            @PathVariable Integer did) {
//
//        List<EmployeeResponseDto> employeeDtos =
//                employeeService.findByDid(did);
//
//        Map<String, Object> responseMap = new HashMap<>();
//
//        responseMap.put("Port", serverPort);
//        responseMap.put("emp", employeeDtos);
//
//        return ResponseEntity.ok(responseMap);
//    }
//    
    
    @GetMapping("/department/{did}")
    public ResponseEntity<List<EmployeeResponseDto>> findById(@PathVariable Integer did) {
    	List<EmployeeResponseDto> employeeDtos = employeeService.findByDid(did);
    	return ResponseEntity.ok(employeeDtos);
    }
}
