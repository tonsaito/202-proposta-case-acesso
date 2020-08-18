package br.com.itau.mastertech.acesso.access.api.service;

import br.com.itau.mastertech.acesso.access.api.model.ClientModel;
import br.com.itau.mastertech.acesso.access.api.model.DoorModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("door-api")
public interface DoorService {

    @GetMapping("/v1/doors/{id}")
    DoorModel findById(@PathVariable Integer id);
}
