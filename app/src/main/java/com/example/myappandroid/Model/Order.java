package com.example.myappandroid.Model;

import java.io.Serializable;

public class Order implements Serializable {
    private String id;
    private int price;
    private int sale;
    private String name;
    private int quantity;
    private String urlImage;
    private String providedBy;

    public Order(String id, int price, int sale, String name, int quantity, String urlImage, String providedBy) {
        this.id = id;
        this.price = price;
        this.sale = sale;
        this.name = name;
        this.quantity = quantity;
        this.urlImage = urlImage;
        this.providedBy = providedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getProvidedBy() {
        return providedBy;
    }

    public void setProvidedBy(String providedBy) {
        this.providedBy = providedBy;
    }
}
