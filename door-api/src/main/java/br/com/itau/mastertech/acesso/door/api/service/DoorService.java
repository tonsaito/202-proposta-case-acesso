package br.com.itau.mastertech.acesso.door.api.service;

import br.com.itau.mastertech.acesso.door.api.entity.DoorEntity;

public interface DoorService{
    DoorEntity save(DoorEntity doorEntity);
    DoorEntity findById(Integer id);
}
