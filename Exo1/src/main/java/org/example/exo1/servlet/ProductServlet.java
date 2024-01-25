package org.example.exo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo1.DAO.ProductDAOImpl;
import org.example.exo1.models.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "product", value ="/product")
public class ProductServlet extends HttpServlet {
    private ProductDAOImpl bloup;

    private List<Product> demission = new ArrayList<>();


    @Override
    public void init() throws ServletException {
         bloup = new ProductDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        demission = bloup.ReadAll();
        System.out.println(demission);
        req.setAttribute("products", demission);
        req.getRequestDispatcher("product-list.jsp").forward(req,resp);
    }
}


