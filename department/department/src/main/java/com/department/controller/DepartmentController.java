package com.department.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.department.Exception.DepartmentNotFoundException;
import com.department.dto.Departmentform;
import com.department.entity.Department;
import com.department.service.DepartmentService;
import com.department.util.Converter;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

	private final DepartmentService departmentService;
	private final Converter converter;

	/*
	 * @PostMapping("/saveDepartment") public Department saveDepartment(@RequestBody
	 * departmentform departmentform) { Department dept = new Department();
	 * dept.setName(departmentform.getName()); dept.setId(departmentform.getId());
	 * dept.setLocation(departmentform.getLocation()); return
	 * departmentService.saveDepartment(dept);
	 * 
	 * }
	 */

	@PostMapping("/saveDepartment")
	public Departmentform saveDepartment(@RequestBody Departmentform departmentform) {
		Department dept = converter.getDepartment(departmentform);
		dept= departmentService.saveDepartment(dept);
		return converter.getDepartmentFrom(dept);

	}

	@GetMapping("/getDepartment/{id}")
	public Departmentform getDepartment(@PathVariable Long id) throws DepartmentNotFoundException {
		
		return getDepatmentFrom(id);

	}

	@GetMapping("/getDepartment")
	public Departmentform getDepartmentparm(@RequestParam("id") Long id) throws DepartmentNotFoundException {

		return getDepatmentFrom(id);

	}
	
	private Departmentform getDepatmentFrom(Long id) throws DepartmentNotFoundException {
		
		return departmentService.getDepartment(id);
	}
	
	
}
