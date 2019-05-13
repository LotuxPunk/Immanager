package com.immanager.dataAccess;

import com.immanager.dataAccess.dao.ContractDAO;
import com.immanager.exception.AddContractException;
import com.immanager.exception.AllContractException;
import com.immanager.model.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ContractDbAccess implements ContractDAO {

    @Override
    public ArrayList<Contract> getAllContracts() throws AllContractException {
        ArrayList<Contract> contracts = new ArrayList<>();
        try {
            Connection connection = DataBaseConnection.getInstance().getConnection();

            String sql = "select * from contract";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();
            while(data.next()){
                GregorianCalendar calendarDateStart = new GregorianCalendar();
                GregorianCalendar calendarDateEnd = new GregorianCalendar();

//                Dates
                calendarDateStart.setTime(data.getDate("date_start"));
                Date dateEnd = data.getDate("date_end");
                if (data.wasNull())
                    calendarDateEnd = null;
                else
                    calendarDateEnd.setTime(dateEnd);

//                Guarantees
                Integer guarantee1, guarantee2;
                guarantee1 = data.getInt("guarantee1");
                if (data.wasNull())
                    guarantee1 = null;
                guarantee2 = data.getInt("guarantee2");
                if (data.wasNull())
                    guarantee2 = null;

                Contract contract = new Contract(
                        data.getInt("id"),
                        calendarDateStart,
                        calendarDateEnd,
                        data.getDouble("waranty"),
                        data.getBoolean("cpasWaranty"),
                        data.getString("refRegistry"),
                        data.getInt("apartmentid"),
                        data.getInt("renterid"),
                        guarantee1,
                        guarantee2
                );

                contracts.add(contract);
            }
        } catch (SQLException e) {
            throw new AllContractException(e.getMessage());
        }
        return contracts;
    }

    @Override
    public void addContract(Contract contract) throws AddContractException {
        try{
            Connection connection = DataBaseConnection.getInstance().getConnection();
            String sql = "insert into contract (Date_start, Date_end, Waranty, Cpaswaranty, Guarantee1, Guarantee2, Renterid, Apartmentid, Refregistry) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            int i = 1;
            statement.setDate(i++, new Date(contract.getDateStart().getTimeInMillis()));

            if (contract.getDateEnd() != null)
                statement.setDate(i++, new Date(contract.getDateEnd().getTimeInMillis()));
            else
                statement.setNull(i++, Types.DATE);

            statement.setDouble(i++, contract.getWarranty());
            statement.setBoolean(i++, contract.getCpasWarranty());

            if (contract.getGuarantee1() != null)
                statement.setInt(i++, contract.getGuarantee1());
            else
                statement.setNull(i++,Types.INTEGER);

            if (contract.getGuarantee2() != null)
                statement.setInt(i++, contract.getGuarantee2());
            else
                statement.setNull(i++,Types.INTEGER);

            statement.setInt(i++, contract.getRenterID());
            statement.setInt(i++, contract.getApartmentID());

            if (contract.getRefEnregistrement() != null)
                statement.setString(i, contract.getRefEnregistrement());
            else
                statement.setNull(i,Types.VARCHAR);

            statement.executeUpdate();
        }
        catch (SQLException e){
            throw new AddContractException(e.getMessage());
        }
    }
}
