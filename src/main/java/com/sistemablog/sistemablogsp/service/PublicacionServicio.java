package com.sistemablog.sistemablogsp.service;

import com.sistemablog.sistemablogsp.dto.PublicacionDTO;
import com.sistemablog.sistemablogsp.dto.PublicacionRespuesta;

public interface PublicacionServicio {

    public PublicacionDTO crearPublicacion(PublicacionDTO publicacionDTO);
    public PublicacionRespuesta obtenerTodasLasPublicaciones(int numeroPagina, int medidaPagina, String ordenarPor, String sortDir);
    public PublicacionDTO obtenerPublicacionPorId(long id);
    public PublicacionDTO actualizarPublicacion(PublicacionDTO publicacionDTO, long id);
    public void eliminarPublicacion(long id);
}
