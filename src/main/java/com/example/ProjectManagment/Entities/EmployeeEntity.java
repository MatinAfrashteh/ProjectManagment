package com.example.ProjectManagment.Entities;

import com.example.ProjectManagment.Validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
    private int id;

    @NotBlank
    @Size(min = 5 ,max = 50, message = "Last name must be at most 50 characters")
    @Column(name = "fname")
    private String Fname;

    @NotBlank
    @Size(min = 5 ,max = 50, message = "Last name must be at most 50 characters")
    @Column(name = "lname")
    private String Lname;

    @NotBlank
    @UniqueValue
    @Email(message="*Must be a valid email address")
    @Column(name = "email")
    private String email;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id")
            , inverseJoinColumns = @JoinColumn(name = "project_id"))

//    @ManyToOne
//    @JoinColumn(name = "project_id")
//    private ProjectTable projectList;

    @JsonIgnoreProperties
    private List<ProjectTable> the_project;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String fname, String lname, String email, List<ProjectTable> the_project) {
        Fname = fname;
        Lname = lname;
        this.email = email;
        this.the_project = the_project;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ProjectTable> getThe_project() {
        return the_project;
    }

    public void setThe_project(List<ProjectTable> the_project) {
        this.the_project = the_project;
    }


}
