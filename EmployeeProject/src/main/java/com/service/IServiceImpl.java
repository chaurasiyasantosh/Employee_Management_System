package com.service;

import java.util.List;

import com.dao.Dao;
import com.model.Employee;
import com.util.SessionFactory;

public class IServiceImpl implements Service {

	private Dao dao;

	public IServiceImpl() {
		dao = SessionFactory.getDao();
	}

	@Override
	public String add(Employee emp) {
		return dao.add(emp);
	
	}

	@Override
	public Employee getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public String deleteById(Long id) {
		return dao.deleteById(id);
	}

	@Override
	public String updateById(Employee emp) {
		return dao.updateById(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
