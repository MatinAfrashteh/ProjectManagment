package com.example.ProjectManagment;

import com.example.ProjectManagment.Entities.ProjectTable;
import com.example.ProjectManagment.Repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

//@ContextConfiguration
@SpringBootTest()
@RunWith(SpringRunner.class)
//@DataJpaTest
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:data.sql"})
        , @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")})
class ProjectManagmentApplicationTests {

    @Autowired
    ProjectRepository proRep;

    @Test
    void contextLoads() {
        ProjectTable projectTable = new ProjectTable("Spring Boot", "COMPLETED", "kosisher");
        proRep.save(projectTable);

        assertEquals(5, proRep.findAll().size());
    }

}
