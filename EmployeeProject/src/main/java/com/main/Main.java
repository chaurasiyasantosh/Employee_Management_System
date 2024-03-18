package com.main;

import java.util.List;
import java.util.Scanner;

import com.controller.Controller;
import com.model.Employee;
import com.util.SessionFactory;

public class Main {

	private static Controller controller;
	static {
		controller = SessionFactory.getController();
	}

	public static void main(String[] args) {

		Employee emp = null;
		boolean loop = true;

		while (loop) {
			System.out.println();
			System.out.println();
			System.out.println("-----------------------------");
			System.out.println("Enter 1 :: Add Employee");
			System.out.println("Enter 2 :: Get Employee By Id");
			System.out.println("Enter 3 :: Delete Employee By Id");
			System.out.println("Enter 4 :: Update Employee By Id");
			System.out.println("Enter 5 :: Get All Employees");
			System.out.println("-----------------------------");

			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			if (option == 1) {
				System.out.println("Enter the name");
				String name = sc.next();
				System.out.println("Enter the Salary");
				double salary = sc.nextDouble();
				emp = new Employee(name, salary);
				controller.add(emp);

			} else if (option == 2) {
				System.out.println("Enter id :: ");
				Long id = sc.nextLong();
				emp = controller.getById(id);
				System.out.println(emp);
			} else if (option == 3) {
				System.out.println("Enter id :: ");
				Long id = sc.nextLong();
				controller.deleteById(id);

			} else if (option == 4) {
				System.out.println("Enter id :: ");
				Long id = sc.nextLong();
				emp = controller.getById(id);

				Employee newEmployee = null;
				if (emp != null) {
					newEmployee = new Employee();
					newEmployee.setId(emp.getId());
					System.out.println("old Name :: " + emp.getName());
					System.out.println("Enter new name :: ");
					String newName = sc.next();
					if (newName.length() > 1)
						newEmployee.setName(newName);
					else
						newEmployee.setName(emp.getName());

					System.out.println("old salary :: " + emp.getSalary());
					System.out.println("Enter new salary :: ");
					double newSalary = sc.nextDouble();
					newEmployee.setSalary(newSalary);

				}
				controller.updateById(newEmployee);

			} else if (option == 5) {
				List<Employee> employeeList = controller.getAllEmployees();
				if (employeeList != null) {
					employeeList.forEach(System.out::println);
				} else {
					System.out.println("No data available :: ");
				}
			} else {

				System.out.println("Option Error :: ");
				loop = false;
				sc.close();
			}
		}

	}

}
