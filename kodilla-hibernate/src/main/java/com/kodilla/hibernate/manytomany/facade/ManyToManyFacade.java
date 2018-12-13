package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManyToManyFacade {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(ManyToManyFacade.class);

    public List <Company> findCompanyByNameFragment(String companyNameFragment){
        try {
            LOGGER.info("Search for companies with " + companyNameFragment + " in name." );
            return companyDao.companyByNameFragment(companyNameFragment);
        }catch (Exception e){
            LOGGER.error("usp, jakiś error" + e);
            return new ArrayList<>();
        }

    }
    public List <Employee> findEmployeesByNameFragment(String employeeNameFragment){
        try {
            LOGGER.info("Search for companies with " + employeeNameFragment + " in name." );
            return employeeDao.employeeByNameFragment(employeeNameFragment);
        }catch (Exception e){
            LOGGER.error("usp, jakiś error" + e);
            return new ArrayList<>();
        }

    }


}
