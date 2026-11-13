package com.gestion360.erp.service;

import com.gestion360.erp.model.DetalleFactura;
import com.gestion360.erp.repository.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleFacturaServiceImpl implements IDetalleFacturaService{

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public List<DetalleFactura> listarTodas() {
        return detalleFacturaRepository.findAll();
    }

    @Override
    public Optional<DetalleFactura> buscarPorId(Long id) {
        return detalleFacturaRepository.findById(id);
    }

    @Override
    public DetalleFactura guardar(DetalleFactura detalleFactura) {
        return detalleFacturaRepository.save(detalleFactura);
    }

    @Override
    public void borrar(Long id) {
        detalleFacturaRepository.deleteById(id);
    }
}
