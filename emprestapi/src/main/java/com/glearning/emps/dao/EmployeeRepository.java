package com.glearning.emps.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.emps.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Set<Employee> findByFirstnameContainingIgnoreCase(String firstname);

	Set<Employee> findByLastnameContainingIgnoreCase(String lastname);

	Set<Employee> findByEmailContainingIgnoreCase(String email);

	List<Employee> findAllByOrderByFirstnameAsc();

	List<Employee> findAllByOrderByFirstnameDesc();
}
