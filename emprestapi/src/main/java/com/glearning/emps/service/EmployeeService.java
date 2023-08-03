package com.glearning.emps.service;

import java.util.List;
import java.util.Set;

import com.glearning.emps.model.Employee;

public interface EmployeeService {

	Employee save(Employee employee);

	Set<Employee> fetchAll();

	Employee findById(long id);

	void deleteById(long id);

	Set<Employee> fetchEmployeesByFirstname(String firstname);

	Set<Employee> fetchEmployeesByLastname(String lastname);

	Set<Employee> fetchEmployeesByEmail(String email);

	List<Employee> fetchAllSortedByFirstNameAsc();

	List<Employee> fetchAllSortedByFirstNameDesc();

	Set<Employee> fetchAllEmployees();

}
