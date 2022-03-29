package com.example.prueba.exception;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestLog {

    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();
    private String trace;
    private List<String> span;
    private String mensaje;

    public RequestLog(String trace, List<String> span, String mensaje) {
        this.trace = trace;
        this.span = span;
        this.mensaje = mensaje;
    }
}