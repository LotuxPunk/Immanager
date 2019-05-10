package com.immanager.model;

import java.text.MessageFormat;

public class Apartment {
    private String name;
    private String city;
    private String address;
    private Integer postalCode;

    public Apartment(String name, String city, String address, Integer postalCode) {
        setName(name);
        setCity(city);
        setAddress(address);
        setPostalCode(postalCode);
    }

    private void setPostalCode(Integer postal_code)
    {
        this.postalCode = postal_code;
    }

    private void setAddress(String address)
    {
        this.address = address;
    }

    private void setCity(String city)
    {
        this.city = city;
    }

    private void setName(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} {1} {2} {3}", name, address, city, postalCode);
    }
}
