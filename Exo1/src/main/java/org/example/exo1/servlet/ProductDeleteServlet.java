package org.example.exo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo1.DAO.ProductDAOImpl;
import org.example.exo1.models.Product;

import java.io.IOException;


@WebServlet(name = "supprimer", value ="/supprimer")
public class ProductDeleteServlet extends HttpServlet {
    ProductDAOImpl bloup;


    @Override
    public void init() throws ServletException {
        bloup = new ProductDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        int id = Integer.parseInt(idParam);
        bloup.Delete(id);
        resp.sendRedirect(req.getContextPath() + "/product");
    }


}
