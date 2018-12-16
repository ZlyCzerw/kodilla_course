package com.kodilla.hibernate.manytomany;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Company.companyNameStartsWith",
                query = "SELECT * FROM COMPANIES WHERE LEFT (COMPANY_NAME, 3) LIKE :BEGINSWITH",
                resultClass = Company.class
        ),
        @NamedNativeQuery(
                name = "Company.companyByNameFragment",
                query = "SELECT * FROM COMPANIES WHERE COMPANY_NAME LIKE CONCAT('%', :ARG, '%')",
                resultClass = Company.class
        )
})

@Entity
@Table(name = "COMPANIES")
public class Company {
    private int id;
    private String companyName;
    List<Employee> employees = new ArrayList<>();


    public Company(String companyName) {
        this.companyName = companyName;
    }

    public Company() {
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "COMPANY_NAME")
    public String getCompanyName() {
        return companyName;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "companies"
    )

    public List<Employee> getEmployees() {
        return employees;
    }

    private void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
