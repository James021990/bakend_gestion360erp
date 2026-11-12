package com.gestion360.erp.controller;

import com.gestion360.erp.model.Compras;
import com.gestion360.erp.service.IComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class ComprasController {

    @Autowired
    private IComprasService comprasService;

    @GetMapping
    public ResponseEntity<List<Compras>> getAll() {
        List<Compras> lista = comprasService.listarTodas();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compras> getById(@PathVariable Long id) {
        return comprasService.buscarPorId(id)
                .map(compra -> ResponseEntity.ok(compra))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Compras> create(@RequestBody Compras compras) {
        Compras nuevaCompra = comprasService.guardar(compras);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCompra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compras> update(@PathVariable Long id, @RequestBody Compras compra) {
        return comprasService.buscarPorId(id)
                .map(compraExistente ->{
                    compra.setId_compra(id);
                    Compras actualizada = comprasService.guardar(compra);
                    return ResponseEntity.ok(actualizada);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return comprasService.buscarPorId(id)
                .map(compra ->{
                    comprasService.buscarPorId(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
