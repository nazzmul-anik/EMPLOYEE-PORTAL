package com.example.employee.portal.service;


import com.example.employee.portal.domain.EmployeeDomain;
import com.example.employee.portal.entity.EmployeeEntity;
import com.example.employee.portal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;
    public EmployeeDomain createEmployee(EmployeeDomain domain){
        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(domain.getName());
        entity.setDesignation(domain.getDesignation());
        entity.setPhoneNumber(domain.getPhoneNumber());
        entity.setEmail(domain.getEmail());
        repository.save(entity);

        EmployeeDomain details = new EmployeeDomain();
        details.setName(entity.getName());
        details.setDesignation(entity.getDesignation());
        details.setPhoneNumber(entity.getPhoneNumber());
        details.setEmail(entity.getEmail());

        return details;
    }
    public EmployeeDomain getEmployee(Long id){
        Optional<EmployeeEntity> emp = repository.findById(id);
        if(emp.isEmpty()){
            throw new RuntimeException("Employee Not Found.");
        }

        EmployeeDomain domain = new EmployeeDomain();
        domain.setName(emp.get().getName());
        domain.setDesignation(emp.get().getDesignation());
        domain.setPhoneNumber(emp.get().getPhoneNumber());
        domain.setEmail(emp.get().getEmail());

        return domain;
    }

    public List<EmployeeDomain> getAllEmployee(){
        Optional<List<EmployeeEntity>> all = Optional.of(repository.findAll());
        List<EmployeeDomain> allEmployee = new ArrayList<EmployeeDomain>();
        for(EmployeeEntity employee : all.get()){
           EmployeeDomain domain = new EmployeeDomain();
           domain.setName(employee.getName());
           domain.setDesignation(employee.getDesignation());
           domain.setPhoneNumber(employee.getPhoneNumber());
           domain.setEmail(employee.getEmail());
           allEmployee.add(domain);
        }

        return allEmployee;
    }
    public EmployeeDomain updateEmployee(Long id, EmployeeDomain domain){
        Optional<EmployeeEntity> employee = repository.findById(id);
        if(employee.isEmpty()){
            throw new RuntimeException("Couldn't found your : "+id);
        }
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(id);
        entity.setName(domain.getName());
        entity.setDesignation(domain.getDesignation());
        entity.setPhoneNumber(domain.getPhoneNumber());
        entity.setEmail(domain.getEmail());
        repository.save(entity);

        return domain;
    }
    public String deleteEmployee(Long id){
        Optional<EmployeeEntity> entity = repository.findById(id);
        if(entity.isEmpty()){
            return "You enter wrong id. Please Enter Correct id for deletion.";
        }

        repository.deleteById(id);
        return "Successfully Deleted.";
    }
}
