package com.gestion360.erp.service;

import com.gestion360.erp.model.Compras;
import com.gestion360.erp.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComprasServiceImpl implements IComprasService {

    @Autowired
    private ComprasRepository comprasRepository;

    @Override
    public List<Compras> listarTodas() {
        return comprasRepository.findAll();
    }

    @Override
    public Optional<Compras> buscarPorId(Long id) {
        return comprasRepository.findById(id);
    }

    @Override
    public Compras guardar(Compras compra) {
        return comprasRepository.save(compra);
    }

    @Override
    public void borrar(Long id) {
        comprasRepository.deleteById(id);
    }
}
