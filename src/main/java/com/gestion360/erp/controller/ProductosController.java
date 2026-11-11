package com.gestion360.erp.controller;

import com.gestion360.erp.model.Productos;
import com.gestion360.erp.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {
    @Autowired
    private IProductosService productosService;

    @GetMapping
    public ResponseEntity<List<Productos>> getAll(){
        List<Productos> lista = productosService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productos> getById(@PathVariable Long id){
        return productosService.buscarPorId(id)
                .map(producto -> ResponseEntity.ok(producto))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Productos> create(@RequestBody Productos productos){
        Productos nuevoProducto = productosService.guardar(productos);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productos> update(@PathVariable Long id, @RequestBody Productos producto){
        return productosService.buscarPorId(id)
                .map(productoExistente ->{
                        producto.setId_productos(id);
                        Productos actualizado = productosService.guardar(producto);
                        return ResponseEntity.ok(actualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return productosService.buscarPorId(id)
                .map(producto ->{
                    productosService.eliminar(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
