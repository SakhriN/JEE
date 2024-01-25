package org.example.exo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo1.DAO.ProductDAOImpl;
import org.example.exo1.models.Product;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "form", value = "/form")
public class ProductFormServlet extends HttpServlet {
    private ProductDAOImpl bloup;
    Product product;

    @Override
    public void init() throws ServletException {
        bloup = new ProductDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String editParam = req.getParameter("edit");
        int edit = Integer.parseInt(editParam);
        if (edit == 1) {
            String idParam = req.getParameter("id");
            int id = Integer.parseInt(idParam);
            product = bloup.ReadOne(id);
            req.getSession().setAttribute("formProductId", id);
            req.setAttribute("formproduct", product);
        }
        req.getRequestDispatcher("form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer formProductId = (Integer) req.getSession().getAttribute("formProductId");
        if (formProductId == null) {
            String reference = req.getParameter("reference");
            Date date = Date.valueOf(req.getParameter("date"));
            String marque = req.getParameter("marque");
            Integer stock = Integer.valueOf(req.getParameter("stock"));
            double prix = Double.parseDouble(req.getParameter("prix"));
            product = new Product(marque, reference, date, prix, stock);
            bloup.Create(product);
        }else{
            int id = formProductId;
            String reference = req.getParameter("reference");
            Date date = Date.valueOf(req.getParameter("date"));
            String marque = req.getParameter("marque");
            Integer stock = Integer.valueOf(req.getParameter("stock"));
            double prix = Double.parseDouble(req.getParameter("prix"));
            product = new Product(id,marque, reference, date, prix, stock);
            bloup.Update(product);
        }


        resp.sendRedirect(req.getContextPath() + "/success");
    }
}
