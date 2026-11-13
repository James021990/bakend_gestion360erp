package com.gestion360.erp.controller;

import com.gestion360.erp.model.DetalleFactura;
import com.gestion360.erp.service.IDetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle_factura")
public class DetalleFacturaController {

    @Autowired
    private IDetalleFacturaService detalleFacturaService;

    @GetMapping
    public ResponseEntity<List<DetalleFactura>> getAll(){
        List<DetalleFactura> lista = detalleFacturaService.listarTodas();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleFactura> getById(@PathVariable Long id){
        return detalleFacturaService.buscarPorId(id)
                .map(detalleFactura -> ResponseEntity.ok(detalleFactura))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DetalleFactura> create(@RequestBody DetalleFactura detalleFactura){
        DetalleFactura nuevaDetalleFactura = detalleFacturaService.guardar(detalleFactura);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaDetalleFactura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleFactura> update(@PathVariable Long id, @RequestBody DetalleFactura detalleFactura){
        return detalleFacturaService.buscarPorId(id)
                .map(detalleFacturaExistente ->{
                    detalleFactura.setId_detalle_factura(id);
                    DetalleFactura actualizada = detalleFacturaService.guardar(detalleFactura);
                    return ResponseEntity.ok(actualizada);
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return detalleFacturaService.buscarPorId(id)
                .map(detalleFactura ->{
                    detalleFacturaService.borrar(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}
