package com.gl.employeerepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gl.employeemodel.Role;
import com.gl.employeemodel.User;

@Repository
public interface UserRepository extends JpaRepository<Role, Long> {
    User findByName(String name);
}
