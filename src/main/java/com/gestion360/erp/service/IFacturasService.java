package com.gestion360.erp.service;

import com.gestion360.erp.model.Facturas;

import java.util.List;
import java.util.Optional;

public interface IFacturasService {
    List<Facturas> listarTodas();
    Optional<Facturas> buscarPorId(Long id);
    Facturas guardar(Facturas factura);
    void borrar(Long id);
}
