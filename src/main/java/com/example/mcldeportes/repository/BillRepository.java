package com.example.mcldeportes.repository;

import com.example.mcldeportes.domain.Bill;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BillRepository extends ReactiveMongoRepository<Bill, String> {

}
