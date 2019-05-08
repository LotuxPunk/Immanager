package com.immanager.model;

import com.immanager.dataAccess.ApartmentDbAccess;
import com.immanager.dataAccess.PersonDbAccess;
import com.immanager.exception.ApartmentByIdException;
import com.immanager.exception.PersonByIDException;

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

    public Contract(GregorianCalendar dateStart, GregorianCalendar dateEnd, Double warranty, Boolean cpasWarranty, Integer guarantee1, Integer guarantee2, Person renter, Integer apartment, String refEnregistrement) throws PersonByIDException, ApartmentByIdException {
        setDateStart(dateStart);
        setDateEnd(dateEnd);
        setWarranty(warranty);
        setCpasWarranty(cpasWarranty);
        this.guarantee1 = accessPersonFromDB(guarantee1);
        this.guarantee2 = accessPersonFromDB(guarantee2);
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

    public Person getGuarantee2() {
        return guarantee2;
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

    public void setApartment(Integer apartment) throws ApartmentByIdException {
        this.apartment = new ApartmentDbAccess().getApartmentById(apartment);
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

    private Person accessPersonFromDB(Integer id) throws PersonByIDException{
        if (id != null)
            return new PersonDbAccess().getPersonById(id);
        return null;
    }

    public Object[] toArray(){
        return new Object[]{getApartment(), getDateStart(), getDateEnd(), getRenter(), getGuarantee1(), getGuarantee2(), getRefEnregistrement(), getWarranty()};
    }
}
