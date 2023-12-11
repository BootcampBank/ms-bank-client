package com.bc48.mscliente.service;

import com.bc48.mscliente.document.Client;
import com.bc48.mscliente.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Mono<Client> save(Mono<Client> client) {
        return client.flatMap(clientRepository::insert);
    }

    @Override
    public Mono<Client> findById(String id) {
        return clientRepository.findById(id);
    }

    @Override
    public Mono<Client> update(String id, Mono<Client> client) {
        return clientRepository.findById(id)
                .flatMap(c -> client)
                .doOnNext(e -> e.setId(id))
                .flatMap(clientRepository::save);
    }

    @Override
    public Mono<Void> delete(Client client) {
        return clientRepository.delete(client);
    }
}
