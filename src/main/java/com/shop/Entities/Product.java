package com.shop.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String productName;
    @NotNull
    private Double price;

    public Product() {
    }

    public Product(String productName, Double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.valueOf(getId());
    }
}
