package com.ofss.main;

import java.util.List;
import java.util.Scanner;

import com.ofss.domain.Employee;
import com.ofss.repository.EmployeeRepository;

public class EmployeeMain {

	private static EmployeeRepository employeeCRUD = new EmployeeRepository();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// A single flag to re run the operations by the user.
		boolean still_continue = true;

		do {

			// Menu for the user
			System.out.println("Menu,");
			System.out.println("1. Add New Employee");
			System.out.println("2. Update Name and Salary for an existing employee");
			System.out.println("3. Delete an employee by employeeId");
			System.out.println("4. Find an employee by employeeId");
			System.out.println("5. Find all employees");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("Please enter the id of the employee");
				int employeeId = scanner.nextInt();
				System.out.println("Please enter the name of the employee");
				String name = scanner.next();
				scanner.nextLine();
				System.out.println("Please enter the salary of the employee");
				double sal = scanner.nextDouble();
				if (employeeCRUD.addNewEmployee(new Employee(employeeId, name, sal))) {
					System.out.println("Inserted employee details successfully!");
				} else {
					System.out.println("Sorry you please check your details and try again!");
				}
				break;

			}
			case 2: {
				System.out.println("Please enter the id of the employee");
				int employeeId = scanner.nextInt();
				System.out.println("Please enter the name of the employee");
				String name = scanner.next();
				scanner.nextLine();
				System.out.println("Please enter the salary of the employee");
				double sal = scanner.nextDouble();

				if (employeeCRUD.updateEmployee(new Employee(employeeId, name, sal))) {
					System.out.println("Employee Details updated successfully");
				} else {
					System.out.println("There is some problem");
				}
				break;
			}
			case 3: {
				System.out.println("Please enter the id of the employee");
				int employeeId = scanner.nextInt();
				if (employeeCRUD.deleteEmployeeByEmployeeId(employeeId)) {
					System.out.println("Employee Details deleted successfully");
				} else {
					System.out.println("There is some problem");
				}
				break;
			}
			case 4: {

				System.out.println("Please enter the id of the employee");
				int employeeId = scanner.nextInt();
				Employee employee = employeeCRUD.getEmployeeByEmployeeId(employeeId);
				if (employee != null) {
					System.out.println("Employee Details are");
					System.out.println(employee);
				} else {
					System.out.println("There is some problem");
				}
				break;
			}
			case 5: {

				List<Employee> allEmployees = employeeCRUD.getAllEmployees();
				if (allEmployees.size() != 0) {
					for (Employee employee : allEmployees) {
						System.out.println(employee);
					}
				} else {
					System.out.println("There are no employees currently!");
				}
				break;
			}
			default:
				System.out.println("Please choose a correct option!");
			}

			System.out.println("Do you want to do more operations? yes/no");
			if (scanner.next().equals("no")) {
				still_continue = false;
			}

		} while (still_continue);

		System.out.println("Thank you! You can close this window now.");
		
		scanner.close();

	}
}
