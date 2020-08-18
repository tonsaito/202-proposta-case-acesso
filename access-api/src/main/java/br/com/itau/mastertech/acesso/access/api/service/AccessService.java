package br.com.itau.mastertech.acesso.access.api.service;

import br.com.itau.mastertech.acesso.access.api.entity.AccessEntity;

public interface AccessService {
    AccessEntity save(AccessEntity accessEntity);
    AccessEntity findByClientIdCardId(Integer clientId, Integer doorId);
    void deleteByClientIdCardId(Integer clientId, Integer doorId);
}
