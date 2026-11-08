package com.gestion360.erp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_rol;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre_rol;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
}
