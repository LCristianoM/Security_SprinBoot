package com.sistemablog.sistemablogsp.repository;

import com.sistemablog.sistemablogsp.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepositorio extends JpaRepository<Comentario, Long> {

    public List<Comentario> findByPublicacionId(long publicacionId);
}
