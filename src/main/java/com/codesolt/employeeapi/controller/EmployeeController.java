package com.codesolt.employeeapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesolt.employeeapi.model.Employee;
import com.codesolt.employeeapi.model.EmployeePatchRequest;
import com.codesolt.employeeapi.model.EmployeeRequest;
import com.codesolt.employeeapi.service.EmployeeService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeRequest request) {
		log.info("POST employee");
		return new ResponseEntity<Employee>(service.createEmployee(request), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() {
		log.info("GET employee");
		return new ResponseEntity<List<Employee>>(service.getEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findAgenda(@PathVariable Long id) {
		log.info("GET employee: " + id);
		return new ResponseEntity<Employee>(service.getEmployee(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, 
			@Valid @RequestBody EmployeeRequest request) {
		log.info("PUT employee: " + id);		
		return new ResponseEntity<Employee>(service.updateEmployee(id, request), HttpStatus.OK);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Employee> patchEmployee(@PathVariable Long id,
			@Valid @RequestBody EmployeePatchRequest request) {
		log.info("PATCH employee: " + id);
		return new ResponseEntity<Employee>(service.patchEmployee(id, request), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		log.info("DELETE employee: " + id);
		return new ResponseEntity<String>(service.deleteEmployee(id), HttpStatus.OK);
	}
}
