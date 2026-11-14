package com.gestion360.erp.controller;

import com.gestion360.erp.model.ConfiguracionEmpresa;
import com.gestion360.erp.service.IConfiguracionEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configuracion_empresa")
public class ConfiguracionEmpresaController {

    @Autowired
    private IConfiguracionEmpresa configuracionEmpresas;

    @GetMapping
    public ResponseEntity<List<ConfiguracionEmpresa>> getAll(){
        List<ConfiguracionEmpresa> lista= configuracionEmpresas.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfiguracionEmpresa> getById(@PathVariable Long id){
        return configuracionEmpresas.buscarPorId(id)
                .map(configuracionEmpresa-> ResponseEntity.ok(configuracionEmpresa))
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<ConfiguracionEmpresa> create(@RequestBody ConfiguracionEmpresa configuracionEmpresa){
        ConfiguracionEmpresa nuevaConfiguracionEmpresa = configuracionEmpresas.guardar(configuracionEmpresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaConfiguracionEmpresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConfiguracionEmpresa> update(@PathVariable Long id, @RequestBody ConfiguracionEmpresa configuracionEmpresa){
        return configuracionEmpresas.buscarPorId(id)
                .map(configuracionEmpresaExistente ->{
                    configuracionEmpresa.setId_configuracion_empresa(id);
                    ConfiguracionEmpresa actualizada =  configuracionEmpresas.guardar(configuracionEmpresa);
                    return ResponseEntity.ok(actualizada);
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return configuracionEmpresas.buscarPorId(id)
                .map(configuracionEmpresa -> {
                    configuracionEmpresas.borrar(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }

}
