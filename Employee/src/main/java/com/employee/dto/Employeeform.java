package com.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employeeform {

	private Long id;
	private String name;
	private String address;
	private Double salary;
	private Long deptId;
}
