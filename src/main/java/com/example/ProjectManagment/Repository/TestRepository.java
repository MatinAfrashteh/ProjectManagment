package com.example.ProjectManagment.Repository;

import com.example.ProjectManagment.Entities.TestEntity;
import com.example.ProjectManagment.Entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TestRepository extends JpaRepository<TestEntity,Integer> {
    TestEntity findByemail(String email);
}
