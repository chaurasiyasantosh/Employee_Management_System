package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Employee;
import com.service.Service;
import com.util.SessionFactory;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@SuppressWarnings("unused")
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		Service service = null;
		RequestDispatcher rd = null;
		Employee employee = null;

		if (uri.endsWith("add")) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			Integer phoneNo = Integer.parseInt(request.getParameter("phoneNo"));
			Integer salary = Integer.parseInt(request.getParameter("salary"));
			Integer age = Integer.parseInt(request.getParameter("age"));
			String department = request.getParameter("department");
			String address = request.getParameter("address");

			service = SessionFactory.getService();
			employee = new Employee();
			employee.setFirstName(firstName);
			employee.setEmail(email);
			employee.setLastName(lastName);
			employee.setGender(gender);
			employee.setAge(age);
			employee.setPhoneNo(phoneNo);
			employee.setSalary(salary);
			employee.setAddress(address);

			String status = service.add(employee);
			;
			System.out.println(status);

			if ("success".equals(status))
				rd = request.getRequestDispatcher("../success.jsp");
			else
				rd = request.getRequestDispatcher("../failure.jsp");
			rd.forward(request, response);
		}

		if (uri.endsWith("get")) {
			String readId = request.getParameter("readId");
			service = SessionFactory.getService();
			employee = service.getById(new Long(readId));
			String status = (employee == null) ? "failure" : "success";
			System.out.println(employee);

			if ("success".equals(status)) {
				request.setAttribute("employee", employee);
				rd = request.getRequestDispatcher("../get.jsp");
			} else
				rd = request.getRequestDispatcher("../failure.jsp");
			rd.forward(request, response);
		}

		if (uri.endsWith("delete")) {
			String deleteId = request.getParameter("deleteId");
			service = SessionFactory.getService();
			String status = service.deleteById(new Long(deleteId));

			if ("success".equals(status)) {
				rd = request.getRequestDispatcher("../success.jsp");
			} else
				rd = request.getRequestDispatcher("../failure.jsp");
			rd.forward(request, response);
		}

		if (uri.endsWith("getAllEmployees")) {
			service = SessionFactory.getService();
			List<Employee> empList = service.getAllEmployees();
			String status = empList == null ? "failure" : "success";

			if ("success".equals(status)) {
				rd = request.getRequestDispatcher("../success.jsp");
			} else
				rd = request.getRequestDispatcher("../failure.jsp");
			rd.forward(request, response);
		}

	}

}
