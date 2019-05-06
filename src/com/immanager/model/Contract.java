package com.immanager.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Contract {
    private GregorianCalendar dateStart;
    private GregorianCalendar dateEnd;
    private Double warranty;
    private Boolean cpasWarranty;
    private Person guarantee1;
    private Person guarantee2;
    private Person renter;
    private Apartment apartment;
    private String refEnregistrement;

    private ArrayList<RentOwed> rentOwedList;
    private ArrayList<Payment> paymentList;

    public Contract(GregorianCalendar dateStart, GregorianCalendar dateEnd, Double warranty, Boolean cpasWarranty, Integer guarantee1, Integer guarantee2, Integer renter, Integer apartment, String refEnregistrement) {
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

    //TODO : Get the Person via DB
    public void setGuarantee1(Integer guarantee1) {

    }

    public Person getGuarantee2() {
        return guarantee2;
    }

    //TODO : Get the Person via DB
    public void setGuarantee2(Integer guarantee2) {

    }

    public Person getRenter() {
        return renter;
    }

    //TODO : Get the Person via DB
    public void setRenter(Integer renter) {

    }

    public Apartment getApartment() {
        return apartment;
    }

    //TODO : Get the Apartment via DB
    public void setApartment(Integer apartment) {

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
