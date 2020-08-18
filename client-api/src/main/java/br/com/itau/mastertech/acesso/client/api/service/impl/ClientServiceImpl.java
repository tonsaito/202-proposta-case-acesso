package br.com.itau.mastertech.acesso.client.api.service.impl;

import br.com.itau.mastertech.acesso.client.api.entity.ClientEntity;
import br.com.itau.mastertech.acesso.client.api.exception.ClientNotFoundException;
import br.com.itau.mastertech.acesso.client.api.repository.ClientRepository;
import br.com.itau.mastertech.acesso.client.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public ClientEntity save(ClientEntity clientEntity) {
        return repository.save(clientEntity);
    }

    @Override
    public ClientEntity findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client not found"));
    }
}
