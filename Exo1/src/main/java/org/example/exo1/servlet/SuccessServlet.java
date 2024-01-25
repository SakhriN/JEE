package org.example.exo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo1.DAO.ProductDAOImpl;
import org.example.exo1.models.Product;
import java.io.IOException;

import java.io.IOException;
@WebServlet(name = "success", value ="/success")
public class SuccessServlet extends HttpServlet {


        ProductDAOImpl bloup;


        @Override
        public void init() throws ServletException {
            bloup = new ProductDAOImpl();
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                req.getRequestDispatcher("success.jsp").forward(req,resp);
            // Redirigez l'utilisateur vers une autre page après le délai
        }
    }


