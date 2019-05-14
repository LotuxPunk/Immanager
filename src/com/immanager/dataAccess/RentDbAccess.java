package com.immanager.dataAccess;

import com.immanager.dataAccess.dao.RentDAO;
import com.immanager.exception.AllRentException;
import com.immanager.model.RentOwed;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        catch (SQLException e){
            throw new AllRentException(e.getMessage());
        }
        return rents;
    }
}
