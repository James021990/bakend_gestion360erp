package com.gestion360.erp.service;

import com.gestion360.erp.model.Usuarios;
import com.gestion360.erp.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements IUsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> listarTodos() {
        return usuariosRepository.findAll();
    }

    @Override
    public Optional<Usuarios> buscarPorId(Long id) {
        return usuariosRepository.findById(id);
    }

    @Override
    public Usuarios guardar(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        usuariosRepository.deleteById(id);
    }
}
