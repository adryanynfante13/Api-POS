package com.example.mcldeportes.repository;

import com.example.mcldeportes.domain.Supplier;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SupplierRepository  extends ReactiveMongoRepository<Supplier, String> {
}
