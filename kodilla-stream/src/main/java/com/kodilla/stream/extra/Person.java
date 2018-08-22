package com.kodilla.stream.extra;

import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private final String name;
    private final String surname;
    private final List<Address> addressList;

    public Person(String name, String surname, List<Address> addressList) {
        this.name = name;
        this.surname = surname;
        this.addressList = addressList;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public List<Address> getAddressList() {
        return addressList;
    }

    public List<Address> peopleLivingInRzeszow() {

        // Person person1 = new Person("Marek", "Kolec",Arrays.asList( new Address("Krakowska",4,"Rzeszów",AddressType.CONTACT)));
        // Person person2 = new Person("Anna", "Kolec",Arrays.asList( new Address("Krakowska",2,"Rzeszów",AddressType.PERNAMENT)));
        // Person person3 = new Person("Leszek", "Kolec",Arrays.asList( new Address("Krakowska",54,"Szczecin",AddressType.CONTACT)));

        List<Address> lista = addressList.stream()
                .filter(address -> address.getCity().equals("Rzeszów"))
                .collect(Collectors.toList());
        return lista;
    }


    public List<AddressType> peopleContactInRzeszow() {


            List<AddressType> lista = addressList.stream()
                    .map(address -> address.getAddressType(AddressType.CONTACT))
                    .collect(Collectors.toList());

        System.out.println(lista);
            return lista;
    }

}