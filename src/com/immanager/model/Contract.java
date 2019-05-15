package com.immanager.model;

import com.immanager.exception.SetWarrantyException;

import java.util.GregorianCalendar;

public class Contract {
    private Integer id;
    private GregorianCalendar dateStart;
    private GregorianCalendar dateEnd;
    private Double warranty;
    private Boolean cpasWarranty;
    private String refEnregistrement;
    private Integer apartmentID;
    private Integer renterID;
    private Integer guarantee1;
    private Integer guarantee2;

    public Contract(Integer id, GregorianCalendar dateStart, GregorianCalendar dateEnd, Double warranty, Boolean cpasWarranty, String refEnregistrement, Integer apartmentID, Integer renterID, Integer guarantee1, Integer guarantee2) throws SetWarrantyException {
        setId(id);
        setDateStart(dateStart);
        setDateEnd(dateEnd);
        setWarranty(warranty);
        setCpasWarranty(cpasWarranty);
        setRefEnregistrement(refEnregistrement);
        setApartmentID(apartmentID);
        setRenterID(renterID);
        setGuarantee1(guarantee1);
        setGuarantee2(guarantee2);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getWarranty() {
        return warranty;
    }

    public void setWarranty(Double warranty) throws SetWarrantyException {
        if(warranty < 0)
            throw new SetWarrantyException("La guarantie ne peut pas être négative");
        this.warranty = warranty;
    }

    public Boolean getCpasWarranty() {
        return cpasWarranty;
    }

    public void setCpasWarranty(Boolean cpasWarranty) {
        this.cpasWarranty = cpasWarranty;
    }

    public String getRefEnregistrement() {
        return refEnregistrement;
    }

    public void setRefEnregistrement(String refEnregistrement) {
        this.refEnregistrement = refEnregistrement;
    }

    public Integer getApartmentID() {
        return apartmentID;
    }

    public void setApartmentID(Integer apartmentID) {
        this.apartmentID = apartmentID;
    }
    public Integer getRenterID() {
        return renterID;
    }

    public void setRenterID(Integer renterID) {
        this.renterID = renterID;
    }

    public Integer getGuarantee1() {
        return guarantee1;
    }

    public void setGuarantee1(Integer guarantee1) {
        this.guarantee1 = guarantee1;
    }

    public Integer getGuarantee2() {
        return guarantee2;
    }

    public void setGuarantee2(Integer guarantee2) {
        this.guarantee2 = guarantee2;
    }
}
