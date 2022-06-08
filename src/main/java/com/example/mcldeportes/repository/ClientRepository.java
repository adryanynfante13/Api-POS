package com.example.mcldeportes.repository;

import com.example.mcldeportes.domain.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {
    Mono<Client> findById(String id);
}
