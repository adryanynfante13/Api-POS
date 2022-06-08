package com.example.mcldeportes.repository;

import com.example.mcldeportes.domain.Inventory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface InventoryRepository extends ReactiveMongoRepository<Inventory, String> {
    Mono<Inventory> findById(String id);

}
