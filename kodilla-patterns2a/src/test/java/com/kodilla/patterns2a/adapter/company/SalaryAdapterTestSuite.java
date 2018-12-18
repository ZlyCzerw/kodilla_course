package com.kodilla.patterns2a.adapter.company;

import com.kodilla.patterns2a.adapter.company.oldhrsystem.Workers;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalaryAdapterTestSuite {
    @Test
    public void testTotalSalary(){
        //Given
        Workers workers = new Workers();
        SalaryAdapter salaryAdapter = new SalaryAdapter();
        //When
        double totalSalary = salaryAdapter.totalSalary(workers.getWorkers(),workers.getSalaries());
        //then
        System.out.println(totalSalary);
        assertEquals(totalSalary,27750,0);
    }

}