package com.kodilla.stream.extra;

public class Address {
    private final String street;
    private final int buildingNr;
    private final String city;
    private final AddressType addressType;

    public Address(String street, int buildingNr, String city, AddressType addressType) {
        this.street = street;
        this.buildingNr = buildingNr;
        this.city = city;
        this.addressType = addressType;
    }

    public String getStreet() {
        return street;
    }

    public int getBuildingNr() {
        return buildingNr;
    }

    public String getCity() {
        return city;
    }

    public  AddressType getAddressType(AddressType addressType) {
        return addressType;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", buildingNr=" + buildingNr +
                ", city='" + city + '\'' +
                ", addressType=" + addressType +
                '}';
    }
}
