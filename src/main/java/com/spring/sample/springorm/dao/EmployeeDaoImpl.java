package com.spring.sample.springorm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sample.springorm.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void create(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
	}

	public void update(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
	}

	public void delete(String empId) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, empId);
		if(null!=employee)
			sessionFactory.getCurrentSession().delete(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAll() {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		return (List<Employee>) criteria.list();
	}

	public Employee findById(String empId) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("empId",empId));
		return (Employee) criteria.uniqueResult();
	}
}
