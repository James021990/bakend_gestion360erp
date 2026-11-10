package com.gestion360.erp.service;

import com.gestion360.erp.model.Productos;

import java.util.List;
import java.util.Optional;

public interface IProductosService {
    List<Productos> listarTodos();
    Optional<Productos> buscarPorId(Long id);
    Productos guardar(Productos productos);
    void eliminar(Long id);
}
