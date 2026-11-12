package com.gestion360.erp.controller;

import com.gestion360.erp.model.Proveedores;
import com.gestion360.erp.service.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresController {
    @Autowired
    private IProveedoresService proveedoresService;

    @GetMapping
    public ResponseEntity<List<Proveedores>> getAll() {
        List<Proveedores> lista = proveedoresService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedores> getById(@PathVariable Long id) {
        return proveedoresService.buscarPorId(id)
                .map(proveedor -> ResponseEntity.ok(proveedor))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Proveedores> create(@RequestBody Proveedores proveedores) {
        Proveedores nuevoProveedor = proveedoresService.guardar(proveedores);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProveedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedores> update(@PathVariable Long id, @RequestBody Proveedores proveedor) {
        return proveedoresService.buscarPorId(id)
                .map(proveedorExistente -> {
                    proveedor.setId_proveedores(id);
                    Proveedores actualizado = proveedoresService.guardar(proveedor);
                    return ResponseEntity.ok(actualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return proveedoresService.buscarPorId(id)
                .map(proveedor ->{
                    proveedoresService.eliminar(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}
