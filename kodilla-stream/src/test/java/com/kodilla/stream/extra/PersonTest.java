package com.kodilla.stream.extra;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void getName() {
    }

    @Test
    public void getSurname() {
    }

    @Test
    public void getAddressType() {

     Person person1 = new Person("Marek", "Kolec",Arrays.asList( new Address("Krakowska",4,"Rzeszów",AddressType.CONTACT)));
     Person person2 = new Person("Anna", "Kolec",Arrays.asList( new Address("Krakowska",2,"Rzeszów",AddressType.PERNAMENT)));
     Person person3 = new Person("Leszek", "Kolec",Arrays.asList( new Address("Krakowska",54,"Szczecin",AddressType.CONTACT)));

     //when
        List list1 = person1.peopleLivingInRzeszow();
        List list2 = person2.peopleContactInRzeszow();
        List list3 = person1.peopleContactInRzeszow();
    //then
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
    }

}