package com.example.ProjectManagment.Controller;

import com.example.ProjectManagment.Entities.EmployeeEntity;
import com.example.ProjectManagment.Repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app-api/employees")
public class ApiControllersEmployee {


    @Autowired
    private EmployeeRepository empRepo;

    @GetMapping
    public ResponseEntity<Iterable<EmployeeEntity>> getEmployees() {
        return ResponseEntity.ok(empRepo.findAll());
    }

    @GetMapping("/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable("id") long id) {
        return empRepo.findById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmployeeEntity> create(@RequestBody @Valid EmployeeEntity employee) {
        EmployeeEntity savedEmployee = (EmployeeEntity) empRepo.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeEntity update(@RequestBody @Valid EmployeeEntity employee) {
        return (EmployeeEntity) empRepo.save(employee);
    }

    @PatchMapping(path="/{id}", consumes= "application/json")
    public EmployeeEntity partialUpdate(@PathVariable("id") long id, @RequestBody @Valid EmployeeEntity patchEmployee) {
        EmployeeEntity emp = empRepo.findById(id);

        if(patchEmployee.getEmail() != null) {
            emp.setEmail(patchEmployee.getEmail());
        }
        if(patchEmployee.getFname() != null) {
            emp.setFname(patchEmployee.getFname());
        }
        if(patchEmployee.getLname() != null) {
            emp.setLname(patchEmployee.getLname());
        }

        return (EmployeeEntity) empRepo.save(emp);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if (!empRepo.existsById(Math.toIntExact(id))) {
            return ResponseEntity.notFound().build();
        }
        empRepo.deleteById(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping(params= {"page", "size"})
    @ResponseStatus(HttpStatus.OK)
    public Iterable<EmployeeEntity> findPaginatedEmployees(@RequestParam("page") int page,
                                                     @RequestParam("size") int size){
        Pageable pageAndSize = PageRequest.of(page, size);

        return empRepo.findAll(pageAndSize);
    }
}
