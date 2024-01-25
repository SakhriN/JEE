package org.example.exo1.DAO;



import org.example.exo1.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    StandardServiceRegistry registry ;
    SessionFactory sessionFactory;
    Transaction tx = null;

    public ProductDAOImpl() {
  registry = new StandardServiceRegistryBuilder().configure().build();
   sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public void Create(Product product) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(product);
        tx.commit();
        session.close();
    }

    ;

    public Product ReadOne(int id) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Product product = session.get(Product.class, id);
        tx.commit();
        session.close();
        return product;
    }

    public List<Product> ReadAll() {
        Session session = sessionFactory.openSession();
        Query<Product> query = session.createQuery("FROM Product");
        List<Product> products = query.list();
        session.close();
        return products;
    }

    public void Update(Product product) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();

        session.update(product);
        tx.commit();
        session.close();
    }

    public void Delete(int id) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);
        tx.commit();
        session.close();
    }
}