package com.example.mcldeportes.services;

import com.example.mcldeportes.domain.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
    Mono<Client> save(Client client);

    Flux<Client> findAll();

    Mono<Client> findById(String id);

    Mono<Client> delete(String id);

    Mono<Client> update(String id, Client client);
}
