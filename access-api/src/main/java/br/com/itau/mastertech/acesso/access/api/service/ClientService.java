package br.com.itau.mastertech.acesso.access.api.service;

import br.com.itau.mastertech.acesso.access.api.model.ClientModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("client-api")
public interface ClientService {

    @GetMapping("/v1/clients/{id}")
    ClientModel findById(@PathVariable Integer id);
}
