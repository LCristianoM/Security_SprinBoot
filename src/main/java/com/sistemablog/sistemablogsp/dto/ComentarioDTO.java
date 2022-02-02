package com.sistemablog.sistemablogsp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioDTO {

    private long id;

    @NotEmpty(message = "El campo de nombre es obligatorio, no puede estar vacio!")
    private String nombre;

    @NotEmpty(message = "El campo de email es obligatorio, no puede estar vacio o nulo!")
    @Email
    private String email;

    @NotEmpty()
    @Size(min = 10, message = "El cuerpo del comentario debe por lo menos contener 10 caracteres!")
    private String cuerpo;
}
