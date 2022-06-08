package com.example.mcldeportes.services.implementation;

import com.example.mcldeportes.domain.Bill;
import com.example.mcldeportes.repository.BillRepository;
import com.example.mcldeportes.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BillServiceImplementation implements BillService {
    @Autowired
    private BillRepository billRepository;

    @Override
    public Mono<Bill> save(Bill bill) {
        return this.billRepository.save(bill);
    }

    @Override
    public Flux<Bill> findAll() {
         return this.billRepository.findAll();
    }

    @Override
    public Mono<Bill> findById(String id) {
        return this.billRepository.findById(id);
    }
}
