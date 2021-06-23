package com.example.demo1.controller;

import com.example.demo1.model.Person;
import com.example.demo1.repository.BaseDao;
import com.example.demo1.repository.impl.PersonDaoImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/person-servlet")
public class PersonServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(HelloServlet.class);

    private BaseDao personDao = new PersonDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.log(Level.ALL, "ERROR");
        List<Person> personList = personDao.getAll();

        req.setAttribute("size", personList.size());
        req.setAttribute("personList", personList); // передаем лист
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/result.jsp");
        dispatcher.forward(req, resp);

    }
}
