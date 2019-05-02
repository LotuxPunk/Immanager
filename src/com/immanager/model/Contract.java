package com.immanager.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Contract {
    private GregorianCalendar dateStart;
    private GregorianCalendar dateEnd;
    private double warranty;
    private boolean cpasWarranty;
    private Person guarantee1;
    private Person guarantee2;
    private Person renter;
    private Apartment apartment;
    private String refEnregistrement;

    private ArrayList<RentOwed> rentOwedList;
    private ArrayList<Payment> paymentList;

    public Contract(GregorianCalendar dateStart, GregorianCalendar dateEnd, double warranty, boolean cpasWarranty, Person guarantee1, Person guarantee2, Person renter, Apartment apartment, String refEnregistrement) {
        setDateStart(dateStart);
        setDateEnd(dateEnd);
        setWarranty(warranty);
        setCpasWarranty(cpasWarranty);
        setGuarantee1(guarantee1);
        setGuarantee2(guarantee2);
        setRenter(renter);
        setApartment(apartment);
        setRefEnregistrement(refEnregistrement);
        rentOwedList= new ArrayList<>();
        paymentList= new ArrayList<>();
    }

    public GregorianCalendar getDateStart() {
        return dateStart;
    }

    public void setDateStart(GregorianCalendar dateStart) {
        this.dateStart = dateStart;
    }

    public GregorianCalendar getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(GregorianCalendar dateEnd) {
        this.dateEnd = dateEnd;
    }

    public double getWarranty() {
        return warranty;
    }

    public void setWarranty(double warranty) {
        this.warranty = warranty;
    }

    public boolean isCpasWarranty() {
        return cpasWarranty;
    }

    public void setCpasWarranty(boolean cpasWarranty) {
        this.cpasWarranty = cpasWarranty;
    }

    public Person getGuarantee1() {
        return guarantee1;
    }

    public void setGuarantee1(Person guarantee1) {
        this.guarantee1 = guarantee1;
    }

    public Person getGuarantee2() {
        return guarantee2;
    }

    public void setGuarantee2(Person guarantee2) {
        this.guarantee2 = guarantee2;
    }

    public Person getRenter() {
        return renter;
    }

    public void setRenter(Person renter) {
        this.renter = renter;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public String getRefEnregistrement() {
        return refEnregistrement;
    }

    public void setRefEnregistrement(String refEnregistrement) {
        this.refEnregistrement = refEnregistrement;
    }

    public ArrayList<RentOwed> getRentOwedList() {
        return rentOwedList;
    }

    public void setRentOwedList(ArrayList<RentOwed> rentOwedList) {
        this.rentOwedList = rentOwedList;
    }

    public ArrayList<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(ArrayList<Payment> paymentList) {
        this.paymentList = paymentList;
    }
}
