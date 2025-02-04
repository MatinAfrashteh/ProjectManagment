package com.example.ProjectManagment.Validation;

import com.example.ProjectManagment.Entities.TestEntity;
import com.example.ProjectManagment.Repository.TestRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {


    @Autowired
    TestRepository empRepo;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        System.out.println("Entered validation method..");


        TestEntity emp = empRepo.findByemail(email);

        if(emp != null)
            return false;
        else
            return true;

    }

}
