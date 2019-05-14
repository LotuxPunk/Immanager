package com.immanager.dataAccess.dao;

import com.immanager.exception.AllPaymentException;
import com.immanager.exception.AllPaymentFromApartmentException;
import com.immanager.model.Payment;
import com.immanager.model.PaymentResult;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface PaymentDAO {
    ArrayList<Payment> getAllPaymentFromRenter(Integer contractID) throws AllPaymentException;
    ArrayList<PaymentResult> getAllPaymentFromApartmentName(GregorianCalendar firstDate, GregorianCalendar lastDate, Integer apartmentid) throws AllPaymentFromApartmentException;
}
