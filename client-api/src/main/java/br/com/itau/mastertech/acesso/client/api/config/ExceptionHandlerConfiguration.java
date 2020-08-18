package br.com.itau.mastertech.acesso.client.api.config;

import br.com.itau.mastertech.acesso.client.api.exception.ClientNotFoundException;
import br.com.itau.mastertech.acesso.client.api.model.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerConfiguration extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ClientNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(
            RuntimeException ex, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(httpStatus).body(getExceptionModel(httpStatus, ex, request));
    }

    private ExceptionModel getExceptionModel(HttpStatus httpStatus, RuntimeException ex, WebRequest request){
        ExceptionModel exceptionModel = new ExceptionModel();
        exceptionModel.setTimestamp(LocalDateTime.now());
        exceptionModel.setStatus(httpStatus.value());
        exceptionModel.setError(httpStatus.getReasonPhrase());
        exceptionModel.setMessage(ex.getMessage());
        exceptionModel.setPath(((ServletWebRequest)request).getRequest().getRequestURI().toString());
        return exceptionModel;
    }
}
