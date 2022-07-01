package org.example;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeService {

    public List<Employee> fetchData() throws SQLException {
        String SQL_QUERY = "select * from emp";
        List
                <Employee> employees = null;
        try (Connection con = DataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(SQL_QUERY);
             ResultSet rs = pst.executeQuery();) {
            employees = new ArrayList<>();
            Employee employee;
            while (rs.next()) {
                employee = new Employee();
                employee.setEmpNo(rs.getInt("empno"));
                employee.setEname(rs.getString("ename"));
                employee.setJob(rs.getString("job"));
                employee.setMgr(rs.getInt("mgr"));
                employee.setHiredate(rs.getDate("hiredate"));
                employee.setSal(rs.getInt("sal"));
                employee.setComm(rs.getInt("comm"));
                employee.setDeptno(rs.getInt("deptno"));
                employees.add(employee);
            }
        }
        return employees;
    }

    @Getter
    @Setter
    static
    class Employee {
        int empNo;
        String ename;
        String job;
        int mgr;
        Date hiredate;
        int sal;
        int comm;
        int deptno;

    }


    @Getter
    @Setter
    static class Department {
        int deptno;
        String dname;
        String loc;
    }

}
