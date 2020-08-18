package br.com.itau.mastertech.acesso.client.api.controller;

import br.com.itau.mastertech.acesso.client.api.entity.ClientEntity;
import br.com.itau.mastertech.acesso.client.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/v1/clients")
    public ResponseEntity<ClientEntity> saveClientV1(@RequestBody ClientEntity clientEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientEntity));
    }

    @GetMapping("/v1/clients/{id}")
    public ClientEntity getClientByIdV1(@PathVariable Integer id){
        return clientService.findById(id);
    }
}
