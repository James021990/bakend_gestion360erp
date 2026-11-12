package com.gestion360.erp.service;

import com.gestion360.erp.model.Productos;
import com.gestion360.erp.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosServiceImpl implements IProductosService{

    @Autowired
    ProductosRepository productosRepository;

    @Override
    public List<Productos> listarTodos() {

        return productosRepository.findAll();
    }

    @Override
    public Optional<Productos> buscarPorId(Long id) {

        return productosRepository.findById(id);
    }

    @Override
    public Productos guardar(Productos producto) {

        return productosRepository.save(producto);
    }

    @Override
    public void eliminar(Long id) {

        productosRepository.deleteById(id);
    }


}
