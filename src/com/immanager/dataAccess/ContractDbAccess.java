package com.immanager.dataAccess;

import com.immanager.dataAccess.dao.ContractDAO;
import com.immanager.exception.AddContractException;
import com.immanager.exception.AllContractException;
import com.immanager.exception.ApartmentByIdException;
import com.immanager.exception.PersonByIDException;
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
        } catch (SQLException e) {
            throw new AllContractException(e.getMessage());
        }
        catch (PersonByIDException e){
            throw new PersonByIDException(e.getMessage());
        }
        catch (ApartmentByIdException e){
            throw new ApartmentByIdException(e.getMessage());
        }
        return contracts;
    }

    public void addContract(Contract contract, Integer guarantee1ID, Integer guarantee2ID, Integer renterID, Integer apartmentID) throws AddContractException {
        try{
            Connection connection = DataBaseConnection.getInstance().getConnection();
            String sql = "insert into contract (Date_start, Date_end, Waranty, Cpaswaranty, Guarantee1, Guarantee2, Renterid, Apartmentid, Refregistry) value (?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            int i = 1;
            statement.setDate(i++, new Date(contract.getDateStart().getTimeInMillis()));
            statement.setDate(i++, new Date(contract.getDateEnd().getTimeInMillis()));
            statement.setDouble(i++, contract.getWarranty());
            statement.setBoolean(i++, contract.isCpasWarranty());
            statement.setInt(i++, guarantee1ID);
            statement.setInt(i++, guarantee2ID);
            statement.setInt(i++, renterID);
            statement.setInt(i++, apartmentID);
            statement.setString(i, contract.getRefEnregistrement());

            statement.executeQuery();
        }
        catch (SQLException e){
            throw new AddContractException(e.getMessage());
        }
    }
}
