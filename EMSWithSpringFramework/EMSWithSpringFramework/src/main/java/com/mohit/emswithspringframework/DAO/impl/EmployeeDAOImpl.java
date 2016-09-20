/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.emswithspringframework.DAO.impl;

import com.mohit.emswithspringframework.DAO.EmployeeDAO;
import com.mohit.emswithspringframework.entity.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohit
 */
@Repository(value = "employeeDao")
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Employee em) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO tbl_employees(first_name,last_name,email_id,contact_number)" + "VALUES(?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{
            em.getFirstName(),
            em.getLastName(),
            em.getEmailId(),
            em.getContactNumber()
        });
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Employee em) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE tbl_employees SET first_name=?,last_name=?,email_id=?,contact_number=? WHERE employee_id=?";
        return jdbcTemplate.update(sql, new Object[]{
            em.getFirstName(),
            em.getLastName(),
            em.getEmailId(),
            em.getContactNumber(),
            em.getId()
        });
    }

    @Override
    public List<Employee> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tbl_employees";
        return jdbcTemplate.query(sql, new RowMapper<Employee>() {

            @Override
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                Employee e = new Employee();
                e.setId(rs.getInt("employee_id"));
                e.setFirstName(rs.getString("first_name"));
                e.setLastName(rs.getString("last_name"));
                e.setEmailId(rs.getString("email_id"));
                e.setContactNumber(rs.getString("contact_number"));
                return e;
            }
        });
    }

    @Override
    public Employee getById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tbl_employees WHERE employee_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Employee>() {

            @Override
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                Employee e = new Employee();
                e.setId(rs.getInt("employee_id"));
                e.setFirstName(rs.getString("first_name"));
                e.setLastName(rs.getString("last_name"));
                e.setEmailId(rs.getString("email_id"));
                e.setContactNumber(rs.getString("contact_number"));
                return e;
            }
        });
    }


}
