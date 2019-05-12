package com.immanager.dataAccess;

import com.immanager.dataAccess.dao.PaymentDAO;
import com.immanager.exception.AllPaymentException;
import com.immanager.model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PaymentDbAccess implements PaymentDAO {
    @Override
    public ArrayList<Payment> getAllPaymentFromRenter(Integer contractID) throws AllPaymentException {
        ArrayList<Payment> payments = new ArrayList<>();
        try{
            Connection connection = DataBaseConnection.getInstance().getConnection();
            String sql = "select * from payment where contractid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(0, contractID);

            ResultSet data = statement.executeQuery();

            while (data.next()){
                GregorianCalendar datePayment = new GregorianCalendar();
                datePayment.setTime(data.getDate("date"));
                payments.add(new Payment(
                        data.getDouble("amount"),
                        datePayment
                ));
            }
        }
        catch (SQLException e){
            throw new AllPaymentException(e.getMessage());
        }
        return payments;
    }
}
