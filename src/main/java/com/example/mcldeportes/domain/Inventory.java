package com.example.mcldeportes.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

@Document(collection = "inventory")
public class Inventory {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 3);
    private String nameProduct;
    private int price;
    private int quantityAvailable ;
    private int quantityMin;
    private int quantityMax;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public int getQuantityMin() {
        return quantityMin;
    }

    public void setQuantityMin(int quantityMin) {
        this.quantityMin = quantityMin;
    }

    public int getQuantityMax() {
        return quantityMax;
    }

    public void setQuantityMax(int quantityMax) {
        this.quantityMax = quantityMax;
    }
}
