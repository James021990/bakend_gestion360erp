package com.gestion360.erp.service;

import com.gestion360.erp.model.Roles;
import com.gestion360.erp.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesServiceImpl implements IRolesService{

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public List<Roles> listarTodos() {
        return rolesRepository.findAll();
    }

    @Override
    public Optional<Roles> buscarPorId(Long id) {
        return rolesRepository.findById(id);
    }

    @Override
    public Roles guardar(Roles rol) {
        return rolesRepository.save(rol);
    }

    @Override
    public void eliminar(Long id) {
        rolesRepository.deleteById(id);
    }
}
