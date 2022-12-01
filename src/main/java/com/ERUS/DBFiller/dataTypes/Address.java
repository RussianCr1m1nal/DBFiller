package com.ERUS.DBFiller.dataTypes;

public class Address {
    String city;
    String street;

    public Address(String city, String street)
    {
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }
}
