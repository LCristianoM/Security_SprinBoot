package com.sistemablog.sistemablogsp.dto;

import com.sistemablog.sistemablogsp.model.Comentario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class PublicacionDTO {

    @Getter @Setter
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Titulo demasiado corto, debe contener al menos 2 caracteres")
    @Getter @Setter
    private String titulo;

    @NotEmpty
    @Size(min = 10, message = "Descripción de la publicación demasiado corta, debe contener al menos 10 caracteres")
    @Getter @Setter
    private String descripcion;

    @NotEmpty
    @Getter @Setter
    private String contenido;

    @Getter @Setter
    private Set<Comentario> comentarios;
}
