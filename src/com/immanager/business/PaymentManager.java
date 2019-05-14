package com.immanager.business;

import com.immanager.dataAccess.PaymentDbAccess;
import com.immanager.dataAccess.dao.PaymentDAO;
import com.immanager.exception.AllPaymentFromApartmentException;
import com.immanager.model.PaymentResult;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PaymentManager {
    private PaymentDAO paymentDataAccess;

    public PaymentManager() {
        setPaymentDataAccess(new PaymentDbAccess());
    }

    public ArrayList<PaymentResult> getAllPaymentFromApartmentName(GregorianCalendar firstDate, GregorianCalendar lastDate, Integer apartmentid) throws AllPaymentFromApartmentException {
        return paymentDataAccess.getAllPaymentFromApartmentName(firstDate, lastDate, apartmentid);
    }

    public void setPaymentDataAccess(PaymentDAO paymentDataAccess) {
        this.paymentDataAccess = paymentDataAccess;
    }
}
