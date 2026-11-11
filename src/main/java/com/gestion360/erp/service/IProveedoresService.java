package com.gestion360.erp.service;

import com.gestion360.erp.model.Proveedores;

import java.util.List;
import java.util.Optional;

public interface IProveedoresService {
    List<Proveedores> listarTodos();

    Optional<Proveedores> buscarPorId();

    Proveedores guardat (Proveedores proveedor);

    void borrar (Long id);

}
