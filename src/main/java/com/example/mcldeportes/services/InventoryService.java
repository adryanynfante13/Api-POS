package com.example.mcldeportes.services;

import com.example.mcldeportes.domain.Inventory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InventoryService {
    Mono<Inventory> save(Inventory inventory);

    Flux<Inventory> findAll();

    Mono<Inventory> findById(String id);

    Mono<Inventory> delete(String id);

    Mono<Inventory> update(String id, Inventory cliente);
}
