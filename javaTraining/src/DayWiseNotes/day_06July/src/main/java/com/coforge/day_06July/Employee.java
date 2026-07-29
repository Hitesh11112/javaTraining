package com.coforge.day_06July;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Employee implements Comparable<Employee>{
	private String ename;
	private int eid;
	private String city;
	private String dept;
	private double salary;

	@Override
	public String toString() {
	    return "Employee [ename=" + ename +
	           ", eid=" + eid +
	           ", city=" + city +
	           ", dept=" + dept +
	           ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.getDept().compareTo(o.getDept());
	}
}


