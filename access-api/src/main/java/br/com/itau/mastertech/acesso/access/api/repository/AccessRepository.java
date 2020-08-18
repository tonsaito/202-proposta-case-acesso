package br.com.itau.mastertech.acesso.access.api.repository;

import br.com.itau.mastertech.acesso.access.api.entity.AccessEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends CrudRepository<AccessEntity, Integer> {

    @Query("SELECT a FROM AccessEntity a WHERE a.clientId = ?1 AND a.doorId = ?2")
    AccessEntity findByClientIdAndDoorId(Integer clientId, Integer doorId);

    @Query("DELETE FROM AccessEntity a WHERE a.clientId = ?1 AND a.doorId = ?2")
    void deleteByClientIdAndDoorId(Integer clientId, Integer doorId);
}
