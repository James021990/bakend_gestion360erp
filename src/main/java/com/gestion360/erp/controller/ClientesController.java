package com.gestion360.erp.controller;

import com.gestion360.erp.model.Clientes;
import com.gestion360.erp.service.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    @Autowired
    private IClientesService clientesService;

    @GetMapping
    public ResponseEntity<List<Clientes>> getAll(){
        List<Clientes> lista = clientesService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> getById(@PathVariable Long id){
        return clientesService.buscarPorId(id)
                .map(cliente -> ResponseEntity.ok(cliente))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Clientes> create(@RequestBody Clientes clientes){
        Clientes nuevoCliente = clientesService.guardar(clientes);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> update(@PathVariable Long id, @RequestBody Clientes cliente){
        return clientesService.buscarPorId(id)
                .map(clienteExistente->{
                    cliente.setId_clientes(id);
                    Clientes actualizado = clientesService.guardar(cliente);
                    return ResponseEntity.ok(actualizado);
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return clientesService.buscarPorId(id)
                .map(cliente ->{
                    clientesService.borrar(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
