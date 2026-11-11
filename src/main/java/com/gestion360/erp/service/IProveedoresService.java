package com.gestion360.erp.service;

import com.gestion360.erp.model.Proveedores;

import java.util.List;
import java.util.Optional;

public interface IProveedoresService {
    List<Proveedores> listarTodos();

    Optional<Proveedores> buscarPorId(Long id);

    Proveedores guardar (Proveedores proveedor);

    void eliminar (Long id);

}
