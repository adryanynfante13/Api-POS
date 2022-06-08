package com.example.mcldeportes.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "buys")
public class Buy {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 3);
    private int quantity;

    @DBRef
    private Inventory product;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Inventory getProduct() {
        return product;
    }

    public void setProduct(Inventory product) {
        this.product = product;
    }
}
