package com.gestion360.erp.service;

import com.gestion360.erp.model.Roles;

import java.util.List;
import java.util.Optional;

public interface IRolesService {
    List<Roles> listarTodos();
    Optional<Roles> buscarPorId(Long id);
    Roles guardar(Roles rol);
    void eliminar(Long id);
}
