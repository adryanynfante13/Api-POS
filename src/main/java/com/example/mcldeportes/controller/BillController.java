package com.example.mcldeportes.controller;

import com.example.mcldeportes.domain.Bill;
import com.example.mcldeportes.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/bills")
public class BillController {
    private BillService billService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Bill> save(@RequestBody Bill bill){
        return this.billService.save(bill);
    }

    @GetMapping("/list")
    private Flux<Bill> findAllBills(){
        return this.billService.findAll();
    }

    @GetMapping("/lista/{id}")
    private Mono<Bill> findBillID(@PathVariable("id") String id){
        return this.billService.findById(id);
    }
}


