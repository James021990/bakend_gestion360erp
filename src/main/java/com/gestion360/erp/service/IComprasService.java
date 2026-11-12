package com.gestion360.erp.service;

import com.gestion360.erp.model.Compras;

import java.util.List;
import java.util.Optional;

public interface IComprasService {
    List<Compras> listarTodas();
    Optional<Compras> buscarPorId(Long id);
    Compras guardar(Compras compra);
    void borrar(Long id);
}
