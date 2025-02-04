package com.example.ProjectManagment.services;

import java.util.List;

import com.example.ProjectManagment.Entities.EmployeeEntity;
import com.example.ProjectManagment.Repository.EmployeeRepository;
import com.example.ProjectManagment.Repository.ProjectEmployees;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepo;


    public EmployeeEntity save(EmployeeEntity employee) {
        return (EmployeeEntity) empRepo.save(employee);
    }


    public List<EmployeeEntity> findAll() {
        return empRepo.findAll();
    }


    public List<ProjectEmployees> employeeProjects() {
        return empRepo.projectEmp();
    }


    public void delete(EmployeeEntity theEmp) {
        empRepo.delete(theEmp);

    }
    public EmployeeEntity findById(int id){
        return empRepo.findById(id);
    }



}