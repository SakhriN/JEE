package org.example.exoservlet.persons;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exoservlet.persons.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "mainmenu", value ="/mainmenu")
public class MainMenuServlet extends HttpServlet {
    Person person;


    @Override
    public void init() throws ServletException {
        person = new Person();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = new Person(27,"Nassim","Sakhri");
        Person person2 = new Person(32,"Clement","Roelens");
        Person person3 = new Person(37, "Christophe","Delory");
        List<Person> persons = new ArrayList<>();
        persons.add(person);
        persons.add(person2);
        persons.add(person3);


        req.setAttribute("persons", persons);
        req.setAttribute("detail", person);
        req.setAttribute("detail1", person2);
        req.setAttribute("detail2", person3);
        req.getRequestDispatcher("/mainmenu.jsp").forward(req,resp);
    }


}