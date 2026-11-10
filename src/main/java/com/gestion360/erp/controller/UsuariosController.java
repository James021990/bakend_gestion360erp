package com.gestion360.erp.controller;

import com.gestion360.erp.model.Usuarios;
import com.gestion360.erp.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
    @Autowired
    private IUsuariosService usuariosService;

    @GetMapping
    public ResponseEntity<List<Usuarios>> getAll() {
        List<Usuarios> lista = usuariosService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getById(@PathVariable Long id) {
        return usuariosService.buscarPorId(id)
                .map(usuario -> ResponseEntity.ok(usuario))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuarios> create(@RequestBody Usuarios usuarios) {
        Usuarios nuevoUsuario = usuariosService.guardar(usuarios);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> update(@PathVariable Long id, @RequestBody Usuarios usuario) {
        return usuariosService.buscarPorId(id)
                .map(usuarioExistente ->{
                    usuario.setId_usuario(id);
                    Usuarios actualizado = usuariosService.guardar(usuario);
                    return ResponseEntity.ok(actualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return usuariosService.buscarPorId(id)
                .map(usuario -> {
                    usuariosService.eliminar(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
