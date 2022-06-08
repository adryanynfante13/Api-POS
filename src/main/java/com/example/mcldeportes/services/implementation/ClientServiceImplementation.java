package com.example.mcldeportes.services.implementation;

import com.example.mcldeportes.domain.Client;
import com.example.mcldeportes.repository.ClientRepository;
import com.example.mcldeportes.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ClientServiceImplementation  implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    //guardar
    @Override
    public Mono<Client> save(Client client) {
        return this.clientRepository.save(client);
    }
    //listar todos
    @Override
    public Flux<Client> findAll() {
       return this.clientRepository.findAll();
    }
    //listar por id
    @Override
    public Mono<Client> findById(String id) {
        return this.clientRepository.findById(id);
    }

    //eliminar
    @Override
    public Mono<Client> delete(String id) {
        return this.clientRepository
                .findById(id)
                .flatMap(e -> this.clientRepository.deleteById(e.getId()).thenReturn(e));
    }

    @Override
    public Mono<Client> update(String id, Client client) {
        return this.clientRepository.findById(id)
                .flatMap(e -> {
                    client.setId(id);
                    return save(client);
                }).switchIfEmpty(Mono.empty());
    }
}
