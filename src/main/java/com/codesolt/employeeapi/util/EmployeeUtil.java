package com.codesolt.employeeapi.util;

import com.codesolt.employeeapi.model.Employee;
import com.codesolt.employeeapi.model.EmployeePatchRequest;

public class EmployeeUtil {
	
	public static Employee patchLogic(Employee employee, EmployeePatchRequest request) {
		if(request.getBirthDate() != null)
			employee.setBirthDate(request.getBirthDate());
		if(request.getEmploymentDate() != null)
			employee.setBirthDate(request.getBirthDate());
		if(request.getFirstName() != null)
			employee.setFirstName(request.getFirstName());
		if(request.getLastName() != null)
			employee.setLastName(request.getLastName());
		if(request.getMiddleName() != null)
			employee.setMiddleName(request.getMiddleName());
		return employee;
	}	
}
