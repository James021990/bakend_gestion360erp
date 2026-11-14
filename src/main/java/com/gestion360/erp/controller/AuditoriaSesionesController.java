package com.gestion360.erp.controller;

import com.gestion360.erp.model.AuditoriaSesiones;
import com.gestion360.erp.service.IAuditoriaSesiones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auditoria_sesiones")
public class AuditoriaSesionesController {

    @Autowired
    private IAuditoriaSesiones auditoriaSesion;

    @GetMapping
    public ResponseEntity<List<AuditoriaSesiones>> getAll(){
        List<AuditoriaSesiones> lista = auditoriaSesion.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditoriaSesiones> getById(@PathVariable Long id){
        return auditoriaSesion.buscarPorId(id)
                .map(auditoriaSesion ->ResponseEntity.ok(auditoriaSesion))
                .orElse(ResponseEntity.notFound().build());
    }

   @PostMapping
    public ResponseEntity<AuditoriaSesiones> create(@RequestBody AuditoriaSesiones auditoriaSesiones){
        AuditoriaSesiones nuevaAuditoriaSesion = auditoriaSesion.guardar(auditoriaSesiones);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaAuditoriaSesion);
   }

   @PutMapping("/{id}")
    public ResponseEntity<AuditoriaSesiones> uptade(@PathVariable Long id, @RequestBody AuditoriaSesiones auditoriaSesiones){
        return auditoriaSesion.buscarPorId(id)
                .map(auditoriaSesionExistente ->{
                    auditoriaSesiones.setId_auditoria_sesiones(id);
                    AuditoriaSesiones actualizada =  auditoriaSesion.guardar(auditoriaSesiones);
                    return ResponseEntity.ok(actualizada);
                })
                .orElse(ResponseEntity.notFound().build());
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return auditoriaSesion.buscarPorId(id)
                .map(auditoriaSesiones -> {
                    auditoriaSesion.borrar(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
   }
}
