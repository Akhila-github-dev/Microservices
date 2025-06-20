package com.department.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.department.Exception.DepartmentNotFoundException;
import com.department.dto.Departmentform;
import com.department.entity.Department;
import com.department.repository.DepartmentRepository;
import com.department.util.Converter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {

	private final DepartmentRepository departmentRepository;
	private final Converter converter;
	
	@Transactional
	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
	}

	public Departmentform getDepartment(Long id) throws DepartmentNotFoundException {
		Departmentform departmentform=null;
		Optional<Department> optDept = departmentRepository.findById(id);
		
		if(optDept.isPresent()) {
			departmentform=converter.getDepartmentFrom(optDept.get());
			return departmentform;
		}
		throw new DepartmentNotFoundException("department not found Exception");
		
		
	}
}
