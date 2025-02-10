package com.example.ProjectManagment.Controller;

import com.example.ProjectManagment.Entities.EmployeeEntity;
import com.example.ProjectManagment.Entities.ProjectTable;
import com.example.ProjectManagment.Repository.CharData;
import com.example.ProjectManagment.Repository.EmployeeRepository;
import com.example.ProjectManagment.Repository.ProjectRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class HomeController {


    @Autowired
    EmployeeRepository crudRepository;
    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/home")
    public String get(Model model) throws JsonProcessingException {

        List<EmployeeEntity> emploEntitycount = (List<EmployeeEntity>) crudRepository.findAll();
        model.addAttribute("emplocount", emploEntitycount);

        List<CharData> chartdata = projectRepository.getproject();

        ObjectMapper objectMapper = new ObjectMapper();
        String jasons = objectMapper.writeValueAsString(chartdata);
        model.addAttribute("JaSonDAtaChart",jasons);


        List<ProjectTable> proj= projectRepository.findAll();
        model.addAttribute("pro",proj);
        return "home";
    }
}
