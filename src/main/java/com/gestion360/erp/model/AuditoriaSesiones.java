package com.gestion360.erp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "auditoria_sesiones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditoriaSesiones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_auditoria_sesiones;

    @NotBlank(message = "La acción es necesaria")
    private String accion;

    @NotBlank( message = "La IP del dispositivo es obligatoria")
    private String ip_dispositivo;

    private LocalDateTime fecha_hora;

    @NotNull(message = "El usuario es obligatorio")
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;

    @PrePersist
    protected void prePersist() {
        this.fecha_hora = LocalDateTime.now();
    }
}
