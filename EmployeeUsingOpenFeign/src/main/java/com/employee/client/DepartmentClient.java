package com.employee.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.Exception.DepartmentNotFoundException;
import com.employee.dto.Departmentform;



@FeignClient(name ="department")
public interface DepartmentClient {
	
	@GetMapping("/dept/getDepartment/{id}")
	public Departmentform getDepartment(@PathVariable Long id) throws DepartmentNotFoundException ;
		
	

}
