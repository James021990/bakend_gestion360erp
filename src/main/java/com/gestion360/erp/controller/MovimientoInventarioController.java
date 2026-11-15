package com.gestion360.erp.controller;

import com.gestion360.erp.model.MovimientoInventario;
import com.gestion360.erp.service.IMovimientoInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimiento_inventario")
public class MovimientoInventarioController {

    @Autowired
    private IMovimientoInventarioService movimientoInventarioService;

    @GetMapping
    public ResponseEntity<List<MovimientoInventario>> getAll() {
        List<MovimientoInventario> lista = movimientoInventarioService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoInventario> getById(@PathVariable Long id) {
        return movimientoInventarioService.buscarPorId(id)
                .map(movimientoIventario -> ResponseEntity.ok(movimientoIventario))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MovimientoInventario> create(@RequestBody MovimientoInventario movimientoInventario) {
        MovimientoInventario nuevoMovimientoInventario = movimientoInventarioService.guardar(movimientoInventario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMovimientoInventario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimientoInventario> update(@PathVariable Long id, @RequestBody MovimientoInventario movimientoInventario) {
        return movimientoInventarioService.buscarPorId(id)
                .map(movimientoInventarioExistente ->{
                    movimientoInventario.setId_movimiento_inventario(id);
                    MovimientoInventario actualizada = movimientoInventarioService.guardar(movimientoInventario);
                    return ResponseEntity.ok(actualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return movimientoInventarioService.buscarPorId(id)
                .map(movimientoInventario ->{
                    movimientoInventarioService.borrar(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
