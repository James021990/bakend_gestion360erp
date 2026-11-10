package com.gestion360.erp.service;

import com.gestion360.erp.model.Categorias;

import java.util.List;
import java.util.Optional;

public interface ICategoriasService {
    List<Categorias> listarTodas();
    Optional<Categorias> buscarPorId(Long id);
    Categorias guardar(Categorias categoria);
    void borrar(Long id);
}
