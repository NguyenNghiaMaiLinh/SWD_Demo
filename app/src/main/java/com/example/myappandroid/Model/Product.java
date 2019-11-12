package com.example.myappandroid.Model;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String urlImage;
    private String name;
    private int price;
    private double rating;
    private boolean isNew;
    private boolean isSale;
    private int sale;
    private String description;
    private int quantity;

    public Product(String id, String urlImage, String name, int price, double rating, boolean isNew, boolean isSale, int sale, String description, int quantity) {
        this.id = id;
        this.urlImage = urlImage;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.isNew = isNew;
        this.isSale = isSale;
        this.sale = sale;
        this.description = description;
        this.quantity = quantity;
    }

    public Product(String id, String urlImage, String name, int price, double rating, int sale, String description) {
        this.id = id;
        this.urlImage = urlImage;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.sale = sale;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
