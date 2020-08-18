package br.com.itau.mastertech.acesso.door.api.controller;

import br.com.itau.mastertech.acesso.door.api.entity.DoorEntity;
import br.com.itau.mastertech.acesso.door.api.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoorController {

    @Autowired
    private DoorService doorService;

    @PostMapping("/v1/doors")
    public ResponseEntity<DoorEntity> saveDoorV1(@RequestBody DoorEntity doorEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(doorService.save(doorEntity));
    }

    @GetMapping("/v1/doors/{id}")
    public DoorEntity getDoorByIdV1(@PathVariable Integer id){
        return doorService.findById(id);
    }
}
