package com.bc48.mscliente.service;

import com.bc48.mscliente.document.Client;
import reactor.core.publisher.Mono;

public interface ClientService {
    Mono<Client> save(Mono<Client> client);
    Mono<Client> findById(String id);
    Mono<Client> update(String id, Mono<Client> client);
    Mono<Void> delete(Client client);
}