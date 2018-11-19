package com.codesolt.employeeapi.model;

import java.time.LocalDate;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EmployeePatchRequest {
	
	@Size(max=64)
	private String firstName;
	@Size(min=1, max=1)
	private String middleName;
	@Size(max=64)
	private String lastName;
	private LocalDate birthDate;
	private LocalDate employmentDate;	
}
