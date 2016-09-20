/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.emswithspringframework.DAO;

import com.mohit.emswithspringframework.entity.Employee;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mohit
 */
public interface EmployeeDAO {

    int insert(Employee em) throws SQLException, ClassNotFoundException;

    int delete(int id) throws SQLException, ClassNotFoundException;

    int update(Employee em) throws SQLException, ClassNotFoundException;

    List<Employee> getAll() throws SQLException, ClassNotFoundException;

    Employee getById(int id) throws SQLException, ClassNotFoundException;

   
}
