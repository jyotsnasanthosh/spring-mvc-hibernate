package com.spring.sample.springorm.service;

import java.util.List;

import com.spring.sample.springorm.model.Employee;

public interface EmployeeService {

	public void create(Employee employee);
	public void update(Employee employee);
	public void delete(String empId);
	public List<Employee> findAll();
	public Employee findById(String empId);
}
