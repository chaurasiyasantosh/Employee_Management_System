package com.dao;

import java.util.List;

import com.model.Employee;

public interface Dao {
	String add(Employee emp);

	Employee getById(Long id);

	String deleteById(Long id);

	String updateById(Employee id);
	
	List<Employee> getAllEmployees();
}
