package com.example.mcldeportes.services;

import com.example.mcldeportes.domain.Bill;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BillService {
    Mono<Bill> save(Bill bill);

    Flux<Bill> findAll();

    Mono<Bill> findById(String id);
}
