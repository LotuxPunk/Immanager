package com.immanager.model;

public class Apartment {
    private String name;
    private String city;
    private String address;
    private Integer postalCode;

    //TODO : Maybe use the Flyweight Pattern here with a HashMap<K, V> with name as key
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
}
