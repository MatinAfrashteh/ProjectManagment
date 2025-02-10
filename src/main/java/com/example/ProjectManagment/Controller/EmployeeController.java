package com.example.ProjectManagment.Controller;

import com.example.ProjectManagment.Entities.EmployeeEntity;
import com.example.ProjectManagment.Repository.EmployeeRepository;
import com.example.ProjectManagment.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    EmployeeService empServices;

    @Autowired
    EmployeeRepository emps;

    @GetMapping("")
    public String display(Model model) {
        List<EmployeeEntity> emploentity = empServices.findAll();
        model.addAttribute("emplo", emploentity);
        return "listEmployee";
    }

    @GetMapping("/new")
    public String EmployeeNew(Model model){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        model.addAttribute("employee" , employeeEntity);
        return "Employee";
    }

    @PostMapping("/save")
    public String EmployeeSave(@Valid EmployeeEntity employeeEntity,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("employee", employeeEntity);
            return "Employee";
        }
        empServices.save(employeeEntity);
        return "redirect:/Employee";
    }

    @GetMapping("/update/id/{id}")
    public String update(@PathVariable("id") long id,  Model model){
        EmployeeEntity employeeEntity = emps.findById(id);
        model.addAttribute("employee", employeeEntity);
        return "Employee";
    }

    @GetMapping("/delete/id/{id}")
    public String delete(@PathVariable("id") int id) {
        EmployeeEntity emp = empServices.findById(id);
        empServices.delete(emp);
        return "redirect:/home";
    }

}
