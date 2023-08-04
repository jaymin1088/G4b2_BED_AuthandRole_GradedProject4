package com.glearning.emps.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.emps.addrequest.EmployeeAddRequest;
import com.glearning.emps.exception.ResourceNotFoundException;
import com.glearning.emps.model.Employee;

import com.glearning.emps.service.EmployeeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@PreAuthorize("hasRole('ADMIN')")
	public Employee saveEmployee(@RequestBody EmployeeAddRequest employeeAddRequest) {
		Employee employee = new Employee();
		employee.setFirstname(employeeAddRequest.getFirstname());
		employee.setLastname(employeeAddRequest.getLastname());
		employee.setEmail(employeeAddRequest.getEmail());
		return this.employeeService.save(employee);
	}

	@GetMapping
	@ApiResponses({ @ApiResponse(description = "Fetches all the employees", responseCode = "200"),
			@ApiResponse(description = "You are not authenticated user", responseCode = "401"),
			@ApiResponse(description = "You are not authorized user", responseCode = "403") })
	public Set<Employee> fetchEmployees() {
		return this.employeeService.fetchAll();
	}

	@GetMapping("/{id}")
	@ApiResponses({ @ApiResponse(description = "Fetches the employee with the id passed", responseCode = "200"),
			@ApiResponse(description = "You are not authenticated user", responseCode = "401"),
			@ApiResponse(description = "You are not authorized user", responseCode = "403") })

	public Employee findEmployeeById(@PathVariable("id") long id) {
		return this.employeeService.findById(id);
	}

	@GetMapping("/search/{firstname}")
	public Set<Employee> findEmployeesByFirstName(@PathVariable("firstname") String firstname) {
		return this.employeeService.fetchEmployeesByFirstname(firstname);
	}

	@GetMapping("/sort")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Employee> getAllEmployeesSorted(@RequestParam(name = "order", defaultValue = "asc") String order) {
		if (order.equalsIgnoreCase("desc")) {
			return employeeService.fetchAllSortedByFirstNameDesc();
		} else {
			return employeeService.fetchAllSortedByFirstNameAsc();
		}
	}

	@GetMapping("/name/{firstname}")
	public Set<Employee> findEmployeeByAge(@PathVariable("firstname") String firstname) {
		return this.employeeService.fetchEmployeesByFirstname(firstname);
	}

	@GetMapping("/name/{lastname}")
	public Set<Employee> findEmployeeByfirstName(@PathVariable("lastname") String lastname) {
		return this.employeeService.fetchEmployeesByLastname(lastname);
	}

	@GetMapping("/name/{email}")
	public Set<Employee> findEmployeeByemail(@PathVariable("email") String email) {
		return this.employeeService.fetchEmployeesByEmail(email);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Employee updateEmployee(@PathVariable("id") long id, @RequestBody EmployeeAddRequest employeeUpdateRequest) {
		Employee employee = employeeService.findById(id);
		if (employee == null) {
			throw new ResourceNotFoundException("Employee with ID " + id + " not found.");
		}

		// Update the employee fields
		employee.setId(employeeUpdateRequest.getId());
		employee.setFirstname(employeeUpdateRequest.getFirstname());
		employee.setLastname(employeeUpdateRequest.getLastname());
		employee.setEmail(employeeUpdateRequest.getEmail());

		// Save the updated employee
		return employeeService.save(employee);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long id) {
		employeeService.deleteById(id);
		return ResponseEntity.ok("Deleted employee id - " + id);
	}

}
