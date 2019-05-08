package com.immanager.dataAccess;

import com.immanager.exception.PersonByIDException;
import com.immanager.model.Person;

import java.sql.*;

public class PersonDbAccess {
    public static Person getPersonById(Integer id) throws PersonByIDException {
        Person person = null;
        Connection connection = DataBaseConnection.getInstance().getConnection();
        try{
            String sql = "select * from person where id = "+id;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();
            ResultSetMetaData meta = data.getMetaData();

            if (!data.next()){
                person = new Person(
                        data.getString("firstname"),
                        data.getString("lastname"),
                        data.getString("register"),
                        data.getString("address")
                );
            }
            else{
                throw new PersonByIDException("No data for this ID : "+id);
            }

            connection.close();
        } catch (SQLException e) {
            throw new PersonByIDException(e.getMessage());
        }
        finally {
            return person;
        }
    }
}
