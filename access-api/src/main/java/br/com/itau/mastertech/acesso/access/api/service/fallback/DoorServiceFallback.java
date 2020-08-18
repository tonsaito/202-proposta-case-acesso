package br.com.itau.mastertech.acesso.access.api.service.fallback;

import br.com.itau.mastertech.acesso.access.api.exception.ServiceNotAvailableException;
import br.com.itau.mastertech.acesso.access.api.model.ClientModel;
import br.com.itau.mastertech.acesso.access.api.model.DoorModel;
import br.com.itau.mastertech.acesso.access.api.service.ClientService;
import br.com.itau.mastertech.acesso.access.api.service.DoorService;
import com.netflix.client.ClientException;
import feign.RetryableException;

public class DoorServiceFallback implements DoorService {

    private Exception exception;

    public DoorServiceFallback(Exception e){
        this.exception = e;
    }

    @Override
    public DoorModel findById(Integer id) {
        if(exception.getCause() instanceof ClientException){
            throw new ServiceNotAvailableException("Service not available");
        } else if(exception.getCause() instanceof RetryableException){
            throw new ServiceNotAvailableException("Service not available");
        }
        throw (RuntimeException) exception;
    }
}
