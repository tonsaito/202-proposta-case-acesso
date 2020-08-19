package br.com.itau.mastertech.acesso.access.api.model.wrapper;

import br.com.itau.mastertech.acesso.access.api.entity.AccessEntity;
import br.com.itau.mastertech.acesso.access.api.model.AccessModel;

public class AccessWrapper {

    private AccessWrapper(){

    }

    public static AccessModel toAccessModel(AccessEntity accessEntity){
        return new AccessModel(accessEntity.getClientId(), accessEntity.getDoorId(), Math.random() < 0.5);
    }
}
