package com.employee.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Exception.DepartmentNotFoundException;
import com.employee.Exception.EmployeeNotFoundException;
import com.employee.dto.Employeeform;
import com.employee.dto.Response;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.employee.util.Converter;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;
	private final Converter converter;

	@PostMapping("/saveEmployee")
	public Employeeform saveEmployee(@RequestBody Employeeform employeeform) {
		Employee emp = converter.getEmployee(employeeform);
		emp = employeeService.saveEmployee(emp);
		Employeeform empFrom = converter.getEmployeeform(emp);
		return empFrom;
	}

	@GetMapping("/getEmployee/{id}")
	public Response getEmployee(@PathVariable Long id) throws EmployeeNotFoundException, DepartmentNotFoundException {
		return getEmployeeFrom(id);

	}

	@GetMapping("/getEmployee")
	public Response getEmployeeParm(@RequestParam("id") Long id) throws EmployeeNotFoundException, DepartmentNotFoundException {
		return getEmployeeFrom(id);

	}

	private Response getEmployeeFrom(Long id) throws EmployeeNotFoundException, DepartmentNotFoundException {
		return employeeService.getEmployee(id);
		
	}
}
