package com.immanager.dataAccess;

import com.immanager.dataAccess.dao.PaymentDAO;
import com.immanager.exception.AllPaymentException;
import com.immanager.exception.AllPaymentFromApartmentException;
import com.immanager.model.Payment;
import com.immanager.model.PaymentResult;
import com.immanager.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PaymentDbAccess implements PaymentDAO {
    @Override
    public ArrayList<Payment> getAllPaymentFromRenter(Integer contractID) throws AllPaymentException {
        ArrayList<Payment> payments = new ArrayList<>();
        try{
            Connection connection = DataBaseConnection.getInstance().getConnection();
            String sql = "select * from payment where contractid = ? order by payment.date asc";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, contractID);

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

    @Override
    public ArrayList<PaymentResult> getAllPaymentFromApartmentName(GregorianCalendar firstDate, GregorianCalendar lastDate, Integer apartmentid) throws AllPaymentFromApartmentException {
        ArrayList<PaymentResult> payments = new ArrayList<>();

        try {
            Connection connection = DataBaseConnection.getInstance().getConnection();

            String sql = "select payment.amount, payment.date, person.firstname, person.lastname, person.register, person.id from payment join contract on(payment.contractid = contract.id) join person on(person.id = contract.renterid) where contract.apartmentid = ? and payment.date between ? and ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            int i = 1;
            statement.setInt(i++, apartmentid);
            statement.setDate(i++, new Date(firstDate.getTimeInMillis()));
            statement.setDate(i, new Date(lastDate.getTimeInMillis()));

            System.out.println(statement);

            ResultSet data = statement.executeQuery();

            while (data.next()){
                Person person = new Person(
                        data.getInt("person.id"),
                        data.getString("person.firstname"),
                        data.getString("person.lastname"),
                        data.getString("person.register"),
                        null
                );

                GregorianCalendar date = new GregorianCalendar();
                date.setTime(data.getDate("payment.date"));

                Payment payment = new Payment(
                        data.getDouble("payment.amount"),
                        date
                );

                payments.add(new PaymentResult(payment, person));
            }

        } catch (SQLException e) {
            throw new AllPaymentFromApartmentException(e.getMessage());
        }
        return payments;
    }
}
