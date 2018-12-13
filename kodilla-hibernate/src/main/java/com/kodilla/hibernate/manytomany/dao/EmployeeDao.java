package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query
    List<Employee> employeeWhoseName(@Param("LASTNAME") String lastName);
    @Query
    List<Employee> employeeByNameFragment(@Param("ARG")String lastName);
}
