package org.hikari;

import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException {
        EmployeeService employeeService = new EmployeeService();
        List<EmployeeService.Employee> employees = employeeService.fetchData();
        employees.forEach(e -> System.out.println(e.ename));
    }


}


