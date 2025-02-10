package com.example.ProjectManagment.services;

import java.util.List;
import java.util.Optional;

import com.example.ProjectManagment.Entities.ProjectTable;
import com.example.ProjectManagment.Repository.CharData;
import com.example.ProjectManagment.Repository.ProjectRepository;
import com.example.ProjectManagment.Repository.TimeListChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository proRepo;


    public ProjectTable save(ProjectTable project) {
        return proRepo.save(project);
    }


    public List<ProjectTable> findAll() {
        return proRepo.findAll();
    }

    public Optional<ProjectTable> findById(int id) {
        return Optional.ofNullable(proRepo.findById(id));
    }

    public void Delete(ProjectTable projectTable) {
        proRepo.delete(projectTable);
    }

    }

