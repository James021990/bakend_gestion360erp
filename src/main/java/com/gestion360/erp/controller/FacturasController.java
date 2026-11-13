package com.gestion360.erp.controller;

import com.gestion360.erp.model.Facturas;
import com.gestion360.erp.service.IFacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturasController {

    @Autowired
    private IFacturasService facturasService;

    @GetMapping
    public ResponseEntity<List<Facturas>> getAll(){
        List<Facturas> lista = facturasService.listarTodas();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facturas> getById(@PathVariable Long id){
        return facturasService.buscarPorId(id)
                .map(factura -> ResponseEntity.ok(factura))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Facturas> create(@RequestBody Facturas factura){
        Facturas NuevaFactura = facturasService.guardar(factura);
        return ResponseEntity.status(HttpStatus.CREATED).body(NuevaFactura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facturas> update(@PathVariable Long id, @RequestBody Facturas factura){
        return facturasService.buscarPorId(id)
                .map(facturaExistente ->{
                    factura.setId_factura(id);
                    Facturas actualizada = facturasService.guardar(factura);
                    return ResponseEntity.ok(actualizada);
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return facturasService.buscarPorId(id)
                .map(factura ->{
                    facturasService.borrar(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
