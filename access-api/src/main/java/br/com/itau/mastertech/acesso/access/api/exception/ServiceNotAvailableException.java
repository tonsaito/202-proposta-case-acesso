package br.com.itau.mastertech.acesso.access.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY)
public class ServiceNotAvailableException extends RuntimeException{

    public ServiceNotAvailableException(String message){
        super(message);
    }
}
