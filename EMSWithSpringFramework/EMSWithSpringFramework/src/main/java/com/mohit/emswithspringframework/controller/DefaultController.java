/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.emswithspringframework.controller;

import com.mohit.emswithspringframework.DAO.EmployeeDAO;
import com.mohit.emswithspringframework.entity.Employee;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mohit
 */
@Controller
@RequestMapping(value = {"/","/register"})
public class DefaultController {
    
    @Autowired
    EmployeeDAO employeeDao; 
    
    @RequestMapping(method = RequestMethod.GET)
    public String doGet()
    {
        return "register/register";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String doPost(Employee em)
    {
        try{
        if(employeeDao.insert(em)>0)
        {
            return "redirect:/admin?success";
        }
        }catch(SQLException|ClassNotFoundException ex)
        {
        
        }
        return "redirect:/?error";
    }
}
