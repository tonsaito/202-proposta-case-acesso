package br.com.itau.mastertech.acesso.door.api.repository;

import br.com.itau.mastertech.acesso.door.api.entity.DoorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoorRepository extends CrudRepository<DoorEntity,Integer> {
}
