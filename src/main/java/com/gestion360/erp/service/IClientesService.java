package com.gestion360.erp.service;

import com.gestion360.erp.model.Clientes;

import java.util.List;
import java.util.Optional;

public interface IClientesService {
    List<Clientes> listarTodos();
    Optional<Clientes> buscarPorId(Long id);
    Clientes guardar(Clientes cliente);
    void borrar(Long id);
}
