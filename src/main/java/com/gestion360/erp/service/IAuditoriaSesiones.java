package com.gestion360.erp.service;

import com.gestion360.erp.model.AuditoriaSesiones;

import java.util.List;
import java.util.Optional;

public interface IAuditoriaSesiones {
    List<AuditoriaSesiones> listartTodos();
    Optional<AuditoriaSesiones> buscarPorId(Long id);
    AuditoriaSesiones guardar(AuditoriaSesiones auditoriaSesiones);
    void borrar(AuditoriaSesiones auditoriaSesiones);
}
