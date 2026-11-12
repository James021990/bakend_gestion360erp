package com.gestion360.erp.service;

import com.gestion360.erp.model.DetalleFactura;

import java.util.List;
import java.util.Optional;

public interface IDetalleFacturaService {
    List<DetalleFactura> listarTodas();
    Optional<DetalleFactura> buscarPorId(Long id);
    DetalleFactura guardar(DetalleFactura detalleFactura);
    void borrar(Long id);
}
