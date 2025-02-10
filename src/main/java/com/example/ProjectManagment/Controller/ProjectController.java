package com.example.ProjectManagment.Controller;

import com.example.ProjectManagment.Entities.EmployeeEntity;
import com.example.ProjectManagment.Entities.ProjectTable;
import com.example.ProjectManagment.Repository.ProjectRepository;

import com.example.ProjectManagment.Repository.TimeListChart;
import com.example.ProjectManagment.services.EmployeeService;

import com.example.ProjectManagment.services.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository proj;
    @Autowired
    ProjectService proServices;

    @Autowired
    EmployeeService empServices;

    @GetMapping("")
    public String display(Model model) {
        List<ProjectTable> project=proServices.findAll();
        model.addAttribute("pro", project);
        return "listProject";
    }

    @GetMapping("/new")
    public String newprojects(Model model) {
        ProjectTable projectTable = new ProjectTable();
        List<EmployeeEntity>employess = empServices.findAll();
        model.addAttribute("allemployees" , employess);
        model.addAttribute("project", projectTable);
        return "NewProject";
    }

    @PostMapping("/save")
    public String saves(@Valid ProjectTable projectTable,
                        BindingResult bindingResult,
                        Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("project", projectTable);
            return "NewProject";
        }
        proServices.save(projectTable);
        return "redirect:/projects";
    }

    @GetMapping("/timelines")
    public String TimeLineList(Model model) throws JsonProcessingException {
        List<TimeListChart> timechar= proj.timelinechart();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonTimelineString = objectMapper.writeValueAsString(timechar);

        System.out.println("---------- project timelines ----------");
        System.out.println(jsonTimelineString);

        model.addAttribute("projectTimeList", jsonTimelineString);

        return "project-timelines";
    }

    @GetMapping("/update/id/{id}")
    public String Update(@PathVariable("id") int id ,Model model){
        ProjectTable projectTable =proj.findById(id);
        model.addAttribute("project",projectTable);
        return "NewProject";
    }

    @GetMapping("/delete/id/{id}")
    public String Delete(@PathVariable("id")int id){
        Optional<ProjectTable> projectTable = proServices.findById(id);
        proServices.Delete(projectTable.orElse(null));
        return "redirect:/home";
    }

}

