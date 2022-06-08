package com.example.mcldeportes.services.implementation;

import com.example.mcldeportes.domain.Supplier;
import com.example.mcldeportes.repository.SupplierRepository;
import com.example.mcldeportes.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SupplierServiceImplementation implements SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    //guardar proveedor
    @Override
    public Mono<Supplier> save(Supplier supplier) {
        return this.supplierRepository.save(supplier);
    }
    //listar proveedores
    @Override
    public Flux<Supplier> findAll() {
        return this.supplierRepository.findAll();
    }
    //act proveedor
    @Override
    public Mono<Supplier> update(String id, Supplier supplier) {
        return this.supplierRepository.findById(id)
                .flatMap(c -> {
                    supplier.setId(id);
                    return save(supplier);
                }).switchIfEmpty(Mono.empty());
    }
    //eliminar proveedor
    @Override
    public Mono<Supplier> delete(String id) {
        return this.supplierRepository
                .findById(id)
                .flatMap(s -> this.supplierRepository.deleteById(s.getId()).thenReturn(s));
    }
}
