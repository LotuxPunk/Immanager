package com.immanager.model;

import java.util.GregorianCalendar;

public class ShowableRent {
    private RentOwed rent;
    private GregorianCalendar date;

    public ShowableRent(RentOwed rent, GregorianCalendar date) {
        setRent(rent);
        setDate(date);
    }

    public RentOwed getRent() {
        return rent;
    }

    public void setRent(RentOwed rent) {
        this.rent = rent;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
}
