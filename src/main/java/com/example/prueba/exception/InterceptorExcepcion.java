package com.example.prueba.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class InterceptorExcepcion extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex,
            WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        RequestLog log = new RequestLog(ex.getLocalizedMessage(), details, ex.getMessage());
        return new ResponseEntity<Object>(log, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RecursoNoEncontradoExcepcion.class)
    public final ResponseEntity<Object> handleUserNotFoundException(RecursoNoEncontradoExcepcion ex,
            WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        RequestLog log = new RequestLog("Recurso no encontrado", details, ex.getMessage());
        return new ResponseEntity<Object>(log, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RecursoDuplicadoException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(RecursoDuplicadoException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        RequestLog log = new RequestLog("Recurso con conflicto", details, ex.getMessage());
        return new ResponseEntity<Object>(log, HttpStatus.CONFLICT);
    }

}
