package com.example.mcldeportes.services.implementation;

import com.example.mcldeportes.domain.Inventory;
import com.example.mcldeportes.repository.InventoryRepository;
import com.example.mcldeportes.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class InventoryServiceImplementation implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public Mono<Inventory> save(Inventory inventory) {
        return this.inventoryRepository.save(inventory);
    }
    //listar inventario
    @Override
    public Flux<Inventory> findAll() {
        return this.inventoryRepository.findAll();
    }
    //listar inventario por id
    @Override
    public Mono<Inventory> findById(String id) {
        return this.inventoryRepository.findById(id);
    }
    //eliminar por producto
    @Override
    public Mono<Inventory> delete(String id) {
        return this.inventoryRepository
                .findById(id)
                .flatMap(e -> this.inventoryRepository.deleteById(e.getId()).thenReturn(e));
    }
    //actualizar producto
    @Override
    public Mono<Inventory> update(String id, Inventory inventory) {
        return this.inventoryRepository.findById(id)
                .flatMap(i->{
                    inventory.setId(id);
                    return save(inventory);
                }).switchIfEmpty(Mono.empty());
    }
}
