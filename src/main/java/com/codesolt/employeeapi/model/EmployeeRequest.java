package com.codesolt.employeeapi.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EmployeeRequest {
	
	@NotBlank
	@Size(max=64)
	private String firstName;
	@Size(min=1, max=1)
	private String middleName;
	@NotBlank
	@Size(max=64)
	private String lastName;
	@NotNull
	private LocalDate birthDate;
	@NotNull
	private LocalDate employmentDate;	
}
