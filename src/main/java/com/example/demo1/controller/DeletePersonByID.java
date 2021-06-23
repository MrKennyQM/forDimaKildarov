package com.example.demo1.controller;

import com.example.demo1.model.Person;
import com.example.demo1.repository.BaseDao;
import com.example.demo1.repository.impl.PersonDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deletePerson")
public class DeletePersonByID extends HttpServlet {

    private BaseDao baseDao = new PersonDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = new Person();
        String id = req.getParameter("id");
        person.setId(Integer.parseInt(id));
        baseDao.deletePersonById(person);
        resp.sendRedirect("/person-servlet");
    }
}
