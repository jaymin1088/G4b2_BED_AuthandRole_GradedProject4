package com.glearning.emps.serviceimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.emps.dao.EmployeeRepository;
import com.glearning.emps.model.Employee;
import com.glearning.emps.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public Employee save(Employee employee) {
		return this.empRepository.save(employee);
	}

	@Override
	public Set<Employee> fetchAll() {

		return new HashSet<>(this.empRepository.findAll());
	}

	@Override
	public Employee findById(long id) {
		return this.empRepository.findById(id).orElseThrow();
	}

	@Override
	public void deleteById(long id) {
		this.empRepository.deleteById(id);
	}

	@Override
	public Set<Employee> fetchEmployeesByFirstname(String firstname) {
		return empRepository.findByFirstnameContainingIgnoreCase(firstname);
	}

	@Override
	public Set<Employee> fetchEmployeesByLastname(String lastname) {
		return empRepository.findByLastnameContainingIgnoreCase(lastname);
	}

	@Override
	public Set<Employee> fetchEmployeesByEmail(String email) {
		return empRepository.findByEmailContainingIgnoreCase(email);
	}

	@Override
	public Set<Employee> fetchAllEmployees() {

		return new HashSet<>(this.empRepository.findAll());
	}

	@Override
	public List<Employee> fetchAllSortedByFirstNameAsc() {
		return empRepository.findAllByOrderByFirstnameAsc();
	}

	@Override
	public List<Employee> fetchAllSortedByFirstNameDesc() {
		return empRepository.findAllByOrderByFirstnameDesc();
	}

}
