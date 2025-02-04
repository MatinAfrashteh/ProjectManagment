package com.example.ProjectManagment.Controller;
import com.example.ProjectManagment.Entities.EmployeeEntity;
import com.example.ProjectManagment.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {


    @Autowired
    private EmployeeRepository<EmployeeEntity, Integer> empRepo;

    @GetMapping
    public ResponseEntity<Iterable<EmployeeEntity>> getEmployees() {
        return ResponseEntity.ok(empRepo.findAll());
    }

    // Get employee by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id) {
//        return empRepo.findById(Math.toIntExact(id))
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmployeeEntity> create(@RequestBody @Valid EmployeeEntity employee) {
        EmployeeEntity savedEmployee = empRepo.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeEntity update(@RequestBody @Valid  EmployeeEntity employee) {
        return empRepo.save(employee);
    }

//    @PatchMapping(path = "/{id}", consumes = "application/json")
//    public ResponseEntity<EmployeeEntity> partialUpdate(@PathVariable("id") Long id, @RequestBody @Valid EmployeeEntity patchEmployee) {
//        return empRepo.findById(Math.toIntExact(id))
//                .map(existingEmployee -> {
//                    if (patchEmployee.getEmail() != null) {
//                        existingEmployee.setEmail(patchEmployee.getEmail());
//                    }
//                    if (patchEmployee.getFname() != null) {
//                        existingEmployee.setFname(patchEmployee.getFname());
//                    }
//                    if (patchEmployee.getLname() != null) {
//                        existingEmployee.setLname(patchEmployee.getLname());
//                    }
//                    EmployeeEntity updatedEmployee = empRepo.save(existingEmployee);
//                    return ResponseEntity.ok(updatedEmployee);
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if (!empRepo.existsById(Math.toIntExact(id))) {
            return ResponseEntity.notFound().build();
        }
        empRepo.deleteById(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }
}


//    @GetMapping(params= {"page", "size"})
//    @ResponseStatus(HttpStatus.OK)
//    public Iterable<EmployeeEntity> findPaginatedEmployees(@RequestParam("page") int page,
//                                                     @RequestParam("size") int size){
//        Pageable pageAndSize = PageRequest.of(page, size);
//
//        return empRepo.findAll(pageAndSize);
//    }


