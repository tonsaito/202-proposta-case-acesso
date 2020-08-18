package br.com.itau.mastertech.acesso.access.api.service.fallback;

import br.com.itau.mastertech.acesso.access.api.exception.ServiceNotAvailableException;
import br.com.itau.mastertech.acesso.access.api.model.ClientModel;
import br.com.itau.mastertech.acesso.access.api.service.ClientService;
import com.netflix.client.ClientException;
import feign.RetryableException;

public class ClientServiceFallback implements ClientService {

    private Exception exception;

    public ClientServiceFallback(Exception e){
        this.exception = e;

    }

    @Override
    public ClientModel findById(Integer id) {
        if(exception.getCause() instanceof ClientException){
            throw new ServiceNotAvailableException("Service not available");
        } else if(exception.getCause() instanceof RetryableException){
            throw new ServiceNotAvailableException("Service not available");
        }
        throw (RuntimeException) exception;
    }
}
