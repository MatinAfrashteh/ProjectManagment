package com.example.ProjectManagment.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "project")
public class ProjectTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    @SequenceGenerator(name = "project_seq", sequenceName = "project_seq", allocationSize = 1)
    private int projectid;

    @NotBlank
    @Size(min = 5 ,max = 50, message = "Last name must be at most 50 characters")
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "stage")
    private String stage;

    @NotBlank
    @Size(min = 5 ,max = 50, message = "Last name must be at most 50 characters")
    @Column(name = "description")
    private String description;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate( Date endDate) {
        this.endDate = endDate;
    }

    public  Date getStartDate() {
        return StartDate;
    }

    public void setStartDate( Date startDate) {
        StartDate = startDate;
    }

    @NotNull(message = "Start date must not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date StartDate;

    @NotNull(message = "Start date must not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

//    @OneToMany(mappedBy = "projectList")
//    List<EmployeeEntity>employeeEntities;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "employee_project",
            joinColumns = @JoinColumn(name = "project_id")
            , inverseJoinColumns = @JoinColumn(name = "employee_id"))

    @JsonIgnoreProperties
    private List<EmployeeEntity> employeeEntityList;

    public int getProjectid() {
        return projectid;
    }

    public List<EmployeeEntity> getEmployeeEntityList() {
        return employeeEntityList;
    }

    public void setEmployeeEntityList(List<EmployeeEntity> employeeEntityList) {
        this.employeeEntityList = employeeEntityList;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public ProjectTable() {
    }

    public ProjectTable(String name, String stage, String description) {
        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public void addEmployee(EmployeeEntity emp){
//        if(employeeEntityList==null){
//            employeeEntityList=new ArrayList<>();
//        }
//        employeeEntityList.add(emp);
//    }


}
