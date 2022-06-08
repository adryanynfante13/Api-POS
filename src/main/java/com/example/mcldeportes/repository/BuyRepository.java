package com.example.mcldeportes.repository;

import com.example.mcldeportes.domain.Buy;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BuyRepository extends ReactiveMongoRepository<Buy, String> {
}
