package com.immanager.model;

import java.text.MessageFormat;

public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private String registry;
    private String address;

    public Person (Integer id, String firstName, String lastName, String registry, String address)
    {
        setId(id);
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

    @Override
    public String toString() {
        return MessageFormat.format("{0} {1} {2}", firstName, lastName, registry);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
