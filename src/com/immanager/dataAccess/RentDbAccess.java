package com.immanager.dataAccess;

import com.immanager.dataAccess.dao.RentDAO;
import com.immanager.exception.AddContractException;
import com.immanager.exception.AddRentOwedException;
import com.immanager.exception.AllRentException;
import com.immanager.exception.SetAmountException;
import com.immanager.model.RentOwed;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class RentDbAccess implements RentDAO {
    @Override
    public ArrayList<RentOwed> getAllRentFromRenter(Integer contractID) throws AllRentException {
        ArrayList<RentOwed> rents = new ArrayList<>();
        try{
            Connection connection = DataBaseConnection.getInstance().getConnection();
            String sql = "select * from rent_owed where contractid = ? order by rent_owed.date asc";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, contractID);

            ResultSet data = statement.executeQuery();

            while (data.next()){
                GregorianCalendar dateRent = new GregorianCalendar();
                dateRent.setTime(data.getDate("date"));
                rents.add(new RentOwed(
                        data.getDouble("Rent"),
                        data.getDouble("Charge"),
                        dateRent
                ));
            }
        }
        catch (SQLException | SetAmountException e){
            throw new AllRentException(e.getMessage());
        }
        return rents;
    }

    @Override
    public void addRent(RentOwed rentOwed, Integer contractid) throws AddRentOwedException {
        try{
            Connection connection = DataBaseConnection.getInstance().getConnection();
            String sql = "insert into rent_owed (charge, rent, date, contractid) values (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            int i = 1;

            Date date = new Date(rentOwed.getDate().getTimeInMillis());

            statement.setDouble(i++,rentOwed.getAmount().getCharge());
            statement.setDouble(i++, rentOwed.getAmount().getRent());
            statement.setDate(i++, date);
            statement.setInt(i, contractid);

            statement.executeUpdate();
        }
        catch (SQLException e){
            throw new AddRentOwedException(e.getMessage());
        }
    }


}
