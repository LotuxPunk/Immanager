package com.immanager.model.entity;

public class Person {
    private String firstName;
    private String lastName;
    private String registry;
    private String address;

    public Person (String firstName, String lastName, String registry, String address)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setRegistry(registry);
        setAddress(address);
    }


    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getAddress()
    {
        return address;
    }

    public String getRegistry()
    {
        return registry;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setRegistry(String registry)
    {
        this.registry = registry;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
}
