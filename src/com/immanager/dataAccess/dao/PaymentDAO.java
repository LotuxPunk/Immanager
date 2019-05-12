package com.immanager.dataAccess.dao;

import com.immanager.exception.AllPaymentException;
import com.immanager.model.Payment;

import java.util.ArrayList;

public interface PaymentDAO {
    ArrayList<Payment> getAllPaymentFromRenter(Integer contractID) throws AllPaymentException;
}
