package com.immanager.dataAccess;

import com.immanager.dataAccess.dao.ApartmentDAO;
import com.immanager.exception.AllApartmentException;
import com.immanager.exception.ApartmentByIdException;
import com.immanager.model.Apartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ApartmentDbAccess implements ApartmentDAO {
    private static HashMap<Integer, Apartment> apartmentMap = new HashMap<>();

    /**
     * Method to get the apartment from the database using the flyweight pattern
     * @param id of the apartment
     * @return  the apartment from the database
     */
    public Apartment getApartmentById(Integer id) throws ApartmentByIdException{
        if (apartmentMap.containsKey(id)){
            return apartmentMap.get(id);
        }
        Apartment apartment = null;
        try{
            Connection connection = DataBaseConnection.getInstance().getConnection();

            String sql = "select * from apartment where idApartment = "+id;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();

            if (data.next()){
                apartment = new Apartment(
                        data.getInt("idApartment"),
                        data.getString("name"),
                        data.getString("city"),
                        data.getString("address"),
                        data.getInt("postal_code")
                );
            }
            else{
                throw new ApartmentByIdException("No data for this ID : "+id);
            }

            apartmentMap.put(id, apartment);
        } catch (SQLException e) {
            throw new ApartmentByIdException(e.getMessage());
        }
        return apartment;
    }

    public ArrayList<Apartment> getAllApartments() throws AllApartmentException {
        ArrayList<Apartment> apartments = new ArrayList<>();
        try{
            Connection connection = DataBaseConnection.getInstance().getConnection();

            String sql = "select * from apartment";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                apartments.add(new Apartment(
                        data.getInt("idApartment"),
                        data.getString("name"),
                        data.getString("city"),
                        data.getString("address"),
                        data.getInt("postal_code")
                ));
            }
        } catch (SQLException e) {
            throw new AllApartmentException(e.getMessage());
        }
        return apartments;
    }
}
