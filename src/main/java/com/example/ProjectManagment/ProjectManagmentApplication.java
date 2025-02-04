package com.example.ProjectManagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectManagmentApplication{

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagmentApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(){
//		return kirkhar ->{
//			EmployeeEntity emp1 = new EmployeeEntity("ali","koskashian","alikoskashian@gmail.com");
//
//			ProjectTable pro1 = new ProjectTable("instagram","COMPLETED","kosisher");
//
//			pro1.addEmployee(emp1);
//
//			emp1.setThe_project(Arrays.asList(pro1));
//
//			crudRepository.save(emp1);
//			crudRepositoryProject.save(pro1);
//		};
//
//	}

}
