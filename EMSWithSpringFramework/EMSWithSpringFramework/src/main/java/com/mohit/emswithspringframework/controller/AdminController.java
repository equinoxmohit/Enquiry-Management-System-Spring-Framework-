/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.emswithspringframework.controller;

import com.mohit.emswithspringframework.DAO.EmployeeDAO;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mohit
 */
@Controller
@RequestMapping(value = {"/admin"})
public class AdminController {
    
    @Autowired
    EmployeeDAO employeeDao;
    
    @RequestMapping(method = RequestMethod.GET)
    public String doGet(Model model)
    {
        try{
        model.addAttribute("employee", employeeDao.getAll() );
        }catch(SQLException|ClassNotFoundException ex)
        {
        
        }
        return "admin/admin";
    }
}
