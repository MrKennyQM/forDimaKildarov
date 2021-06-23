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

@WebServlet(value = "/deleteByName")
public class DeletePersonByName extends HttpServlet {
    private BaseDao dao = new PersonDaoImpl();
    Person person = new Person();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        person.setName(name);

        if (dao.deletePersonByName(person)){
            resp.sendRedirect("/person-servlet");
        }else resp.sendRedirect("/noSuchPerson.html");
    }
}
