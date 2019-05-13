package com.immanager.model;

import java.util.ArrayList;

public class ContractResult {
    private Contract contract;
    private Apartment apartment;
    private Person renter;
    private ArrayList<Person> guarantees;
    private ArrayList<Payment> payments;
    private ArrayList<RentOwed> rentOweds;

    public ContractResult(Contract contract, Apartment apartment, Person renter, ArrayList<Person> guarantees, ArrayList<Payment> payments, ArrayList<RentOwed> rentOweds) {
        setContract(contract);
        setApartment(apartment);
        setRenter(renter);
        setGuarantees(guarantees);
        setPayments(payments);
        setRentOweds(rentOweds);
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Person getRenter() {
        return renter;
    }

    public void setRenter(Person renter) {
        this.renter = renter;
    }

    public ArrayList<Person> getGuarantees() {
        return guarantees;
    }

    public void setGuarantees(ArrayList<Person> guarantees) {
        this.guarantees = guarantees;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    public ArrayList<RentOwed> getRentOweds() {
        return rentOweds;
    }

    public void setRentOweds(ArrayList<RentOwed> rentOweds) {
        this.rentOweds = rentOweds;
    }
}
