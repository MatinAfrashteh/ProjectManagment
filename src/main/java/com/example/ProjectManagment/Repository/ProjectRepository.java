package com.example.ProjectManagment.Repository;

import com.example.ProjectManagment.Entities.ProjectTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<ProjectTable,Integer> {
    @Override
    List<ProjectTable> findAll();

    @Query(nativeQuery = true,value = "SELECT stage as Label,count(*) as Value " +
                     "FROM project " +
                     "group by stage;")
    List<CharData> getproject();

    @Query(nativeQuery=true, value="SELECT name as name, start_date as StartDate, end_date as endDate"
            + " FROM project WHERE start_date is not null")
    List<TimeListChart> timelinechart();

    void delete(ProjectTable projectTable);
}
