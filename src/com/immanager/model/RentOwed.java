package com.immanager.model;

import com.immanager.exception.SetAmountException;

import java.util.GregorianCalendar;

public class RentOwed {
    private GregorianCalendar date;
    private Amount amount;

    public RentOwed(Double rent, Double charge, GregorianCalendar date) throws SetAmountException {
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

    public void setAmount(Double rent, Double charge) throws SetAmountException {
        this.amount = new Amount(rent, charge);
    }

    public class Amount{
        private Double rent;
        private Double charge;

        public Amount(Double rent, Double charge) throws SetAmountException {
            setRent(rent);
            setCharge(charge);
        }

        public Double getRent() {
            return rent;
        }

        public void setRent(Double rent) throws SetAmountException {
            if (rent < 0)
                throw new SetAmountException("Le montant du loyer ne peut pas être négatif");
            this.rent = rent;
        }

        public Double getCharge() {
            return charge;
        }

        public void setCharge(Double charge) throws SetAmountException {
            if (charge < 0)
                throw new SetAmountException("Le montant des charges ne peut pas être négatif");
            this.charge = charge;
        }

        public Double getTotal(){
            return  this.charge + this.rent;
        }
    }
}
