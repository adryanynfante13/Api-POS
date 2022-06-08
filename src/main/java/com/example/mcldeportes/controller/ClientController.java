package com.example.mcldeportes.controller;
import com.example.mcldeportes.domain.Client;
import com.example.mcldeportes.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/client")
public class ClientController {
    private ClientService clientService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Client> save(@RequestBody Client client){
        return this.clientService.save(client);
    }

    @GetMapping("/list")
    private Flux<Client> findAllClient(){
        return this.clientService.findAll();
    }

    @GetMapping("/client/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Client> findClient(@PathVariable("id") String id){
        return this.clientService.findById(id);
    }

    @PutMapping("/update/{id}")
    private Mono<Client> updateClient(@PathVariable("id") String id, @RequestBody Client client){
        return this.clientService.update(id, client)
                .flatMap(Mono::just);
    }
    @DeleteMapping("/delete/{id}")
    private Mono<ResponseEntity<Client>> deleteCliente(@PathVariable("id") String id){
        return this.clientService.delete(id)
                .flatMap(c-> Mono.just(ResponseEntity.ok(c)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

}
