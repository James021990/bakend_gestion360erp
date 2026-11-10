package com.gestion360.erp.service;

import com.gestion360.erp.model.Categorias;
import com.gestion360.erp.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasServiceImpl implements ICategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepository;

    @Override
    public List<Categorias> listarTodas() {
        return categoriasRepository.findAll();
    }

    @Override
    public Optional<Categorias> buscarPorId(Long id) {
        return categoriasRepository.findById(id);
    }

    @Override
    public Categorias guardar(Categorias categoria) {
        return categoriasRepository.save(categoria);
    }

    @Override
    public void borrar(Long id) {
        categoriasRepository.deleteById(id);
    }
}
