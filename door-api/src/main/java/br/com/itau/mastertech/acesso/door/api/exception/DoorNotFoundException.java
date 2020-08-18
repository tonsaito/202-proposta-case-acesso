package br.com.itau.mastertech.acesso.door.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DoorNotFoundException extends RuntimeException{

    public DoorNotFoundException(String message){
        super(message);
    }
}
