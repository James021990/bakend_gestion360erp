package com.gestion360.erp.controller;

import com.gestion360.erp.model.Categorias;
import com.gestion360.erp.service.ICategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

    @Autowired
    private ICategoriasService categoriasService;

    @GetMapping
    public ResponseEntity<List<Categorias>> getAll() {
        List<Categorias> lista = categoriasService.listarTodas();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorias> getById(@PathVariable Long id){
        return categoriasService.buscarPorId(id)
                .map(categoria -> ResponseEntity.ok(categoria))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Categorias> create(@RequestBody Categorias categoria){
        Categorias nuevaCategoria = categoriasService.guardar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorias> update(@PathVariable Long id, @RequestBody Categorias categorias){
        return categoriasService.buscarPorId(id)
                .map(categoriaExistente -> {
                    categorias.setId_categoria(id);
                    Categorias actualizada = categoriasService.guardar(categorias);
                    return ResponseEntity.ok(actualizada);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return categoriasService.buscarPorId(id)
                .map(categorias -> {
                    categoriasService.borrar(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
