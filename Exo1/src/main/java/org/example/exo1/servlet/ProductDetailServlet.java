package org.example.exo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo1.DAO.ProductDAOImpl;
import org.example.exo1.models.Product;

import java.io.IOException;


@WebServlet(name = "detail", value ="/detail")
public class ProductDetailServlet extends HttpServlet {
ProductDAOImpl bloup;


    @Override
    public void init() throws ServletException {
        bloup = new ProductDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        int id = Integer.parseInt(idParam);
        Product product = bloup.ReadOne(id);
        System.out.println(product);
        req.setAttribute("detail", product);
        req.getRequestDispatcher("detail.jsp").forward(req,resp);
    }


}
