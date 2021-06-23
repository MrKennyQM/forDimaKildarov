package com.example.demo1.controller;

import com.example.demo1.model.Person;
import com.example.demo1.repository.BaseDao;
import com.example.demo1.repository.impl.PersonDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;






@WebServlet(value = "/addPerson")
public class AddPerson extends HttpServlet {
    private BaseDao baseDao = new PersonDaoImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        Person person = new Person();
        person.setName(name);
        person.setNumber(Integer.parseInt(number));
        baseDao.addPerson(person);
        response.sendRedirect("/person-servlet");
    }
}
