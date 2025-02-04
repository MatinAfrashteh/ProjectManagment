package com.example.ProjectManagment.Repository;

import com.example.ProjectManagment.Entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {
}
