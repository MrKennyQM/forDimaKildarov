package com.example.demo1.repository;

import com.example.demo1.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao {
     List<Person> getAll();
     boolean addPerson (Person person);
     boolean deletePersonById(Person person);
     boolean deletePersonByName(Person person);


}
