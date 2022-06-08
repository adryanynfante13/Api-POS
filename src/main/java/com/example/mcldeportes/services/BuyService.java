package com.example.mcldeportes.services;

import com.example.mcldeportes.domain.Buy;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BuyService {
    Mono<Buy> save(Buy buy);

    Flux<Buy> findAll();

    Mono<Buy> findById(String id);

    Mono<Buy> delete(String id);

    Mono<Buy> update(String id, Buy buy);
}
