package br.com.itau.mastertech.acesso.client.api.service;

import br.com.itau.mastertech.acesso.client.api.entity.ClientEntity;

import java.util.Iterator;

public interface ClientService {

    ClientEntity save(ClientEntity clientEntity);
    ClientEntity findById(Integer id);

}
