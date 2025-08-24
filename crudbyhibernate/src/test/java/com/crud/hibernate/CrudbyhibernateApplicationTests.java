package com.crud.hibernate;


import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.crud.hibernate.entity.Employee;
import com.crud.hibernate.repository.EmployeeRepository;



@SpringBootTest
class CrudbyhibernateApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;
	Employee employee;
	
	@BeforeEach
	public void createBean() {
		employee = new Employee();
	}
	
	@AfterEach
	public void testCompleted(){
		System.out.println("Test Completed");
	}
	
	@Test
	void createEmployee() {
		employee.setEmployeeName("surya");
		employee.setEmployeeMobileNo("7854088896");
		employee.setEmployeeAge(50);
		
		employeeRepository.save(employee);
	}
	
	@Test
	void deleteEmployee() {
		employeeRepository.deleteById(1l);
	}
	
	@Test
	void readEmployee() {
		Optional<Employee> emp = employeeRepository.findById(2l);
		if(emp.isPresent()) {
			System.out.println("Employee ID : "+emp.get().getEmployeeId());
			System.out.println("Employee Name : "+emp.get().getEmployeeName());
			System.out.println("Employee Mobile No : "+emp.get().getEmployeeMobileNo());
			System.out.println("Employee Age : "+emp.get().getEmployeeAge());
		} else {
			System.out.println("User Not Found");
		}
	}
	
	@Test
	void readsEmployees() {
		List<Employee> emps = employeeRepository.findAll();
		
		for(Employee emp : emps) {
			System.out.println("=================================");
			System.out.println("Employee ID : "+emp.getEmployeeId());
			System.out.println("Employee Name : "+emp.getEmployeeName());
			System.out.println("Employee Mobile No : "+emp.getEmployeeMobileNo());
			System.out.println("Employee Age : "+emp.getEmployeeAge());
			System.out.println("=================================");
		}
	}
	
	@Test
	void updateEmployee() {
	    Optional<Employee> emp = employeeRepository.findById(4L);

	    if (emp.isPresent()) {
	        Employee existingEmp = emp.get();
	        existingEmp.setEmployeeName("gokul");
	        existingEmp.setEmployeeMobileNo("8525963251");
	        existingEmp.setEmployeeAge(23);

	        employeeRepository.save(existingEmp);

	    } else {
	        fail("Employee with ID 3 not found!");
	    }
	}


}
