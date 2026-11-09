package com.gestion360.erp.controller;

import com.gestion360.erp.model.Roles;
import com.gestion360.erp.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private IRolesService rolesService;

    @GetMapping
    public ResponseEntity<List<Roles>> getAll() {
        List<Roles> lista = rolesService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/id")
    public ResponseEntity<Roles> getById(@PathVariable Long id) {
        return rolesService.buscarPorId(id)
                .map(rol -> ResponseEntity.ok(rol))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Roles> create(@RequestBody Roles rol) {
        Roles nuevoRol = rolesService.guardar(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Roles> update(@PathVariable Long id, @RequestBody Roles rol) {
        return rolesService.buscarPorId(id)
                .map(rolExistente -> {
                    rol.setId_rol(id);
                    Roles actualizado = rolesService.guardar(rol);
                    return ResponseEntity.ok(actualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return rolesService.buscarPorId(id)
                .map(rol -> {
                    rolesService.eliminar(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
