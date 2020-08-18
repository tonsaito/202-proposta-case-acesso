package br.com.itau.mastertech.acesso.access.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AccessNotFoundException extends RuntimeException{

    public AccessNotFoundException(String message){
        super(message);
    }
}
