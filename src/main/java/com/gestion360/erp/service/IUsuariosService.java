package com.gestion360.erp.service;

import com.gestion360.erp.model.Usuarios;

import java.util.List;
import java.util.Optional;

public interface IUsuariosService {
    List<Usuarios> listarTodos();
    Optional<Usuarios> buscarPorId(Long id);
    Usuarios guardar (Usuarios usuario);
    void eliminar(Long id);
}
