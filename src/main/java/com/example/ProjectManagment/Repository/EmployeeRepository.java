package com.example.ProjectManagment.Repository;

import com.example.ProjectManagment.Entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository<U, L extends Number> extends JpaRepository<EmployeeEntity,Integer> {
    @Override
    List<EmployeeEntity> findAll();

    @Query(nativeQuery = true,value = "select fname,lname,count(pe.employee_id) " +
            "from employee e left join project3.employee_project pe on pe.employee_id=e.id " +
            "group by e.fname,e.lname order by 3 desc")
    List<ProjectEmployees> projectEmp();

    EmployeeEntity findByemail(String value);

    public EmployeeEntity findById(Long id);


}
