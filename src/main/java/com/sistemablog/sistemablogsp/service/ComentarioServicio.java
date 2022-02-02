package com.sistemablog.sistemablogsp.service;

import com.sistemablog.sistemablogsp.dto.ComentarioDTO;

import java.util.List;

public interface ComentarioServicio {
    public ComentarioDTO crearComentario(long publicacionId, ComentarioDTO comentarioDTO);
    public List<ComentarioDTO> obtenerComentariosPorPublicacionId(long publicacionId);
    public ComentarioDTO obtenerComentarioPorId(long publicacionId, long comentarioId);
    public ComentarioDTO actualizarComentario(Long publicacionId,  Long comentarioId ,ComentarioDTO solicitudComentario);
    public void eliminarComentario(Long publicacionId, Long comentarioId);
}
