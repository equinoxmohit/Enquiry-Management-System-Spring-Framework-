/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.emswithspringframework.controller;

import com.mohit.emswithspringframework.DAO.EmployeeDAO;
import com.mohit.emswithspringframework.entity.Employee;
import java.sql.SQLException;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Mohit
 */
@Controller
@RequestMapping(value = "/edit")
public class EditController {

    @Autowired
    EmployeeDAO employeeDao;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String doGet(Model model, @PathVariable("id") int id) {
        try {
            Employee em = employeeDao.getById(id);
            if (em == null) {
                return "redirect:/admin?error";
            }
            model.addAttribute("employee", em);
        } catch (SQLException | ClassNotFoundException ex) {

        }

        return "admin/edit";
    }

    @RequestMapping(value = "/{id}/save", method = RequestMethod.POST)
    public String doPost(Employee em) {

        try {
            if (employeeDao.update(em) > 0) {

                return "redirect:/admin?success";
            }
        } catch (SQLException | ClassNotFoundException ex) {

        }

        return "redirect:/admin?error";
    }
}
