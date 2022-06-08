package com.example.mcldeportes.services.implementation;

import com.example.mcldeportes.domain.Buy;
import com.example.mcldeportes.domain.Inventory;
import com.example.mcldeportes.repository.BuyRepository;
import com.example.mcldeportes.services.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BuyServiceImplentation  implements BuyService {
    @Autowired
    private BuyRepository buyRepository;
    @Autowired
    InventoryServiceImplementation serviceImplement;

    @Override
    public Mono<Buy> save(Buy buy) {
        Inventory inventory = new Inventory();
        var product = buy.getProduct();
        var idProduct = product.getId();
        var productFound = serviceImplement.findById(idProduct);

        return productFound
                .flatMap(x -> {
                    return this.buyRepository.save(buy);
                })
                .switchIfEmpty(Mono.empty());
    }
    //listar todas las compras
    @Override
    public Flux<Buy> findAll()  {
        return this.buyRepository.findAll();
    }
    //listar compra por id
    @Override
    public Mono<Buy> findById(String id)  {
        return this.buyRepository.findById(id);
    }
    //eliminar compra
    @Override
    public Mono<Buy> delete(String id) {
        return this.buyRepository
                .findById(id)
                .flatMap(c -> this.buyRepository.deleteById(c.getId()).thenReturn(c));
    }

    @Override
    public Mono<Buy> update(String id, Buy buy) {
        return this.buyRepository.findById(id)
                .flatMap(comp -> {
                    buy.setId(id);
                    return save(buy);
                }).switchIfEmpty(Mono.empty());
    }
}
