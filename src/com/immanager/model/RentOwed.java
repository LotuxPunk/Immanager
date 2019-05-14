package com.immanager.model;

import java.util.GregorianCalendar;

public class RentOwed {
    private GregorianCalendar date;
    private Amount amount;

    public RentOwed(Double rent, Double charge, GregorianCalendar date) {
        setAmount(rent,charge);
        setDate(date);
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Double rent, Double charge) {
        this.amount = new Amount(rent, charge);
    }

    public class Amount{
        private Double rent;
        private Double charge;

        public Amount(Double rent, Double charge) {
            setRent(rent);
            setCharge(charge);
        }

        public Double getRent() {
            return rent;
        }

        public void setRent(Double rent) {
            this.rent = rent;
        }

        public Double getCharge() {
            return charge;
        }

        public void setCharge(Double charge) {
            this.charge = charge;
        }

        public Double getTotal(){
            return  this.charge + this.rent;
        }
    }
}
