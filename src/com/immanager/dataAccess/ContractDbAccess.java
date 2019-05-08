package com.immanager.dataAccess;

import com.immanager.dataAccess.dao.ContractDAO;
import com.immanager.exception.AllContractException;
import com.immanager.exception.ApartmentByIdException;
import com.immanager.exception.PersonByIDException;
import com.immanager.model.Apartment;
import com.immanager.model.Contract;
import com.immanager.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ContractDbAccess implements ContractDAO {
    public ArrayList<Contract> getAllContracts() throws AllContractException, ApartmentByIdException, PersonByIDException{
        ArrayList<Contract> contracts = new ArrayList<>();
        try {
            Connection connection = DataBaseConnection.getInstance().getConnection();

            String sql = "select * from contract join person on (contract.renterid = person.id)";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();
            while(data.next()){
                GregorianCalendar calendarDateStart = new GregorianCalendar();
                GregorianCalendar calendarDateEnd = new GregorianCalendar();

                calendarDateStart.setTime(data.getDate("date_start"));
                if (data.getDate("date_end")!= null)
                    calendarDateEnd.setTime(data.getDate("date_end"));
                else
                    calendarDateEnd = null;

                Person renter = new Person(
                        data.getString("firstname"),
                        data.getString("lastname"),
                        data.getString("register"),
                        data.getString("person.address")
                );

                Contract contract = new Contract(
                        calendarDateStart,
                        calendarDateEnd,
                        data.getDouble("waranty"),
                        data.getBoolean("cpasWaranty"),
                        data.getInt("guarantee1"),
                        data.getInt("guarantee2"),
                        renter,
                        data.getInt("apartmentid"),
                        data.getString("refRegistry")
                );

                contracts.add(contract);
            }

            connection.close();
        } catch (SQLException e) {
            throw new AllContractException(e.getMessage());
        }
        catch (PersonByIDException e){
            throw new PersonByIDException(e.getMessage());
        }
        catch (ApartmentByIdException e){
            throw new ApartmentByIdException(e.getMessage());
        }
        finally {
            return contracts;
        }
    }
}
