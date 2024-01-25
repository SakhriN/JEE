package org.example.exo1.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "produit")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String marque, reference;
    Date dateAchat;
    double prix;
    int stock;

    public Product() {
    }

    public Product(String marque, String reference, Date dateAchat, double prix, int stock) {
        this.marque = marque;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.stock = stock;
    }

    public Product(int id, String marque, String reference, Date dateAchat, double prix, int stock) {
        this.id = id;
        this.marque = marque;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product : " +
                "id=" + id +
                ", marque='" + marque +
                ", reference='" + reference +
                ", dateAchat=" + dateAchat +
                ", prix=" + prix +
                ", stock=" + stock +
                '}';
    }
}