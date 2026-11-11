package com.gestion360.erp.service;

import com.gestion360.erp.model.Proveedores;
import com.gestion360.erp.repository.ProveedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class ProveedoresServiceImpl implements IProveedoresService{

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    @Override
    public List<Proveedores> listarTodos() {
        return proveedoresRepository.findAll();
    }

    @Override
    public Optional<Proveedores> buscarPorId(Long id) {
        return proveedoresRepository.findById(id);
    }


    @Override
    public Proveedores guardar(Proveedores proveedor) {
        return proveedoresRepository.save(proveedor);
    }

    @Override
    public void eliminar(Long id) {
        proveedoresRepository.deleteById(id);

    }
}
