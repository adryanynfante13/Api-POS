package com.example.mcldeportes.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection= "bills")
public class Bill {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 3);
    private String fecha;
    @DBRef
    private Client client;
    private String nameSeller;

    @DBRef
    private List<Buy> products;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getNameSeller() {
        return nameSeller;
    }

    public void setNameSeller(String nameSeller) {
        this.nameSeller = nameSeller;
    }

    public List<Buy> getProducts() {
        return products;
    }

    public void setProducts(List<Buy> products) {
        this.products = products;
    }
}
