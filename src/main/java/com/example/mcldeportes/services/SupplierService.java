package com.example.mcldeportes.services;

import com.example.mcldeportes.domain.Supplier;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SupplierService {
    Mono<Supplier> save(Supplier supplier);

    Flux<Supplier> findAll();

    Mono<Supplier> update(String id, Supplier supplier);

    Mono<Supplier> delete(String id);
}

