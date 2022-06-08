package com.example.mcldeportes.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

@Document(collection= "supplier")
public class Supplier {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 3);
    private String nameSupplier;
    private String phoneSupplier;
    private String directionSupplier;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getPhoneSupplier() {
        return phoneSupplier;
    }

    public void setPhoneSupplier(String phoneSupplier) {
        this.phoneSupplier = phoneSupplier;
    }

    public String getDirectionSupplier() {
        return directionSupplier;
    }

    public void setDirectionSupplier(String directionSupplier) {
        this.directionSupplier = directionSupplier;
    }
}
