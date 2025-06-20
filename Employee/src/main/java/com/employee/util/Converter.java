package com.employee.util;

import org.springframework.stereotype.Component;

import com.employee.dto.Employeeform;
import com.employee.entity.Employee;

@Component
public class Converter {

	public Employee getEmployee(Employeeform employeeform) {
		return Employee.builder().id(employeeform.getId()).name(employeeform.getName())
				.address(employeeform.getAddress()).salary(employeeform.getSalary()).deptId(employeeform.getDeptId())
				.build();

	}

	public Employeeform getEmployeeform(Employee employee) {
		return Employeeform.builder().id(employee.getId()).name(employee.getName()).salary(employee.getSalary())
				.deptId(employee.getDeptId()).address(employee.getAddress()).build();

	}

}
