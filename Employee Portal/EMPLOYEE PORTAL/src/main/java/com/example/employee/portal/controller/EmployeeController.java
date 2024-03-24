package com.example.employee.portal.controller;

import com.example.employee.portal.domain.EmployeeDomain;
import com.example.employee.portal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;


    @GetMapping("/message")
    public String getMessage(){
        return "Welcome to my Employee Portal";
    }

    // Create API
    @PostMapping("/create")
    public EmployeeDomain createEmployee(@RequestBody EmployeeDomain domain){
        return service.createEmployee(domain);
    }

    // Read API
    @GetMapping("/get/{id}")
    public EmployeeDomain getEmployee(@PathVariable Long id){
        return service.getEmployee(id);
    }

    // Read All Employee API
    @GetMapping("/get/all")
    public List<EmployeeDomain> getAllEmployee(){
        return service.getAllEmployee();
    }

    // Update API
    @PutMapping("/update/{id}")
    public EmployeeDomain updateEmployee(@PathVariable Long id, @RequestBody EmployeeDomain domain){
        return service.updateEmployee(id, domain);
    }

    // Delete API
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return service.deleteEmployee(id);
    }
}
