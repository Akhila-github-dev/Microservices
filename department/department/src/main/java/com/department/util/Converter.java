package com.department.util;

import org.springframework.stereotype.Component;

import com.department.dto.Departmentform;
import com.department.entity.Department;

@Component
public class Converter {
	
	public Department getDepartment(Departmentform departmentform) {
		return Department.builder()
				.id(departmentform.getId())
				.name(departmentform.getName())
				.location(departmentform.getLocation())
				.build();
		
	}

	
	public Departmentform getDepartmentFrom(Department department) {
		return Departmentform.builder()
				.id(department.getId())
				.name(department.getName())
				.location(department.getLocation())
				.build();
		
	}
	
}
