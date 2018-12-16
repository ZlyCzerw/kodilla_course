package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@NamedQueries({

    @NamedQuery( name = "Employee.employeeByNameFragment",
            query = "FROM Employee WHERE lastName LIKE CONCAT('%', :ARG, '%')"),

    @NamedQuery( name = "Employee.employeeWhoseName",
             query = "FROM Employee WHERE lastName LIKE :LASTNAME")
})
@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    List<Company> companies = new ArrayList<>();

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee() {
    }

    @NotNull
    @Id
    @GeneratedValue
    @Column(name = "employee_ID", unique = true)
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }
    @Column(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(
           name = "JOIN_COMPANY_EMPLOYEE",
           joinColumns = {@JoinColumn(name = "EMPLOYEE_ID",referencedColumnName = "EMPLOYEE_ID")},
           inverseJoinColumns = {@JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")}
   )
    public List<Company> getCompanies() {
        return companies;
    }

    private void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
