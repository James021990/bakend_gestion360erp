package com.gestion360.erp.service;

import com.gestion360.erp.model.AuditoriaSesiones;
import com.gestion360.erp.repository.AuditoriaSesionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditoriaSesionesServiceImpl implements IAuditoriaSesiones{

    @Autowired
    AuditoriaSesionesRepository auditoriaSesionesRepository;

    @Override
    public List<AuditoriaSesiones> listartTodos() {
        return auditoriaSesionesRepository.findAll();
    }

    @Override
    public Optional<AuditoriaSesiones> buscarPorId(Long id) {
        return auditoriaSesionesRepository.findById(id);
    }

    @Override
    public AuditoriaSesiones guardar(AuditoriaSesiones auditoriaSesiones) {
        return auditoriaSesionesRepository.save(auditoriaSesiones);
    }

    @Override
    public void borrar(Long id) {
        auditoriaSesionesRepository.deleteById(id);

    }
}
