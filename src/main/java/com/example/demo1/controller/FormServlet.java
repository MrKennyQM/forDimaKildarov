package com.example.demo1.controller;

import com.example.demo1.model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/forma-servlet")

public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String number = request.getParameter("number");

        Person person = new Person();
        person.setName(name);
        person.setNumber(Integer.parseInt(number));
        request.setAttribute("person", person);
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/add.jsp");
        dispatcher.forward(request, response);


    }
}

