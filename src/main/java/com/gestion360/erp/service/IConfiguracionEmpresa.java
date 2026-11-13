package com.gestion360.erp.service;

import com.gestion360.erp.model.ConfiguracionEmpresa;

import java.util.List;
import java.util.Optional;

public interface IConfiguracionEmpresa {
    List<ConfiguracionEmpresa> listarTodos();
    Optional<ConfiguracionEmpresa> buscarPorId(Long id);
    ConfiguracionEmpresa guardar(ConfiguracionEmpresa configuracionEmpresa);
    void borrar(ConfiguracionEmpresa configuracionEmpresa);
}
