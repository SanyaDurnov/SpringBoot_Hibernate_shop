package com.shop.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private long id;
    private Integer quantity;
    private String orderName;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private Product product;




    public Order() {
    }

    public Order(Product product, int quantity, String orderName) {
        this.product = product;
        this.quantity = quantity;
        this.orderName = orderName;
    }

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }


    public Order(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}