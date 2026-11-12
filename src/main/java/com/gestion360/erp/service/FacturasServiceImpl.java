package com.gestion360.erp.service;

import com.gestion360.erp.model.Facturas;
import com.gestion360.erp.repository.FacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturasServiceImpl implements IFacturasService {

    @Autowired
    private FacturasRepository facturasRepository;

    @Override
    public List<Facturas> listarTodas() {
        return facturasRepository.findAll();
    }

    @Override
    public Optional<Facturas> buscarPorId(Long id) {
        return facturasRepository.findById(id);
    }

    @Override
    public Facturas guardar(Facturas factura) {
        return facturasRepository.save(factura);
    }

    @Override
    public void borrar(Long id) {
        facturasRepository.deleteById(id);
    }
}
