package com.sistemablog.sistemablogsp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends RuntimeException{
    @Getter @Setter
    private String nombreRecurso;
    @Getter @Setter
    private String nombreCampo;
    @Getter @Setter
    private long valorCampo;

    public ResourceNotFoundException(String nombreRecurso, String nombreCampo, long valorCampo) {
        super(String.format("%s No encontrado con: %s : '%s'", nombreRecurso, nombreCampo, valorCampo));
        this.nombreRecurso = nombreRecurso;
        this.nombreCampo = nombreCampo;
        this.valorCampo = valorCampo;
    }
}
