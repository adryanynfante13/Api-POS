package com.example.mcldeportes.controller;

import com.example.mcldeportes.domain.Inventory;
import com.example.mcldeportes.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    private InventoryService inventoryService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Inventory> save(@RequestBody Inventory inventory){
        return this.inventoryService.save(inventory);
    }

    @GetMapping("/list")
    private Flux<Inventory> findAllInventory(){
        return this.inventoryService.findAll();
    }

    @GetMapping("/{id}")
    private Mono<Inventory> findbyIdInventory(@PathVariable("id") String id){
        return this.inventoryService.findById(id);
    }

    @PutMapping("/update/{id}")
    private Mono<ResponseEntity<Inventory>>update(@PathVariable("id") String id, @RequestBody Inventory inventory){
        return this.inventoryService.update(id, inventory)
                .flatMap(i -> Mono.just(ResponseEntity.ok(i)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @DeleteMapping("/delete/{id}")
    private Mono<ResponseEntity<Inventory>> deleteArticulo(@PathVariable("id") String id){
        return this.inventoryService.delete(id)
                .flatMap(c -> Mono.just(ResponseEntity.ok(c)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }



}
