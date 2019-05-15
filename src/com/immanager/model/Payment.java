package com.immanager.model;

import com.immanager.exception.SetAmountException;

import java.util.GregorianCalendar;

public class Payment {
    private Double amount;
    private GregorianCalendar date;

    public Payment (Double amount, GregorianCalendar date) throws SetAmountException {
        setAmount(amount);
        setDate(date);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) throws SetAmountException {
        if (amount < 0)
            throw new SetAmountException("Le montant du payment ne peut pas être inférieur à 0");
        this.amount = amount;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
}
