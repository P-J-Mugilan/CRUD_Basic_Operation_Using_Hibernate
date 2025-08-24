package com.crud.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.hibernate.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	

}
