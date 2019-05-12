package com.immanager.dataAccess;

import com.immanager.dataAccess.dao.PersonDAO;
import com.immanager.exception.AllPersonsException;
import com.immanager.exception.PersonByIDException;
import com.immanager.model.Person;

import java.sql.*;
import java.util.ArrayList;

public class PersonDbAccess implements PersonDAO {
    public Person getPersonById(Integer id) throws PersonByIDException{
        Person person = null;
        try{
            Connection connection = DataBaseConnection.getInstance().getConnection();

            String sql = "select * from person where id = "+id;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();
            ResultSetMetaData meta = data.getMetaData();

            if (data.next()){
                person = new Person(
                        data.getInt("id"),
                        data.getString("firstname"),
                        data.getString("lastname"),
                        data.getString("register"),
                        data.getString("address")
                );
            }
            else{
                throw new PersonByIDException("No data for this ID : "+id);
            }
        } catch (SQLException e) {
            throw new PersonByIDException(e.getMessage());
        }
        return person;
    }

    @Override
    public ArrayList<Person> getAllPersons() throws AllPersonsException {
        ArrayList<Person> personArrayList = new ArrayList<>();
        try {
            Connection connection = DataBaseConnection.getInstance().getConnection();

            String sql = "select * from person";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery();

            while (data.next()){
                personArrayList.add(new Person(
                        data.getInt("id"),
                        data.getString("firstname"),
                        data.getString("lastname"),
                        data.getString("register"),
                        data.getString("address")
                ));
            }
        } catch (SQLException e) {
            throw new AllPersonsException(e.getMessage());
        }

        return personArrayList;
    }
}
