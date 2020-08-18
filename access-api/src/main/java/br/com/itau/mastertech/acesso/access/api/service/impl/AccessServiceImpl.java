package br.com.itau.mastertech.acesso.access.api.service.impl;

import br.com.itau.mastertech.acesso.access.api.entity.AccessEntity;
import br.com.itau.mastertech.acesso.access.api.exception.AccessNotFoundException;
import br.com.itau.mastertech.acesso.access.api.repository.AccessRepository;
import br.com.itau.mastertech.acesso.access.api.service.AccessService;
import br.com.itau.mastertech.acesso.access.api.service.ClientService;
import br.com.itau.mastertech.acesso.access.api.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccessServiceImpl implements AccessService {

    @Autowired
    private AccessRepository accessRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private DoorService doorService;

    @Override
    public AccessEntity save(AccessEntity accessEntity) {
        checkClienBytId(accessEntity.getClientId());
        checkDoorById(accessEntity.getDoorId());
        return accessRepository.save(accessEntity);
    }

    @Override
    public AccessEntity findByClientIdCardId(Integer clientId, Integer doorId) {
        AccessEntity access = accessRepository.findByClientIdAndDoorId(clientId, doorId);
        if(access == null){
            throw new AccessNotFoundException("Access not found");
        }
        return access;
    }

    @Override
    public void deleteByClientIdCardId(Integer clientId, Integer doorId) {
        AccessEntity access = accessRepository.findByClientIdAndDoorId(clientId, doorId);
        if(access == null){
            throw new AccessNotFoundException("Access not found");
        }
        accessRepository.delete(access);
    }

    private void checkClienBytId(Integer clientId){
        clientService.findById(clientId);
    }

    private void checkDoorById(Integer doorId){
        doorService.findById(doorId);
    }
}
