package com.spring.sample.springorm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.sample.springorm.dao.EmployeeDao;
import com.spring.sample.springorm.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public void create(Employee employee) {
		employeeDao.create(employee);
	}
	
	public void update(Employee employee) {
		employeeDao.update(employee);
	}
	
	public void delete(String empId) {
		employeeDao.delete(empId);
	}
	
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}
	
	public Employee findById(String empId) {
		return employeeDao.findById(empId);
	}

}

