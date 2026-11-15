package com.gestion360.erp.service;

import com.gestion360.erp.model.MovimientoInventario;
import com.gestion360.erp.repository.MovimientoInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoInventarioServiceImpl implements IMovimientoInventarioService {

    @Autowired
    MovimientoInventarioRepository movimientoInventarioRepository;

    @Override
    public List<MovimientoInventario> listarTodos() {
        return movimientoInventarioRepository.findAll();
    }

    @Override
    public Optional<MovimientoInventario> buscarPorId(Long id) {
        return movimientoInventarioRepository.findById(id);
    }

    @Override
    public MovimientoInventario guardar(MovimientoInventario movimientoInventario) {
        return movimientoInventarioRepository.save(movimientoInventario);
    }

    @Override
    public void borrar(Long id) {
        movimientoInventarioRepository.deleteById(id);
    }
}
