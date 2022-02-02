package com.sistemablog.sistemablogsp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="publicaciones", uniqueConstraints = {@UniqueConstraint(columnNames = {"titulo"})})
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo" , nullable = false)
    private String titulo;

    @Column(name = "descripcion" , nullable = false)
    private String descripcion;

    @Column(name = "contenido" , nullable = false)
    private String contenido;

    @JsonBackReference //para evitar la repeticion infinita de datos ...ERROR, corrige error de recursion infinita por referencias bidireccionales
    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)//al eliminar una publicacion se eliminará en cascada todos los comentarios que esta contenga
    private Set<Comentario> comentarios = new HashSet<>();

}
