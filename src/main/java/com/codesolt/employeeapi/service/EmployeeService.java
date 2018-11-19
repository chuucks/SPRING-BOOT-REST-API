package com.codesolt.employeeapi.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesolt.employeeapi.exception.EmployeeNotFoundException;
import com.codesolt.employeeapi.model.Employee;
import com.codesolt.employeeapi.model.EmployeePatchRequest;
import com.codesolt.employeeapi.model.EmployeeRequest;
import com.codesolt.employeeapi.repository.EmployeeRepository;
import com.codesolt.employeeapi.util.EmployeeDictionary;
import com.codesolt.employeeapi.util.EmployeeUtil;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	public Employee createEmployee(EmployeeRequest request) {
		Employee employee = new ModelMapper().map(request, Employee.class);
		employee.setStatus(EmployeeDictionary.ACTIVE_STATUS);
		return repo.save(employee);
	}
	
	public List<Employee> getEmployees() {
		return repo.findByStatus(EmployeeDictionary.ACTIVE_STATUS);
	}
	
	public Employee getEmployee(Long id) {		
		return employeeExists(id);
	}
	
	public Employee updateEmployee(Long id, EmployeeRequest request) {
		employeeExists(id);
		Employee employee = new ModelMapper().map(request, Employee.class);
		return repo.save(employee);		
	}
	
	public Employee patchEmployee(Long id, EmployeePatchRequest request) {
		Employee employee = employeeExists(id);
		return repo.save(EmployeeUtil.patchLogic(employee, request));
	}
	
	public String deleteEmployee(Long id) {		
		Employee employee = employeeExists(id);
		employee.setStatus(EmployeeDictionary.INACTIVE_STATUS);
		repo.save(employee);
		return "Employee " + id + " deleted";
	}
	
	private Employee employeeExists(Long id) {
		Optional<Employee> existing = repo.findById(id);
		if(!existing.isPresent())
			throw new EmployeeNotFoundException("Employee: " + id + " not found");
		if(existing.get().getStatus().equals(EmployeeDictionary.INACTIVE_STATUS))
			throw new EmployeeNotFoundException("Employee: " + id + " not found");
		return existing.get();
	}
}
