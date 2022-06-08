package com.example.mcldeportes.controller;

import com.example.mcldeportes.domain.Buy;
import com.example.mcldeportes.services.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/buy")
public class BuyController {

    private BuyService buyService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<ResponseEntity<Buy>> save(@RequestBody Buy buy){
        return this.buyService.save(buy)
                .flatMap( b -> Mono.just(ResponseEntity.ok(b))
                .switchIfEmpty(Mono.just(ResponseEntity.badRequest().build())));
    }

    @GetMapping("/list")
    private Flux<Buy> findAllCompras(){
        return this.buyService.findAll();
    }

    @PutMapping("/update/{id}")
    private Mono<Buy> updateCliente(@PathVariable("id") String id, @RequestBody Buy buy){
        return this.buyService.update(id, buy)
                .flatMap(Mono::just);
    }

    @DeleteMapping("/delete/{id}")
    private Mono<ResponseEntity<Buy>> deleteCliente(@PathVariable("id") String id){
        return this.buyService.delete(id)
                .flatMap(b -> Mono.just(ResponseEntity.ok(b)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

}
