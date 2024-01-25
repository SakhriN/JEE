package org.example.exo1.DAO;

import org.example.exo1.models.Product;

import java.util.Date;
import java.util.List;

public interface ProductDAO {

    public void Create(Product product);

    public Product ReadOne(int id);

    public List<Product> ReadAll();

    public void Update(Product product);

    public void Delete(int id);
}