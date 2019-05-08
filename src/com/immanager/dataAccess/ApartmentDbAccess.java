package com.immanager.dataAccess;

import com.immanager.exception.ApartmentByIdException;
import com.immanager.model.Apartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ApartmentDbAccess {
    private static HashMap<Integer, Apartment> apartmentMap = new HashMap<>();

    /**
     * Method to get the apartment from the database using the flyweight pattern
     * @param id of the apartment
     * @return  the apartment from the database
     * @throws ApartmentByIdException
     */
    public static Apartment getApartmentById(Integer id) throws ApartmentByIdException {
        if (apartmentMap.containsKey(id)){
            return apartmentMap.get(id);
        }
        Apartment apartment = null;
        Connection connection = DataBaseConnection.getInstance().getConnection();
        try{
            String sql = "select * from apartment where id = "+id;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();

            if (!data.next()){
                apartment = new Apartment(
                        data.getString("name"),
                        data.getString("city"),
                        data.getString("address"),
                        data.getString("postal_code")
                );
            }
            else{
                throw new ApartmentByIdException("No data for this ID : "+id);
            }

            apartmentMap.put(id, apartment);
            connection.close();
        } catch (SQLException e) {
            throw new ApartmentByIdException(e.getMessage());
        }
        finally {
            return apartment;
        }
    }
}
