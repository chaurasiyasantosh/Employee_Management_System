package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.Employee;
import com.util.HibernateUtil;

public class MySQLDao implements Dao {
	private Session session;
	private Transaction transaction = null;
	private boolean flag;
	private String status = "failure";

	public MySQLDao() {
		session = HibernateUtil.getSession();
	}

	@Override
	public String add(Employee emp) {
		try {
			if (session != null) {
				transaction = session.beginTransaction();

				if (transaction != null) {
					flag = true;
					status = "success";
					session.persist(emp);
				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
			}
		}
		return status;
	}

	@Override
	public Employee getById(Long id) {
		Employee emp = new Employee();
		try {
			if (session != null) {
				emp = session.get(Employee.class, id);
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return emp;
	}

	@Override
	public String deleteById(Long id) {
		Employee emp = new Employee();
		emp.setId(id);
		try {
			if (session != null) {
				transaction = session.beginTransaction();

				if (transaction != null) {
					session.delete(emp);
					flag = true;
					status = "success";
				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag)
				transaction.commit();
			else
				transaction.rollback();
		}
		return status;
	}

	@Override
	public String updateById(Employee emp) {
		try {
			if (session != null) {
				transaction = session.beginTransaction();

				if (transaction != null) {
					session.update(emp);
					flag = true;
					status = "success";
				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag)
				transaction.commit();
			else
				transaction.rollback();
		}
		return status;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = null;
		try {
			if (session != null) {
				Query<Employee> query = session.createQuery("FROM com.model.Employee");
				empList = query.getResultList();
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}
}
