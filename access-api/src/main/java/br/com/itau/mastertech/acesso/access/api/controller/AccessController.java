package br.com.itau.mastertech.acesso.access.api.controller;

import br.com.itau.mastertech.acesso.access.api.entity.AccessEntity;
import br.com.itau.mastertech.acesso.access.api.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccessController {

    @Autowired
    private AccessService accessService;

    @PostMapping("/v1/access")
    public ResponseEntity<AccessEntity> saveAccessV1(@RequestBody AccessEntity accessEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(accessService.save(accessEntity));
    }

    @DeleteMapping("/v1/access/{clientId}/{doorId}")
    public ResponseEntity<Object> deleteAccessByClientIdAndDoorIdV1(@PathVariable Integer clientId, @PathVariable Integer doorId){
        accessService.deleteByClientIdCardId(clientId, doorId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/v1/access/{clientId}/{doorId}")
    public AccessEntity getAccessByClientIdDoorIdV1(@PathVariable Integer clientId, @PathVariable Integer doorId){
        return accessService.findByClientIdCardId(clientId, doorId);
    }

}
