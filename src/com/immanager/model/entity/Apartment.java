package com.immanager.model.entity;

public class Apartment {
    private String name;
    private String city;
    private String address;
    private String postalCode;


    public Apartment(String name, String city, String address, String postalCode)
    {
        setName(name);
        setCity(city);
        setAddress(address);
        setPostalCode(postalCode);
    }

    private void setPostalCode(String postal_code)
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

    public String getPostalCode() {
        return postalCode;
    }
}
