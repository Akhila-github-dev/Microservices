package com.employee.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.employee.Exception.EmployeeNotFoundException;
import com.employee.dto.Departmentform;
import com.employee.dto.Employeeform;
import com.employee.dto.Response;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.util.Converter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final RestTemplate restTemplate;
	private final Converter converter;

	@Transactional
	public Employee saveEmployee(Employee department) {

		return employeeRepository.save(department);
	}

	public Response getEmployee(Long id) throws EmployeeNotFoundException {
		Response response = new Response();
		Employeeform empFrom = null;
		Optional<Employee> optEmp = employeeRepository.findById(id);

		if (optEmp.isPresent()) {
			empFrom = converter.getEmployeeform(optEmp.get());
			response.setEmployeeform(empFrom);
		} else {
			throw new EmployeeNotFoundException("Employee not found Exception");
		}
		Departmentform departmentform = restTemplate
				.getForObject("http://department/dept/getDepartment/" + empFrom.getDeptId(), Departmentform.class);
		response.setDepartmentform(departmentform);
		return response;
	}
}
