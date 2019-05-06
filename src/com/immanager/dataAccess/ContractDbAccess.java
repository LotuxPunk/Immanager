package com.immanager.dataAccess;

import com.immanager.exception.AllContractException;
import com.immanager.model.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ContractDbAccess {
    public ArrayList<Contract> getAllContracts() throws AllContractException{
        ArrayList<Contract> contracts = new ArrayList<>();
        Connection connection = DataBaseConnection.getInstance().getConnection();
        try {
            String sql = "select * from contract";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();
            ResultSetMetaData meta = data.getMetaData();
            while(data.next()){
                GregorianCalendar calendarDateStart = new GregorianCalendar();
                GregorianCalendar calendarDateEnd = new GregorianCalendar();

                calendarDateStart.setTime(data.getDate("date_start"));
                calendarDateEnd.setTime(data.getDate("date_end"));

                Contract contract = new Contract(
                        calendarDateStart,
                        calendarDateEnd,
                        data.getDouble("waranty"),
                        data.getBoolean("cpasWaranty"),
                        data.getInt("guarantee1"),
                        data.getInt("guarantee2"),
                        data.getInt("renterid"),
                        data.getInt("apartmentid"),
                        data.getString("refRegistry")
                );

                contracts.add(contract);
            }

            connection.close();
        } catch (SQLException e) {
            throw new AllContractException(e.getMessage());
        }
        finally {
            return contracts;
        }
    }
}
