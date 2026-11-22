package com.gestion360.erp.controller;

import com.gestion360.erp.dto.LoginRequestDTO;
import com.gestion360.erp.model.Usuarios;
import com.gestion360.erp.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUsuariosService usuariosService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        if (loginRequest == null || loginRequest.getCorreo() == null || loginRequest.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("mensaje", "Debe enviar correo y contraseña"));
        }

        String correoLimpio = loginRequest.getCorreo().trim();
        Optional<Usuarios> usuarioOpt = usuariosService.buscarPorCorreo(correoLimpio);

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("mensaje", "Correo o contraseña incorrectos"));
        }

        Usuarios usuario = usuarioOpt.get();

        if (usuario.getPassword_hash() == null || !usuario.getPassword_hash().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("mensaje", "Correo o contraseña incorrectos"));
        }

        if (usuario.getEstado() != null && !usuario.getEstado().equalsIgnoreCase("ACTIVO")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(Map.of("mensaje", "El usuario no se encuentra activo"));
        }

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("id_usuario", usuario.getId_usuario());
        respuesta.put("nombre_completo", usuario.getNombre_completo());
        respuesta.put("correo", usuario.getCorreo());
        respuesta.put("estado", usuario.getEstado());
        respuesta.put("rol", usuario.getRol() != null ? usuario.getRol().getNombre_rol() : null);

        return ResponseEntity.ok(respuesta);
    }
}
