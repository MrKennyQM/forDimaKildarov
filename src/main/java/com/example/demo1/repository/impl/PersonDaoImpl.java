package com.example.demo1.repository.impl;

import com.example.demo1.configuration.ConnectionToDB;
import com.example.demo1.controller.HelloServlet;
import com.example.demo1.exception.StringException;
import com.example.demo1.model.Person;
import com.example.demo1.repository.BaseDao;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PersonDaoImpl implements BaseDao {
    private static final Logger LOGGER = LogManager.getLogger(PersonDaoImpl.class);
    private static final String SQL_GET_ALL = "select * from u_users";
    private static final String SQL_ADD_PERSON = "insert into u_users (u_name, u_number) values (?, ?)";
    private static final String SQL_DELETE_PERSON = "DELETE FROM u_users WHERE id = ?";
    private static final String SQL_DELETE_BY_NAME = "delete from u_users where u_name = ?";
    private ConnectionToDB connectionToDB = new ConnectionToDB();

    @Override
    public List<Person> getAll() {

        List<Person> personList = new ArrayList<>();
        try (Connection connection = connectionToDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_GET_ALL);

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("Id"));
                person.setName(resultSet.getString("u_name"));
                person.setNumber(resultSet.getInt("u_number"));
                personList.add(person);
            }
        } catch (Exception e) {
            throw new StringException(e);
        }
        return personList;
    }

    @Override
    public boolean addPerson(Person person) {

        try (Connection connection = connectionToDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_PERSON)) {
            LOGGER.log(Level.ALL, " NamePerson"+": " + person.getName());
            LOGGER.log(Level.ALL, " Weith"+": " + person.getNumber());
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getNumber());
            boolean isAdded = preparedStatement.execute();
            return isAdded;
        } catch (Exception e) {
            throw new StringException(e);
        }
    }


    @Override
    public boolean deletePersonById(Person person) {
        try (Connection connection = connectionToDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_PERSON)) {
            preparedStatement.setInt(1, person.getId());
            boolean isDeleted = preparedStatement.execute();
            return isDeleted;
        } catch (Exception e) {
            throw new StringException(e);
        }
    }

    @Override
    public boolean deletePersonByName(Person person) {
        try (Connection connection = connectionToDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_BY_NAME)) {
            statement.setString(1, person.getName());


            int isDeleted = statement.executeUpdate();
            if (isDeleted > 0) {
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            throw new StringException(e);
        }
    }
}
