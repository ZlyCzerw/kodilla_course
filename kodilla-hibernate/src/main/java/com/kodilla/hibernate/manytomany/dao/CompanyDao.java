package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query(nativeQuery = true)
    List<Company>companyNameStartsWith (@Param("BEGINSWITH") String companyName);
    @Query(nativeQuery = true)
    List<Company>companyByNameFragment (@Param("ARG") String companyName);

}
