package com.example.ProjectManagment.Controller;

import com.example.ProjectManagment.Entities.ProjectTable;

import com.example.ProjectManagment.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app-api/projects")
public class ApiControllerProject {

    @Autowired
    ProjectRepository proRepo;

    @GetMapping
    public List<ProjectTable> getProjects(){
        return proRepo.findAll();
    }

    @GetMapping("/{id}")
    public ProjectTable getProjectById(@PathVariable("id") Long id) {
        return proRepo.findById(id);
    }

    @PostMapping(consumes = "application/json",value = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectTable create(@RequestBody ProjectTable project) {
        return proRepo.save(project);
    }

    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ProjectTable update(@RequestBody ProjectTable project) {
        return proRepo.save(project);
    }

    @PatchMapping(path = "/{id}" , consumes = "application/jason")
    public ProjectTable patch(@PathVariable("id") long id , @RequestParam ProjectTable projectTable){
        ProjectTable project=proRepo.findById(id);

        if (projectTable.getName()!= null){
            project.setName(projectTable.getName());
        }
        if (projectTable.getStage()!= null){
            project.setStage(projectTable.getStage());
        }if (projectTable.getDescription()!= null){
            project.setName(projectTable.getDescription());
        }

        return proRepo.save(project);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        try {
            proRepo.deleteById(Math.toIntExact(id));
        }
        catch(EmptyResultDataAccessException e) {

        }
    }
    @GetMapping(params = {"page","size","sort","direction"})
    @ResponseStatus(HttpStatus.OK)
    private Page<ProjectTable> get(@RequestParam("page")int page,
                                   @RequestParam("size")int size,
                                   @RequestParam("sort")String sortby,
                                   @RequestParam("direction")String  direction){

        Sort sort = direction.equalsIgnoreCase("asc")?
                Sort.by(sortby).ascending():
                Sort.by(sortby).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return proRepo.findAll(pageable);
    }
}