package br.com.itau.mastertech.acesso.door.api.service.impl;

import br.com.itau.mastertech.acesso.door.api.entity.DoorEntity;
import br.com.itau.mastertech.acesso.door.api.exception.DoorNotFoundException;
import br.com.itau.mastertech.acesso.door.api.repository.DoorRepository;
import br.com.itau.mastertech.acesso.door.api.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoorServiceImpl implements DoorService {

    @Autowired
    private DoorRepository doorRepository;

    @Override
    public DoorEntity save(DoorEntity doorEntity) {
        return doorRepository.save(doorEntity);
    }

    @Override
    public DoorEntity findById(Integer id) {
        return doorRepository.findById(id).orElseThrow(() -> new DoorNotFoundException("Door not found"));
    }
}
