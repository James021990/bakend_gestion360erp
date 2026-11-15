package com.gestion360.erp.service;

import com.gestion360.erp.model.MovimientoInventario;

import java.util.List;
import java.util.Optional;

public interface IMovimientoInventarioService {
    List<MovimientoInventario> listarTodos();
    Optional<MovimientoInventario> buscarPorId(int id);
    MovimientoInventario guardar(MovimientoInventario movimientoInventario);
    void borrar(Long id);
}
