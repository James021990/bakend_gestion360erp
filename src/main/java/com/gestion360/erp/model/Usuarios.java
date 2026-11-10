package com.gestion360.erp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre_completo;

    @NotBlank(message = "El documento es obligatorio")
    private String documento;

    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    @NotBlank(message = "El telefono es obligatorio")
    private String telefono;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password_hash;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    private LocalDateTime fecha_creacion;

    @NotNull(message = "El rol es obligatorio")
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Roles rol;

    @PrePersist
    protected void prePersist() {
        this.fecha_creacion = LocalDateTime.now();
    }
}
