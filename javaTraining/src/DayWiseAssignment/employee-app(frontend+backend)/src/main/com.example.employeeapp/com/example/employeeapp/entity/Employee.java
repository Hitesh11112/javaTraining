package com.example.employeeapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "emp_Table")
public class Employee {

    @Id
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Designation is required")
    private String desg;

    public Employee() {
    }

    public Employee(Long id, String name, String desg) {
        this.id = id;
        this.name = name;
        this.desg = desg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesg() {
        return desg;
    }

    public void setDesg(String desg) {
        this.desg = desg;
    }
}
