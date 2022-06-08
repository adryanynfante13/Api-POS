package com.example.mcldeportes.controller;

import com.example.mcldeportes.domain.Supplier;
import com.example.mcldeportes.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/supplier")
public class SupplierController {

    private SupplierService supplierService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Supplier> save(@RequestBody Supplier supplier){
        return this.supplierService.save(supplier);
    }
    @GetMapping("/list")
    private Flux<Supplier> findAllProovedores(){
        return this.supplierService.findAll();
    }

    @PutMapping("/update/{id}")
    private Mono<Supplier> updateSupplier(@PathVariable("id") String id, @RequestBody Supplier supplier){
        return this.supplierService.update(id, supplier)
                .flatMap(Mono::just);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    private Mono<ResponseEntity<Supplier>> deleteSupplier(@PathVariable("id") String id){
        return this.supplierService.delete(id)
                .flatMap(s -> Mono.just(ResponseEntity.ok(s)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }



}
